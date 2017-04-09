SIP (RFC 3261)
==============

-	Session Initiation Protocol
-	미디어 패킷을 송수신하기 위한 플로우를 설립하는 것이 목적.  
-	여러 사람들과의 통신과 세션의 생성, 변경, 종료에 대한 application layer protocol

-	여러 사람들과의 통신을 하기 위해서 필요한 요소(parameter)로 5가지가 있다. (다른 사람들과 통신하기 위해서 필요한 정보들)

-	하나 또는 그 이상의 참가자와 멀티미디어 **세션**의 생성, 변경, 종료에 대해 정의되어 있다.

-	Signaling을 하기 위해 정의된 프로토콜.

-	**Signaling** : 통신을 하기위해 무언가 주고 받는 것 ?

1) User Location 2) User Availability 3) User Capabilities 4) Session Setup 5) Session Management

-	SIP가 동작하기 위해서는 다른 protocol과 함께 사용되어야함.

-	proxy server를 거칠 때 마다 via에 거쳐간 proxy server의 정보가 추가된다.

-	4가지 type의 logical SIP entities로 구성되어있다. 각 entity는 client, server 각각 혹은 두 가지 모두로 기능할 수 있다.


SIP Component
=============

-	UAC : client application that initiate SIP request.  
-	UAS : server application that contacts the user
-	Proxy server : 중간에서 양측 client를 대신하여 request를 전달한다. server, client의 역할을 함. request message를 보내기전에 수정할 수 있다.  
-	redirect server : 요청 메세지를 ua나 proxy server에 직접 전달하지 않고, 재전송 해야 할 곳의 위치를 알려주기만 한다. request message를 전달하는것이 아니다! SIP request를 보고 해당 address에 맞는 새로운 주소를 찾아서 준다.  
-	registrar : server that accept **REGISTER** request.  

Session의 의미
==============

-	Internet multimedia conferences
-	internet telephone calls
-	internet video sessions(영상전화)
-	단순히 전화를 걸고 받기 위한 시그널링이 아니다.

SIP Response
============

#### Type

-	Provisional (1xx classe) : 작업중인 상태들
-	Final(2,3,4,5,6xxx classes)  

### classes

-	100 ; trying . . .
-	200 ; ok
-	488 ; not acceptable here

등록과정 (p.10)
===============

-	모든 단말들이 다른 단말들의 위치를 가지고 있을 수 없기 때문에, proxy server가 필요하다.
-	proxy server가 단말들의 현재 위치를 확인할 수 있다.
-	즉, address-of-record uri <-> Contact address를 바인딩. -

SIP 패킷의 구조
===============

-	ip header + udp header + sip header + sip message body

SIP Message
===========

-	START LINE
-	HEADERS
-	BODY
-	3가지 부분으로 구성되어 있다.  

#### START LINE

-	messsage type, protocol version 을 가지고 있다.
-	request line / status-line 2 가지가 된다.

#### HEADERS

-	http header field와 유사하게 name:value로 이루어져 있다.  
-	via, contact, route 등의 field가 있음.

#### body

-	session에 대한 정보 등이 해당된다.
-	sdp, mime 등

SIP Methods (p.36)
==================

**Response**  
- acceptable ; 요청을 승인하고 200 ok를 송신  
- reject ; 요청을 거절하고,사유에 따른 Response를 송신  
- redirect ; 요청을 수신할 다른 주소를 송신

**주요 메소드(Request)**  
- Invite  
- ack  
- bye  
- cancel  
- options : UA 또는 sip proxy의 capability를 확인할 수 있다.  
- register

### INVITE



### CANCEL (p.39)(rfc3261 - p.53)

**일반적인 CANCEL**  
- Request를 취소할 경우에 사용.  
- Response가 발행되었으면(UAS가 200 ok를 발행하였다면) CANCEL할 수 없다. 이때에는 BYE를 사용해야 한다.  
- 그래서, UAS의 응답의 긴 경우에 사용한다.

-	예를 들어, 200 ok를 수신했다면 이미 통화중인 상태 이므로 bye 메소드를 사용해야한다.  

**Call Forking에서의 CANCEL**

### REGISTER(p.44, 68 )

**AOR(Address of Record)**  
- 외부 도메인에서 현재 통신하려는 사용자  
ex) bob@bioloxi.com

**Contact Address**  
- 등록된 단말의 특정 주소  
ex) bob@phone66.biloxi.com

