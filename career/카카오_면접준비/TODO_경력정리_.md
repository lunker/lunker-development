- 목적 
- 사용한 기술에 대해서 상세하게 (기술명이 아니라 어떠어떠한 기술을 어떤 이유로 사용했는지) 

- 맡은 역할 

- 주요한 로직 
	- 왜 그렇게 했고 
	- 대안은 없었는지 
	- 고친다면 어떻게 고치는게 좋은지 등 
	- 수도코드 

---
** 4:33

- 목적
  글로벌 서비스를 제공하기 위하여 여러개의 Region에 서버들이 배포되어있다.
  이 가운데에서 서버 간 latency를 줄이기 위해 


--- 

** MediaGateway

1) 커스터마이징 & 라이브러리 관리 
  -> 서버쪽에 자원해제 관련한 추가 기능을 개발하였고, MediaGateway를 사용하기 위한 Java Client Library에 추가 기능을 구현하여 사내 nexus repository에 관리. 
 
	서버에서 Java Client Library를 통해 Media Gateway를 사용합니다. 해당 Client Library를 통해서 Media Gateway와 Websocket connection을 유지하고 있다. 
이때, client를 사용해서 만든 객체들에 대해서 이벤트 리스너를 등록할 수 있다. 해당 객채에서 발생한 이벤트가 client를 통해서 받아올 수 있다.
해당 객체의 사용이 끝난 후, destroy()를 할 수 있는데, 객체에 대한 destroy()와 해당 이벤트 리스너가 별도로 관리되고 있었다. 
그래서 해당 객체의 사용이 끝남을 알리는 destroy()에 의해 관련된 이벤트 리스너들을 삭제시키는 로직을 추가하였다. 

MediaGateway에는 websocket connection당 unique id(connection id)를 부여하여 관리하고 있다.

<TODO>
???? Client session id와 거기에서 생성된 객체 간의 연결 관계는 ??? 
</TODO>

MediaGateway에는 이벤트 리스너 당 unique id(listener id)를 부여하여 관리하고 있다. 

그래서 해당 객체를 삭제하기 위해서는 Java Client에서 저장하고 있는 session id와 해당 객체에 대한 unique id를 통해서 media gateway에서 삭제를 시킨다. 

그리고 이벤트 리스너를 삭제하기 위해서는 event listener unique id를 별도로 저장하고 있다가, 이벤트 리스너를 삭제하는 요청을 별도로 media gateway에 발생시켜야 한다. 

그래서 object<->event listener간에 mapping을 시켜서 object destroy시에 연관된 listener들도 삭제되도록 시켰다. 


그리고 Official Java Client Library를 직접 수정해서 사용하지 않고, wrapper를 만들어서 별도의 Custom java client library를 만들었다.
혹여나 버전의 변경에 따라 영향도를 줄이기 위해서, wrapper로 구현하여 사용하였다. 


2) symmetric rtp 구현 
	-> 방화벽이나 Private IP를 가지는 device들은 외부에서 접근을 할 수 없습니다. 따라서 해당 네트워크에 존재하는 사용자와는 통화를 발생시키 수 없고, 이를 해결하기 위하여 NAT-Traversal의 방법인 SymmetricRTP를 구현하였습니다.

	우선, SBC라는 장비가 필요합니다. 필요한 이유는 크게 2가지 입니다. webrtc라는 것을 사용하는 단말은 음성을 암호화 시키고, 일반 단말에서는 음성을 암호화 시키지 않습니다. 그래서 이 2가지를 중간에서 transcoding해줘야 합니다.
	그리고 두번째로는 내부망에 접속해 있는 단말들간의 Relay를 위해서입니다.

	제가 사용한 Media Gateway는 transcoidng과 relay를 지원하지만,  
 

	통화를 하기 위한 Signaling 시에 자신이 통화를 위해 사용할 Ip, Port, Media codec에 대한 정보를 교환합니다. 하지만 이때에, webrtc를 지원하는 voip의 경우가 아니라면 현재 자신이 부여받은 ip를 그대로 사용합니다. 해당 단말에서는 자신이 사용하는 ip가 private ip인지, 외부에서 접근 가능한 public ip인지 체크를 하지 않습니다. 그리고 Media Gateway는 해당 Signaling에서 교환 된 Ip, Port, Media Codec을 기반으로 Relay를 시도하기 위해 Connection을 맺으려고 시도합니다.


	그렇기에 private ip가 입력되게 되면, 한쪽 방향으로의 media가 흐르지 못하게 되어 정상적인 통화가 이루어지지 못하게 된다. 
	그래서, 이를 해결하기 위해 Symmetric RTP라는 방법을 구현하였다. 
	우선 RTP는 udp를 사용한다. 



	Relay서버가 Client에 먼저 보내지는 못하지만, Client는 Relay 서버에 패킷을 날릴 수 있다. 
	이때 Relay서버가 패킷을 받으면, socket의 정보를 통해 remoteAddress를 알 수 있다. 해당 remoteAddress가 실제 접근 가능한 address 이므로,
	이후 Relay서버가 받은 패킷을 모두 이쪽으로 흘려주면 통화가 이루어진다. 


	이를 위해서 아래의 방법을 사용하였다.
		
	<TODO>
		Gstreamer에서 socket, connection을 관리하는 방법 수도 코드로 기록 
	</TODO>
	gstreamer -> media server -> 	
		

3) failover 구현 
	-
4) Monitoring application 
  - 



---
* Homer5 (SIP Monitoring System) 
->
프로젝트 수행 역할 분산 서버 환경, OPMD(One Person Multiple Devices) 환경에서 원활한 개발과 오류 추적을 위하여 Message Monitoring Tool을 구축 및 개발하였습니다. 해당 어플리케이션을 구축하여 Frontend를 해결하였습니다. 기존의 pcap을 이용한 Network Traffic Monitoring 기반에서 Log기반으로 커스터마이징했습니다. 따라서 Application Server들의 Log를 수집하고 처리하는 NodeJS 기반의 Agent를 직접 개발했습니다. 유관 Application Server 담당자들과 Log Formatting을 위한 협의를 진행하였습니다.
		또한, 기존의 Opensource에서는 제공하지 않는 PUSH, REST API history도 조회하도록 하여 하나의 통화에서 이루어지는 모든 Message들을 추적할 수 있게 개발했습니다. 비정상적으로 수행된 비즈니스 로직에 대해서는 이메일 Alerting을 통해서 확인할 수 있도록 구현하였습니다.

	**
		- OPMD의 개념
		- 분산서버의 구조 (lb-proxy의 관계) 
		- Homer5의 구조
		- sip-agent 관련 로직. . . . (file rotating) 
		- push, rest api call history 관련  








