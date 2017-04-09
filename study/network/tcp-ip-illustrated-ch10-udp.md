# 10. UDP and IP Fragmentation



## 10.2 UDP header
- 같은 port number에 대해서 tcp, udp가 둘 다 사용할 수 있다.
- udp length = udp header + udp payload


## 10.3 UDP Checksum


## 10.7 IP Fragmentation
- IP Layer에서 전송할 ip datagram을 받으면, datagram이 전송될 interface를 결정한다.
- interface의 mtu 사이즈와 datagram의 사이즈를 비교하여 Fragmentation을 수행한다.
- IPv4에서 Fragmentation은 sender host와 중간에 있는 router에서 모두 발생할 수 있다.
- 하지만 ipv6는 오직 source만이 Fragmentation을 수행할 수 있다.  
- Fragmentation이 일어나면, destination host에 도달하기 전까지는 재조합되지 않는다.



### 10.7.1 UDP/IPv4 Fragmentation
- fragment중 하나가 손실되면, 전체 datagram이 손실되기 때문에 성능 이슈가 일어난다.
- 
