NAT
===

Cone NAT은 내부망의 ip:port가 destination에 관계없이 공유기의 외부 ip:port가 변하지 않는다.  
반면, symmetric NAT은 destination에 따라 공유기의 외부 ip:port가 달라진다.

1) Full Cone NAT - 들어오는 트래픽의 source ip, port에 대해 검사없이, nat table의 mapping대로 relay.

2) Restricted  
- IP만 체크 - 즉, private - public - external mapping이 생성되면, 오직 같은 external ip address를 가진 host만이 내부와 통신할 수 있다.

3) Port Restricted  
- IP와 Port 모두 체크한다. - 오직 같은 external ip:port 여야지 통신이 가능하다.

**참고**  
- http://www.nexpert.net/75
