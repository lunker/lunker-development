NAT traversal in sip
====================

nat
---

-	mapping table을 가지고 있다. nat를 통해 첫 packet이 전송되어야 table에 등록이 된다.
-	그리고 이 mapping 정보는 아무런 패킷이 이동되지 않는다면 특정 시간동안만 유효하고 그 이후에는 사라지게 된다. -

sip signaling
-------------

-	어떠한 종류의 nat이어도 sip는 동작할 수 있다.
-	초기의 sip message가 나가면서 nat의 ip:port를 열어두기 때문에 proxy가 같은 ip:port로 message를 되돌려 주기만 하면 된다.

RTP - Media Stream
------------------

-	SIP message body에 client들 간에 직접 통신을 하기 위한 접속 정보가 들어가야 한다.  
-	이 정보는 sip message body에 들어갈 sdp message에 담겨진다.  
-	이 정보는 각 end point들이 자신들의 정보를 알아서 담아 보낸다.  
-	하지만 각 end point들이 알고 있는 것은 자신들의 internal ip:port 정보이다. 그리고 이 정보들을 외부에 내보내질 sip message의 sdp body에 들어가게 된다.  

UPnP
----

-	client가 **NAT에게** 자신의 public 주소가 무엇인지 물어본다.
	------------------------------------------------------------

	External Query
	--------------
-	client가 nat에게 물어볼 수 없으면, NAT외부에 있는 곳에다가 물어본다.

-	그러면 외부에서 해당 packet의 public ip가 어떻게 오는지 보고 이를 되돌려준다.

-

nat traversal
=============

-	client가 nat의 뒤에 있는 경우 NAT를 통해 이 클라이언트에 접근 하기 위해서는 이 클라이언트의 public ip, port 정보가 필요하다.

-	이 정보를 알기 위해서는 두 가지의 방법이 사용된다.  
	1) client가 직접 nat에게 물어보거나,  
	2) client가 nat 외부의 임의의 장소에 요청을 날려서 자신의 public ip를 아는 방법이 있다.

-	그래서 이렇게 알게 된 client의 public 정보를 sdp message에 internal ip:port대신 담아야한다.

STUN Server
===========

-	Simple Traversal of UDP Through NATs
-	public ip:port를 아는것 뿐만 아니라, 사용되는 nat의 종류도 알 수 있다.  
	\- 1) 요청하는 parameter들 - response-address - change ip - change port

**참고**  
- http://www.3cx.com/global/kr/voip-sip-webrtc/stun-server/  
- http://www.nexpert.net/424

-	[VoIP SIP 알자/10. NAT와 방화벽/STUN/TURN/ICE/SBC](http://blog.naver.com/PostView.nhn?blogId=mongu2&logNo=140123112694) -------------------------------------------------------------------------------------------------------------------------
