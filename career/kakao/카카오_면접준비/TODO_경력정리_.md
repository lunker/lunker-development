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

	***
	- 프로토콜 설계 
		- header :

			- fixed header size 
			[구조]
			- message length
			- srcType, srcCommand
			- dstType, dstCommand로 구성 
				
		- body : 
			- flatbuffer를 사용하여 payload 처리 
	- 매칭 알고리즘	
		- docs 참고 ㅠㅠ 

	- binary protocol 

--- 
** MediaGateway

1) 커스터마이징 & 라이브러리 관리 
  -> 서버쪽에 자원해제 관련한 추가 기능을 개발하였고, MediaGateway를 사용하기 위한 Java Client Library에 추가 기능을 구현하여 사내 nexus repository에 관리. 
 
	서버에서 Java Client Library를 통해 Media Gateway를 사용합니다. 해당 Client Library를 통해서 Media Gateway와 Websocket connection을 유지하고 있다. 
		(1) 비정상 로직으로 인한 해제 실패시, 남아 있는 MediaElement 정리로직 

		(2) EventHandler 한번에 해제 
			-> eventhandler가 살아 남아있게 되면, 관련 event를 보내기 위해 사용하는 Websocket또한 살아 남아 있게되어 자원이 점차 고갈되는 상황이 벌어진다.

이때, client를 사용해서 만든 객체들에 대해서 이벤트 리스너를 등록할 수 있다. 해당 객채에서 발생한 이벤트가 client를 통해서 받아올 수 있다.
해당 객체의 사용이 끝난 후, destroy()를 할 수 있는데, 객체에 대한 destroy()와 해당 이벤트 리스너가 별도로 관리되고 있었다 
그래서 해당 객체의 사용이 끝남을 알리는 destroy()에 의해 관련된 이벤트 리스너들을 삭제시키는 로직을 추가하였다. 

MediaGateway에는 websocket connection당 unique id(connection id)를 부여하여 관리하고 있다.

<TODO>
???? Client session id와 거기에서 생성된 객체 간의 연결 관계는 ??? 
	=> std::map<std::string, std::map <std::string, std::shared_ptr <MediaObjectImpl>>>
  childrenMap;
</TODO>

MediaGateway에는 이벤트 리스너 당 unique id(listener id)를 부여하여 관리하고 있다. 

그래서 해당 객체를 삭제하기 위해서는 Java Client에서 저장하고 있는 session id와 해당 객체에 대한 unique id를 통해서 media gateway에서 삭제를 시킨다. 

그리고 이벤트 리스너를 삭제하기 위해서는 event listener unique id를 별도로 저장하고 있다가, 이벤트 리스너를 삭제하는 요청을 별도로 media gateway에 발생시켜야 한다. 

그래서 object<->event listener간에 mapping을 시켜서 object destroy시에 연관된 listener들도 삭제되도록 시켰다. 


그리고 Official Java Client Library를 직접 수정해서 사용하지 않고, wrapper를 만들어서 별도의 Custom java client library를 만들었다.
혹여나 버전의 변경에 따라 영향도를 줄이기 위해서, wrapper로 구현하여 사용하였다. 

	- 비정상적으로 종료되어 남아있는 resource 해제 


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
		

	<TODO>
		RTP & UDP & TCP 의 특징 정리 
	</TODO>
3) failover 구현 
	- rtp의 특성상, binding 된 udp socket이 사라져도 에러를 발생시키지 않는다. 
	- 따라서, media gateway가 생성한 udp socket, 객체 정보를 저장하고 이를 다시 생성하면 끊겼던 RTP Stream을 다시 생성할 수 있다.
	- failover 구현을 위하여 keepalived, redis를 사용하였다.
	- Media Gateway를 2대 구성한다. Master, standby로 구성한다. 
	- Keepalived의 vip를 master가 사용한다. keepalived가 media gateway의 health check를 진행하다가 media gateway의 응답이 없으면, vip를 backup에게 넘겨준다. 이때 backup이 master로 승격하면서 script를 실행한다. script를 통해 java application이 구동되고 redis에 저장되어 있던 정보들을 이용하여 Java Client Library를 사용하여 media stream을 재생성한다.
	- 이 과정에서 초기 media stream과정과 동일하게 처리를 하게 되면 에러가 발생하게 된다. 
		-> create offer, process offer의 개념을 설명 ! 

4) Monitoring application 
  -  java client library에 제공되는 통계 관련 api들이 있다. 각 통화 당 주고 받은 패킷 수. 이 api들을 사용하여 각 media gateway에서 발생하고 있는 call의 현황을 모니터링 할 수 있는 SPA를 개발했다.
	- caller, callee의 정보, 


