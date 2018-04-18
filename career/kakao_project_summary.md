[voiceloco] 

- 프로젝트명:
- 시작일 : 2017년 5월 
- 종료일 : 
- 소속 회사명 
- 주사용기술 : 
- 프로젝트에 대한 소개 & 본인이 수행한 역할(1500자 이내): 

* Media Gateway
		
  <구축 및 개발 & 유지보수: Failover & Symmetric RTP 구현>
		- 프로젝트명:
		- 시작일 : 2017년 3월 
		- 종료일 : 2017년 6월
		- 소속 회사명: Voiceloco 
		- 주사용기술 : c/c++, Java, Redis, GStreamer, Webrtc
		- 프로젝트에 대한 소개 & 본인이 수행한 역할 :
			세종텔레콤프로젝트를 진행하면서 이기종 프로토콜 (SIP, Webrtc)간의 연동처리 및 미디어 트랜스코딩을 위한 Opensource Media Gateway를 구축하고 커스터마이징을 담당하였습니다.
		  세종텔레콤과 프로젝트를 진행하면서 SIP(통신 관련 Protocol), Webrtc 간의 연동을 해야했습니다. 프로토콜 규격과 미디어 처리하는 규격이 달랐기에 이를 처리해주는 Media GateWay가 필요헀습니다. 해당 기능을 구현한 H/W가 있었으나 가격대비 효율적이지 못한 성능으로 인하여 OpenSource Media Gateway가 필요헀습니다. Media Gateway를 구축하여 기존 SIP Proxy와 세종텔레콤의 SIP 연동을 처리하였고 추가적인 기능들을 구현하였습니다.

      관련 프로젝트에서 크게 세 가지의 기능을 구현하였으며 설계, 구현, 테스트 모두 진행하였습니다.
			1) 비즈니스 로직 구현을 위한 커스터마이징
			2) SymmetricRTP 구현 
				방화벽이나 Private IP를 가지는 device들은 외부에서 접근을 할 수 없습니다. 따라서 해당 네트워크에 존재하는 사용자와는 통화를 발생시키 수 없고, 이를 해결하기 위하여 NAT-Traversal의 방법인 SymmetricRTP를 구현하였습니다.
			3) Failover 구현 
				Media Gateway에 장애가 발생했을 경우, 해당 gateway를 사용하는 통화들은 전부 강제종료됩니다. 사용자 경험을 최소화하고자 Media Gateway에 redis를 사용하여 self-healing 기능을 구현하였습니다.


* SIP Monitoring System 
		- 프로젝트명: Message Flow Monitoring System 
		- 시작일 : 
		- 종료일 : 
		- 소속 회사명: Voiceloco 
		- 주사용기술 : NodeJS, MySQL, AngularJS, PHP
		- 프로젝트에 대한 소개 & 본인이 수행한 역할 : 
			분산 서버 환경, OPMD(One Person Multiple Devices) 환경에서 원활한 개발과 오류 추적을 위하여 Message Monitoring Tool을 구축 및 개발하였습니다.
			해당 어플리케이션을 구축하여 Frontend를 해결하였습니다. 기존의 pcap을 이용한 Network Traffic Monitoring 기반에서 Log기반으로 커스터마이징했습니다. 따라서 Application Server들의 Log를 수집하고 처리하는 NodeJS 기반의 Agent를 직접 개발했습니다. 유관 Application Server 담당자들과 Log Formatting을 위한 협의를 진행하였습니다.
			또한, 기존의 Opensource에서는 제공하지 않는 PUSH, REST API  history도 조회하도록 하여 하나의 통화에서 이루어지는 모든 Message들을 추적할 수 있게 개발헀습니다. 
			비정상적으로 수행된 비즈니스 로직에 대해서는 이메일 Alerting을 통해서 확인할 수 있도록 구현하였습니다.
	
	
* SIP Proxy Server 
		- 프로젝트명: 
		- 시작일 : 
		- 종료일 : 
		- 소속 회사명: Voiceloco
		- 주사용기술 : Java, Gradle, SIPServlet, Tomcat 
		- 프로젝트에 대한 소개 & 본인이 수행한 역할 : 
			SIP Proxy Server를 담당하여 Call 관련 부가 기능, Refactoring 및 성능개선을 진행하였습니다.
			단위 테스트 작성을 시작으로 기능 구현에 치우친 프로젝트에 대해 Refactoring을 진행하였습니다. Gradle script를 재작성하여 

 
* SIP Framework
		- 프로젝트명:
		- 시작일 : 
		- 종료일 : 
		- 소속 회사명 
		- 주사용기술 : Java, Netty, 
		- 프로젝트에 대한 소개 & 본인이 수행한 역할 : 
			Servelet기반의 SIP Framework들에서 벗어나 Message당Thread 의 구조가 아니라 Non blocking으로 처리하여 성능을 끌어올리고자 새로운 SIP Framework를 개발하였다. 


[433]
* Architecture 개선 
		- 프로젝트명:
		- 시작일 : 
		- 종료일 : 
		- 소속 회사명 : 네시삼십삼분
		- 주사용기술 : C#, Flatbuffer, 
		- 프로젝트에 대한 소개 & 본인이 수행한 역할 : 
			글로벌 서비스를 제공함에 있어 서버간 latency를 줄이기 위한 Prototype을 진행하였다. 실제 게임과 유사한 환경을 만들기 위하여 Binary Protocol, 게임 매칭 알고리즘까지 구현하였다.
      프로토콜 설계 및 매칭 알고리즘을 설계 및 개발 하였으며 Server component중에서 Matching Server를 담당하여 개발을 진행하였다.
			

	
[CJ]
* 사내 시스템 유지보수 및 업데이트 담당 
		- 프로젝트명:
		- 시작일 : 
		- 종료일 : 2018
		- 소속 회사명 : CJ올리브네트웍스
		- 주사용기술 : 
		- 프로젝트에 대한 소개 & 본인이 수행한 역할 : 
		그룹내의 IT 서비스를 제공함에 따라 관련 Billing을 처리하는 시스템을 운영하였습니다. 

	

