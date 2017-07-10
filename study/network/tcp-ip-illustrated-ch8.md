# ICMP  

- ICMP는 tcp나 udp를 사용하여 ip layer에서 제공된다.  
- icmp는 ip layer에 reliability를 제공하는 것이 아니다.  
- ICMP는 error의 원인, control message
- icmp가 막혀있다면, 일반적인 진단 유틸리티들 (ping, traceroute) 들이 제대로 동작하지 않는다.  
-


### 8.1.1 Encapsulation in IPv4 and IPv6  
- icmp 메세지는 ip datagarams에 담겨서 전송된다.  
-


## 8.2 ICMP Messages  
- icmp message는 크게 2개의 카테고리로 분류된다.  
  - relating problems with delivering IP datagrams (called error messages)
  - related to information gatehring and configuration (called query or informational messages)

- 
