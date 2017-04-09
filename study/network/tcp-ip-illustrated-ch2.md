# 7. Firewalls and Network Address Translantion  (NAT)




## 7.2 Firewalls  
-

### 7.2.1 packet-filtering firewalls
- drop datagrams that meet specific criteria.
- internet router와 traffic filter의 기능을 한다. packet의 header를 검사하여 특정 조건에 맞는 패킷들을 버리거나 forwarding 한다.  
- stateless와 stateful이 존재.
- incoming rule/outgoing rule이 존재한다.  



### 7.2.2 Proxy Firewalls
-




## 7.3 Network Address Translation  
- 2가지 문제를 해결하기 위해 도입됨.
  - address depletion
  - scalability of routing


- Routing scalability was being tackled with the development of Classless Inter-Domain Routing
- globally routable internet address를 줄이고, 어느정도의 firewall 기능을 수행하기 때문에 많이 사용됨.
- nat의 활성화가 ipv6의 도입을 늦추게 되었고, ipv6가 도입되면 nat는 사라지게 될것이다.  
- NAT는 몇가지 결점을 가지고 있다.
   - application-layer의 payload에서 ip address를 담아서 전송하는 protocol에 문제를 발생시킨다. (ftp, sip이 그 예)

-**NAT 동작방식**
  - router를 통해 이동하는 packet의 정보를 rewriting한다.
  - nat outgoing packets의 source 정보를 nat의 정보로 바꾸어서, public internet에서 볼때 nat outgoing packet이 globally routable ip address로 보이도록 한다.

### 7.3.1 Traditional NAT: Basic NAT and NAPT
- Traditional nat는 private ip를 nat에 할당되어 있는 globally public ip들 중 하나를 할당하여 변경하여 내보낸다. 그래서 ip 고갈 문제를 해결하지 못했다.
- 그래서 NAPT를 이용하여 transport layer의 식별자를 사용하여 nat뒤에 있는 host들을 식별한다. 예를들면 tcp, udp의 port, icmp의 query identifiers 등이 있다. 그래서 nat 내에 있는 수십, 수백, 수천의 host들이 하나의 nat' public address를 통해서 운영할 수 있다.  
- 그래서 일반적으로 말하는 NAT의 개념은 basic NAT + NAPT 를 합친 개념이다.  
- private ip address로 사용할 수 있는 대역폭이 예약되어 있다.
  - 10.0.0.0/8
  - 172.16.0.0/12
  - 192.168.0.0/16
- nat는 firewall과 비슷한 정도의 보안 기능을 제공한다.
  - nat뒤의 system들은 외부에서 접근할 수 없다.
  - 그래서 nat의 일반적인 정책은 다음과 같다. :: outgoing을 다 내보내고, outgoing에 대한 returning traffic의 접근을 허용한다. 하지만 nat로 들어오는 새로운 incoming new connection request들은 차단한다.  
- "topology hiding"




#### 7.3.1.1 NAT and TCP
- tcp는 ip와 port로 end of connection을 식별한다.
- connection은 combination of two ends로 구별된다.
- private host가 tcp connection을 열려고 하면,
  - tcp SYN packet이 보내어진다.
  - (pip:pport;dip:dport) 로 connection이 식별된다.
  - nat가 이 packet을 바꾸면, pip,pport를 nip,nport로 바꾸어서 내보낸다. 그리고 이 mapping정보(state)가 최초이기에 저장하고 있는다.

- outgoing SYN를 발견하면, nat에서 **connection timer**를 작동시킨다. 그리고 timer가 만료될 동안 ACK를 받지 못하면 nat session이 만료된다.
  - ACK를 받고나면 connection timer는 지워지고, session timer가 생성된다.
  - session timer가 생성되고 나면, nat는 internal endpoint에게 additional packet을 보낸다. session이 정말로 살아있는지 체크하기 위함이다. nat가 ack를 받으면, internal endpoint가 살아있는 것으로 간주한다.  
- tcp에서 keepalive packet을 보내서 연결이 유지되는지를 체크한다. 이 keepalive는 2시간에 한번씩 보낸다.
- nat에서 운영되는 peer-to-peer application은 simultaneous open을 고려해야한다.!

#### 7.3.1.2 NAT and UDP  
- tcp와는 달리 connection을 맺고, 끊기 위한 과정이 없다.
- tcp와는 달리 syn, fin, rst packet이 없다.
- tcp와는 달리 2개의 endpoint address/port 조합으로 식별한다. (tcp는 srcip,srcport, dstip, dstport 이 4개로 구분한다.)
- udp nat는 mapping timer를 유지하고 있다.  


### 7.3.2 Address and Port Translation Behavior
- behavior 종류
  - endpoint-independent mapping
  - address-dependent mapping
  - address and port dependent mapping  
- tcp,udp를 포함한 일반적인 protocol은 endpoint-independent mapping을 원한다.

- **nat pool** :: nat에서 사용가능한 external addresses
  - 만약 nat pool이 존재한다면(nat에서 사용가능한 external address가 여러개 일 경우),하나의 host가 여러개의 connection을 맺을 때, 각 connection의 external ip는 동일한 걸로 할것인가? 하는 문제가 있다.



### 7.3.4 Servers behind NATS
- server가 nat뒤에 있게 되면, 외부에서 직접 접근할 수 없기 때문에 문제가 발생한다.
- port forwarding, port mapping을 이용하여야 한다.
  - port forwarding :: nat의 static configuration이 필요하다.


### 7.3.5 Hairpinning and NAT Loopback
필요없을듯.

## 7.4 NAT Traversal
### 7.4.1 Pinholes and Hole Punching  
**""pinhole"**
- nat mapping이 만들어지면, 해당 application에 관련된 traffic은 nat의 outgoing, incomming 모두 이동이 가능하다.
- 하지만 nat mapping은 execution동안에만 유효하다. 즉, 임시적인 traffic flow에 대해서만 허용된다.

**"hole-punching"** (about peer to peer behind nat clients')
- nat 뒤에 있는 여러대의 system들이 pinhole을 통해서 직접 통신하는 방법.
- nat뒤의 client들이 public server에 접속한다. public server에서는 connection을 통해서 각 client들의 external information을 알 수 있다.
- each client's external information을 client들에게 나눠주면, clients behind nat 들이 통신할 수 있다.  
