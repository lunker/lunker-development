<<<<<<< HEAD
# SBC (Session Border Controller)

# 기능 7가지  
1) Topology Hiding
2) Media Traffic Management
3) Fixing Capability Mismatches
4) Maintaining SIP related NAT Bindings  
5) Access Control
6) Protocol Repair
7) Media Encryption  
8) NAT traversal  

---
#### Topology Hiding
- do not want ip addresses of equipment to be exposed to outside.

#### Media Traffic Management
- 주로 billing model 수립에 쓰인다.
- UA들 간의 message path에서 Signaling or Signaling + Media path를 SBC에 거치도록 한다.
- 그래서 media traffic을 monitoring 하여 필요 정보를 수집할 수 있다.
- 더불어 lost BYE issue도 해결한다.

#### Fixing Capability Mismatches  
- SBC가 sdp를 직접 수정하여 UA간에 media communication이 되도록 한다.

#### Maintaining sip related nat bindings
- NAT에 연결되어 있는 UA의 Connection이 끊어지지 않도록 한다.
- INVITE Response를 SBC가 전달할 때, Expire를 조정한다.
- Expire를 NAT binding Timeout시간 보다는 작게하여 NAT에서의 Client 연결이 풀리기 전에 다시 Register를 보내어 해당 NAT Binding을 유지시킨다.

#### Access Control
- 내부 네트워크를 보호하기 위함.
- SBC에 들어오는 traffic들 중 authorized 된 ua의 메시지만 들어오도록 한다.
- authorization 관련 정보는 다른 component로 부터 받아온다.(알아서 구현)
- unregistered user의 ddos 공격 방지, LB 등의 기능을 제공한다.

#### Protocol Repair
- 완벽하게 구현되지 않은 protocol을 보강한다.
- 보다 많은 client들을 지원하기 위함.
- protocol conversion과는 전혀 다르다.
- proxy와 유사하게 동작한다.

#### Media Encryption

#### NAT Traversal   
- 장비들이 NAT 뒤에서 private IP를 가지고 있다.
- 이 ua들이 호를 만들기 위해 발생하는 메세지들의 Contact, Via, SDP에는 private IP가 들어간다.



**@관련 이슈**
- SBC가 single point 이기에 가지는 문제점들  
- UA는 SBC가 수정한 message과 MITM의 구별이 어려움.
=======
# SBC
- Session Border Controller  
-

1. 소스 내려받음
2. Intellij 에서 import as maven project
3. restcomm-jboss 7 으로 사용
4. 기본적인 설정.




#### Configuration  

-



**IP Phone**  
- proxy : sbc의 ip address(10.0.1.69)
- ip phone에서는 일단 sbc로 바로 가야 하므로.


**SBC**  
-


**Proxy**  
-
>>>>>>> a436257459d3ea983775ef942fd4fc96cd6dbaee
