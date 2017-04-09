찾아볼 키워드들
===============
**통신**  

-	FQDN(Fully Qualified domain name)
-	SIP
-	sdp(session descrition protocol) ; 시그널링 후 p2p로 통신시에 사용될 통신 방법을 정의하기 위한 프로토콜인듯.
-	rtp(Real-Time Protocol)
-	rtsp(Real-Time Streaming Protocol) ; 스트리밍 미디어 전송을 제어
-	media clipping (p.28에서 언급됨)
-	PSTN
-	uas(수신자) ; user agent server
-	uac(송신자) ; user agent client (user agent가 2개의 역할을 수행할 수 있다)
-	call forking(p.41) : 한번에 다수의 UA에 INVITE를 동시 또는 순차적으로 전달하는 것. 이때 하나의 ua가 200 ok를 전송하면, 나머지 ua는 cancel을 전송하여 요청을 취소하게 되는 서비스.
-	다이얼로그 = call-id
-	DTMF : 전화기의 버튼을 눌렀을 때 발생되어 전화국으로 보내어지는 신호. 전화기의 각 키는 특정한 주파수를 가지는 두 가지 음을 만들어낸다.
-	turn server  
-	stun server  
-	retroversial? retriversial?  
-	NAT
-	gateway  
-	PSTN(from. architecture 문서에서)
-	ice(Interactive Connectivity Establishment) : rfc5245
-	turn (traversal using relay nat)
-	stun (session traversal utilities for nat)
-	server relflexive address : nat 장비가 매핑한 클라이언트의 public address  
-	dns srv record  
-	tls  
- stateless proxy, stateful proxy
- media gateway, soft switch
- DTMF
- TLS

- CDR (Call Detail Records)  
- rfc 5863 + session border controller
- call stateful

=======
- sip trunk ?
- redirect server  

꼭 봐야 할 부분들
=================
-	RFC3261
-	sdp
-	ringback tone은 나중에 구현할 것.
-	183 progress에 대해서 알아두기
-	ch7은 안쓰지만 뭔지는 알아두기.
-	ch 8,9는 이해하고
-	ch 9.3은 꼭 보기.
-	ch10 확실하기 보기.

---

# 공부


### Java
- heap profiler
- java.lang.ref  
- weak references  
- java memory structure (https://www.yourkit.com/docs/kb/sizes.jsp)  
- java generic

### Java 8
- method reference
- lambda

---  

### Spring  
- Web.xml의 구성 및 기능  
