궁금한것
========
**해결**  
---

-	update의 flow에서 200 ok(invite)가 전송되고, update가 같이 보내어 지면?  
	Q. contact에서 uri를 통해 어떻게 클라이언트들이 직접 p2p를 맺을 수 있는지..?  
	A. SDP에 상대방 단말에 대한 접속정보가 들어있다.  
	SIP에 들어있는 contact uri는 사용자 식별용이다.(사용자 및 사용자의 각 단말들) 실제 상대방과 연결을 맺어서 통신을 할 때 필요한 정보는 sdp에 담겨져서 보내진다.  
-	proxy를 거치면서 via가 붙는데, 그때 붙는 received 와 rport는 무엇인지?  
	Q. Via는?  
	A. Via는 SIP Response를 정확히 Request Path와 반대로 보내기 위하여 존재한다.  
	proxy server를 거쳐서 보낼 때, proxy server가 sip message에 자신의 주소를 via 필드에 추가해서 보낸다.  

**질문**  
---

- Q. REGISTER시에 인증하는 과정이 있는데, REGISTER 이후에 INVITE시 해당 유저가 여전히 인증받은 유저인지는 어떻게 판별하나?  

- Q. Register 시에는 401 unauthorized를 발행하는데,
마찬가지로 INVITE시에도 authorization 정보가 없는 경우, 407을 발행하는거 같다.
sip에는 빠져 있는데 원래는 407을 발행하여 다시 INVITE를 보내는게 맞는가 ?

- sipservlet에서 addressheader와 그냥 header의 차이

- Q. 전화를 걸다가 어느정도 응답이 없으면 안내 메세지나 끊기는게 있는데
이거는 INVITE의 설정으로 할 수 있는것인지, client에서 시간을 재서 체크하는 것인지 ?

- Q. to, from, request-uri 의 차이?

- Q. INVITE 후 cancel을 하려고 할 때, response가 발행되기 전에 cancel을 할 수 있다.  그러면 이 response는 어떤것에 해당되는가??
