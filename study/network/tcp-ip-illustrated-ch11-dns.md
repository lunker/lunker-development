# 11. DNS


## 11.1 Intro
- host names은 "name resolution" 과정을 통해 ip address로 변환한다.
- DNS는 tcp/ip app에서 사용하는 host name과 ip주소를 mapping 시켜놓은 client/server networked database.
- dns 접근은 'resolver'라는 application library를 이용한다.
- 일반적으로 app에서는 tcp connection을 열기전에 또는 udp datagram을 보내기 전에 host name을 ipv4, ipv6로 변환한다.
- **tcp,ip는 host name으로 작동하지 않고 무조건 ip address로 작동되도록 구현되어 있다.**  


## 11.2 DNS Name Space
- dns에 있는 name들은 "dns name space"로 구성되어있다.
- name space는 계층구조를 가진다.
- top name space = "top-level domains(TLD)"



## 11.3 Name Servers and Zones  
- dns name space를 관리하는 조직은 적어도 2개 이상의 name server를 운영해야한다.
- 그래서 이 name server에 유저들이 query를 할 수 있다.
- zone = unit of administrative delegation
- zone은 dns name space의 subtree이다.
- dns server는 1개 이상의 zone을 가지고 있다.
-


## 11.4 Caching
- name server는 name to ip address mapping과 같은 정보들을 가지고 있다.
-


### 11.5.3 udp or tcp

- tcp, udp는 well-known port 53으로 dns를 위해 사용한다.
-
