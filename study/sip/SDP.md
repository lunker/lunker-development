# SDP  

-	Session을 맺을 때 필요로 하는 정보들을 정의하는 프로토콜
-	SIP Functionality 중 **User Capabilities**를 정의하는데에 사용된다. (통신간에 사용될 미디어 및 미디어 파라미터 결정)
-	used to describe multimedia session announcement, multimedia session invitation and other forms of multimedia sesion initiation.  


#### Message Format  
- v : SDP 프로토콜 Version
- o : sdp 메세지를 생성한 owner/creator
- s : session name
- c : 미디어의 주소를 정의
- t : Timing. start time&stop time을 표시
- m : 미디어 설명
  Media, Port, Protocol, Format 등이 표기됨
- a : 미디어 속성
- a : 미디어 방향
- a : DTMF 협상
---

#### Offer/Answer Model

-	Request/Response Model과 같은 방식으로 동작.
-	Offer : 내가 사용 가능한 capability를 알려준다.
-	Answer : offer에 대해서 수락할 capability를 알려준다.(offer중에서 사용할 것들을 선택한다.)
-	해당 answer에 대해서 실제로 어떤 것을 사용할 것인지 ack를 보낸다.**주의** offer를 항상 caller가 하는 것은 아니다. callee가 먼저 할 수도 있음...?

-	텍스트 기반으로 원하는 capability를 정의하여 보낸
-	ex) p. 24참조(sip 시그널링 예제)
-	m : media description and transport address(실제 사용될 코덱)
-	a : media attributes lines(코덱의 속성)

SDP Packets
-----------

1) Session Information  
- session name, purpose - times the session is active
-	위의 정보들을 담고 있다. --------------------------

2) Media Information  
- type of media(video, audio . . .)  
- transport protocol(RTP/UDP/IP, H.320)  
- media format

#### Invite with sdp

#### Invite without sdp

---
#### Early Offer  
- SDP Offer에 대한 answer가 200 ok나 180 ringing과 함께 전달된다.
- 발신자가 sdp 협상의 주도권을 가진다.

#### Delayed Offer  
-


## SDP 협상에서의 발생가능한 문제점
#### Media Clipping
-	짤리는 것.

#### Ringbacktone
- Caller가 180 ringing을 받았을 때 자체적으로 local ringback tone을 발생시킨다.  현실에서는 전화를 걸고 나면 컬러링이나 착신측에서 보내주는 Remote Ringbacktone을 사용해야 한다. 하지만 이때 아직 미디어 채널 협상이 끝나지 않았다.  

---

#### Early Media

-	정규 offer/answer 절차 이전에 전송되는 rtp를 가리킨다.
-	early media의 발생 시점은 invite의 생성에서부터 ack 신호까지이다. ack 이후에는 정상적인 media가 전송.  
- Remote Ringbacktone 문제를 해결하기 위해 사용된다.  

**필요성**  
- Invite ~ 200 Ok 순간에 발생되는 media data들. - 200 Ok가 발생되는 순간은 수화기를 드는 순간, - 이후에 200 Ok가 전달되고 Caller로 부터 Ack가 전송되어 Callee가 이를 받아야 media가 정상적으로 주고받을 수 있다. - 하지만 Invite ~ ack 사이에 발생되는 데이터는 제대로 전달되지 못한다. - 이를 커버하기 위해 Early Media가 필요로 함.

**Application Server Model**  
- early media를 위한 별도의 절차를 수행한다. - 즉, 하나의 호 시그널링에서 early media session과 regular session을 동시에 offer / answer를 수행 한 후 전환합니다.  
- 이 두 session을 content-disposition header의 'session'과 'early-session' 이라고 하는 것으로 구분하여 사용한다.



**Early Media Session 설립하기**  
-