[어려웠던 점]

*
- 실제 관련 이론과 가능하다는 자료는 있지만 실제 구현 사례나 테스트된 내용을 찾기 어려웠다.
- 무턱대고 실행할 수는 없었기에, 해당 상황과 특징을 최대한 유사하게 구현하여 가능성을 검증하였다.

- 써본 적 없던 언어사용과 실제 구현 가능한 이론인지에 대한 검증이 부족한 채로 시작했었음 
- 그래서 udp client & udp server를 프로토타이핑하여 실제 failover가 가능한지 검증해보았음. 
- 그리고 symmetric rtp또한 server를 public 도메인에 올려놓고 client를 private ip에 연결 시켜놓은 채, server에서 client의 address를 디버깅하여 실제 가능한가 검증해봄
그리고 이를 위해 실제 보이는 address로 변경하여 전송해도 가능한가 테스트함 

---
* Homer5 (SIP Monitoring System) 
->
프로젝트 수행 역할 분산 서버 환경, OPMD(One Person Multiple Devices) 환경에서 원활한 개발과 오류 추적을 위하여 Message Monitoring Tool을 구축 및 개발하였습니다. 해당 어플리케이션을 구축하여 Frontend를 해결하였습니다. 기존의 pcap을 이용한 Network Traffic Monitoring 기반에서 Log기반으로 커스터마이징했습니다. 따라서 Application Server들의 Log를 수집하고 처리하는 NodeJS 기반의 Agent를 직접 개발했습니다. 유관 Application Server 담당자들과 Log Formatting을 위한 협의를 진행하였습니다.

		또한, 기존의 Opensource에서는 제공하지 않는 PUSH, REST API history도 조회하도록 하여 하나의 통화에서 이루어지는 모든 Message들을 추적할 수 있게 개발했습니다. 비정상적으로 수행된 비즈니스 로직에 대해서는 이메일 Alerting을 통해서 확인할 수 있도록 구현하였습니다.

	**
		- OPMD의 개념: ok 
		- 분산서버의 구조 (lb-proxy의 관계) : ok
		- Homer5의 구조 :ok 
		- sip-agent 관련 로직. . . . (file rotating) 
		- push, rest api call history 관련 :ok
		- DB 구조 : 
		- email alerting : ok 

		* OPMD :: 
			- One Person Multi Device으로, 한명의 유저가 여러개의 단말을 이용하는 시나리오를 말한다. 
			- 하나의 Request에 대해서 여러개의 부가적인 Request가 발생하게 된다. 하지만 각각의 Request들은 하나의 시나리오에 묶여 있으므로, 이를 하나로 시각화 할 필요가 있다.
		* 분산 서버의 구조 
			- Stateful Server & Sticky Session을 가지는 서버이다.
				Server side에 client와 server의 상태정보를 저장하는 형태 
			- 이를 위해 Server가 가지고 있는 Client State정보들을 Redis에 동기화 시켜놓는다. 


		* Homer5의 구조  
		- ok.
		- 초기 opensource의 구조는 UI - proxy server - db 의 구조를 가지고 있었다.
		- signaling을 담당하는 proxy server에서 비즈니스 로직을 처리하고 해당 메세지를 직접 parsing하여 db에 insert하는 형식이었다.
		-	하지만 기존 proxy에서 추가적인 db  i/o를 넣기에는 부적절하다고 판단, (성능) 직접 db 작업을 처리하지 않고 
			각 application들이 남기는 log를 수집하여 proxy-server에 전송하여 insert 시키는 구조로 변경하였다.
			이 과정에서 log를 수집하고 정재하는 agent가 필요하였다. 

		* sip-agent 
		- pcap을 이용하여 packet capture를 하여 해당 메세지를 parsing하는 방식의 Agent에서 Log기반으로 변경하였다.
		- 주기적으로 application log의 file size를 구하여, file size의 변화가 있으면 변화분에 대해서만 파일을 읽어들인다.
		- 그리고 application log에서 flow에 필요한 부분을 파싱한다.
		-	[Log Fomrat]
			- [time_stamp][method][source url][dest url]\n{msg}
		
		[트러블 슈팅!] :: 실제 전송된 메세지가 UI에서 누락되어 client- server 팀 간에 혼선이 빚어졌다. 또한, 메세지가 존재하여도 내용이 일부 누락되는 현상도 발생하였다. 

		- 그리고 Application Log의 경우 DailyRotate 또는 FileSize base rotate가 일어나면 파일명이 바뀔 수 있다. 또한, timer에 의해 파일을 읽어들이므로 해당 시점에서 읽어들인 로그가 application log format의 일부만 들어 있을 수 있다. 
		그래서 이를 해결 하기 위하여 1 event에 의해 읽어들인 log chunk에 대해서 parsing을 시도한다. 그리고 정해진 log format에 의해 검색된 내용이 없으면, 해당 log chunk를 cache해 두고 다음 event에 읽어들인 log chunk와 합쳐서 parsing을 시도한다. 

		* REST, PUSH history 추가 
		- 개발 및 운영시에 발생되는 장애나 이슈에 대해서 파악할 시에 REST, PUSH의 누락 여부를 확인하기 위하여 클라이언트 측에서 로그 확인 요청이 잦았다. 


		* Email alerting 
		- 시스템 장애는 아니나, 비즈니스 로직 중 발생된 예외 케이스에 대해서 모니터링 및 추적이 필요하였다.
		- 그래서, 비정상적으로 이루어진 use case에 대해서 이메일 알림을 설정하였다. 
		- 기대되는 시나리오로 종료되지 않은 시나리오의 id를 메일로 전송한다. 
		- 별도의 SMTP Server를 구축하지 않고, Gmail Server를 이용하여 이메일 알림을 설정하였다. 