-	header의 expires 필드를 통해 ua의 정보를 얼마동안 유지할지 설정한다.  
- **contact address(실제 단말의 주소)와 address of record(사용자 식별용 주소)를 바인딩 하는 과정.**  

**Register 및 auth 과정**  
- REGISTER sip message를 registrar server에 전송  
- registrar는 401 or 407 unauthorized + nonce값을 클라이언트에 전송한다.  
- client는 서버에게 받은 nonce값과 자신이 가지고 있는 값을 공식을 토대로 변형하여 서버측에 response 값을 전송한다.  
- 서버는 요구한 값이 올바르면 클라이언트에게 200ok를

SIP URI
-------

-	다양한 sip uri scheme이 존재함.
-	sip:user@host or sip:user@host.port or



# SIP Digest Access Authentication  
(http://www.nexpert.net/276)  

- invite, register 등의 요청에 대해서 서버는 nonce라는 난수 문자열을 생성하여 전송한다.  
- 이에 대해 UAC는 이름, 암호 및 nonce를 포함하는 md5 hash로 응답한다.  
- invite에 대해서는 407 proxy auth req 에러 메세지를 전송한다.  
register나 redirect의 경우에는 401 unauthorized
- 만약 proxy server가 1대가 아니라 여러대가 있다면, 각각에 대해서 UAC가 다 인증을 거쳐야한다.  
-



---

Chapter 7. RFC3261의 PRACK의 이해
=================================

Chapter 8. subscribe, notify
============================

**state**  
- active ; subscription이 수락됨.  
- pending ; notifier가 subscription message를 받았지만, 승인 or 거절할지 아직 결정하지 못한 상태.  
- terminated ; subscription이 종료됨. expires 유효기간이 만료되었을 수도 있으며, 사유가 명시된다.

**User Presence & Registration state**  
- registration state : 사용자와 연결하기 위하여 Contact address가 존재하는지 여부를 나타낸다. -> init / active / terminated, 3가지의 state를 가진다.

-	user presence : 사용자가 지금 망에서 다른 사용자와 통화할 수 있는 지를 의미한다.

Chapter 9. Info
===============

-	200 ok 이후부터 bye 이전까지 기존의 세션 내에서 uac와 uas 간에 정보 교환을 할 수 있는 방법이 없었다.  
-	sip signaling 경로를 이용하여 어플리케이션 레벨의 정보를 전송하는 것이 목적.  

**참고**  
- 세션과 관련된 미디어 속성을 변경하거나 세션 타이머를 업데이트를 할 때는 UPDATE, re-INVITE를  
- 어플리케이션 레벨의 세션 관련 제어 정보를 전송할때는 INFO

**DMTF**
--------

1) in band  
- RTP 메세지를 사용.  
- 사용자가 버튼을 길게 / 짧게 누르는 것을 표현할 수 있다.  
- bypass 및 rfc 2833이 대표적.

2) out of band  
- band = media session  
- media session을 벗어나서, sip signaling 메시지와 path를 사용하여 전송한다.

Chapter 10. UPDATE(RFC 3311)
============================

-	update는 기존에 협상된 미디어 스트림이나 코덱과 같은 세션 파라미터를 변경하기 위해 사용되지만, 기존의 다이얼로그는 그대로 유지한다. (세션이 설립되기전에 사용할 수 있다.)

-	re-INVITE도 세션 파라미터를 변경하지만, 세션이 설립된 이후에 사용되며, 기존의 다이얼로그에 영향을 주게 된다.

### UPDATE 절차

-	최초 invite시에 헤더의 allow필드에 'update'를 명기하여 UAC가 update를 지원함을 uas에게 알려준다.  
-	offer/answer가 완료된 상태에서 update 메쏘드가 사용되어 세션 파라미터를 변경해야한다.  
-	offer/answer가 완료되지 않은 상태에서 update 메쏘드가 생성될 수 없다.  

Record-Route and Route
----------------------

-	Record-Route는 UA간에 직접 통신이 가능한 상황이라 하더라도 항상 SIP 메시지를 proxy 서버를 통해서 주고 받도록 강제하기 위함.  
---

**참고**  
- SIP register, 인증(http://ongal.tistory.com/111)  
- sip digest access authentication(https://en.wikipedia.org/wiki/Digest_access_authentication)
- sip digest access authentication(http://www.nexpert.net/276)  
