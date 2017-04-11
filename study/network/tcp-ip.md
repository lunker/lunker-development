# TCP  

- 시스템콜을 호출하면, 그때부터는 커널이 해당 작업을 직접 처리한다.  
- 작업이 끝나면 유저모드로 돌아간다.(== 어플리케이션으로 제어권이 넘어간다.)
- <IP Layer>
  - tcp segment에 ip header를 추가하고, ip routing을 한다.
  - ip routing :: destination ip주소로 가기 위한 다음 장비의 ip를 찾는 과정.  

- <Ethernet layer>
  - arp를 사용하여 next hop ip의 mac주소를 찾는다. 그리고 ether header를 패킷에 추가한다.
- nic는 패킷 전송 요청을 받고, 메인 메모리에 있는 패킷을 자신의 메모리에 복사한다. 그리고 네트워크 선으로 전송한다.






**참고**  
- tcp/ip 네트워크 스택 이해하기 :: http://d2.naver.com/helloworld/47667