---

* Proxy 
-> 
	**** 
	- refactoring 
	- 성능개선 
	- java 8 
	- java 9 
	- 단위테ㅐ스트 (tdd) 
	- call 관련 기능 


	* Refactoring 
	- 하드코딩 되어 있는 설정값들 property화 
	- 중복되어 있는 로직 메서드화 
	- 충분한 의미를 나타내지 않는 변수명 변경 
	- 비즈니스 로직을 명확하게 하기 위하여 if-else 분기 통/폐합 
	

	* 성능개선 
	- reflection을 통해서 함수 호출을 하던것을 method call로 전환함 
	- rest 호출을 줄이기 위해 api 통합 


	* 유닛테스트 
	- Util 성격의 method에 대해서는 유닛 테스트를 진행. 
	- 기능 수정 후 배포를 위해서 기존 비즈니스 로직을 전부 직접 수행했어야 했다. 이렇게 반복되는 작업과 배포에 대한 부담으로 인하여 테스트를 고민하였다. 
	- SIP 프로토콜에서 쓰이는 sipunit을 사용하여 간단한 비즈니스 로직에 대해서는 테스트를 작성하였다.
		- sipunit:: 가상의 client로 작동할 수 있도록 signaling을 구현되어있다.
	- 여기에 sip에서 주로 사용되는 sipp라는 테스트 툴을 이용하여 sip에서의 일반적인 시나리오에 대해서는 커버할 수 있었다. 
	- 전체 use case에 대해서 자동화 테스트를 이루지는 못하였지만 일정부분 해소하여 어느정도의 부담을 덜 수 있었다. 


	* Call 관련 부가기능 
	- '통화중 대기', '방해금지'
	-> 통화중 대기는 통화중에 수행할 수 있는 기능으로 상대방과의 통화를 중단하고 다른 미디어 세션을 맺을 수 있는 상태이다.	
		이를 위해서는 
	-> 방해 금지는 통화 요청이 들어왔을 때, callee가 방해금지 상태인지 확인 후 그에 맞게 메세지를 처리한다. 


[어려웠던 점]
	- 여러가지기능들이 추가되다보니, 기존 소스코드의 양이 방대하여 추가 기능개발이라던가, 디버깅이 어려웠다 
	- 그래서 서비스 분리를 준비중이다. 
		- as-is proxy: call처리 + registrar + media처리 
		- to-be : call처리 / registrar / media처리 


---

* SIP Framework 

	***
	- 기존 SIP Servlet의 문제점	
	- reactive, non-blocking의 개념 
	- akka or spring reactor 
	- actor model 

	* 기존 servlet의 문제점 
	- 여러가지 비즈니스 로직이 들어감에 따라 rest 통신이 많아지게 되었다. 

	* reactive, non-blocking의 개념 
	- ok

	* actor model 
	- behavior, state, mailbox로 구성된 actor를 기본 단위로 하는 message processing을 이용하여 behavior를 비동기적으로 실행하는 model이다.
	- 각 actor간에는 서로 공유하는 자원이 없고, 서로간의 state를 건드릴 수 없고, 오로지 message를 이용해서만 간섭할 수 있다. 

	- message는 mailbox에 쌓였다가 들어온 순서대로 처리된다. 
	- actor는 message를 보낸 context와 독립적인 context에서 비동기적으로 실행된다.
