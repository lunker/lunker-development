# call transfer

- 돌려주기
- A-B와 통화하다가 A가 c를 알려주면, b-c와 통화한다.
- a-b가 통화를 하고 있다.
- A(UAS)가 C와 통화하라고 B에게 알려준다.
-

## transfer-unattended
- transfer가 실패하면, 다시 초기 caller와 다시 session을 수립한다.
- transfer가 성공해도, 초기 session은 사라지지 않는다. 초기 session은 refer 관련 세션이 끝나야 같이 사라진다.
- refer에 refer-to header로 돌려줄 callee를 지정한다.
- 이 시나리오는 call-transfer가 이루어지는 것을 UA들이 인지하지 못한채 진행이 된다. call-hold 없이 그냥 진행된다.


** Flow
- A-B가 RTP를 수립했다.
- A(UAS)가 REFER를 사용하여 call-transfer를 수행한다.

*REFER sips:bob@client.biloxi.example.com SIP/2.0
Via: SIP/2.0/TLS client.biloxi.example.com:5061
 ;branch=z9hG4bKnashds8
Max-Forwards: 70
From: Alice <sips:alice@atlanta.example.com>;tag=1234567
To: Bob <sips:bob@biloxi.example.com>;tag=314159
Call-ID: 12345601@atlanta.example.com
CSeq: 101 REFER
Refer-To: <sips:carol@chicago.example.com>
Referred-By: <alice@atlanta.example.com>
Contact: <sips:alice@client.atlanta.example.com>
Content-Length: 0*  


- REFER를 통해서 다른 UA의 정보를 알려준다.
  - "Refer-To" : 다른 UA의 Contact Header의 값과 동일하다. 
  - "Referred-By" : call-transfer를 수행한 UA

- B(UAC)는 REFER에 대한 응답으로 202 Accepted를 발행한다.
- 그리고, 기존의 세션을 관리하기 위해서 B(UAC)가 NOTIFY를 발행한다.

*NOTIFY sips:alice@client.atlanta.example.com SIP/2.0
Via: SIP/2.0/TLS client.biloxi.example.com:5061
 ;branch=z9hG4bKnashds32
Max-Forwards: 70
From: Bob <sips:bob@biloxi.example.com>;tag=314159
To: Alice <sips:alice@atlanta.example.com>;tag=1234567
Call-ID: 12345601@atlanta.example.com
CSeq: 2 NOTIFY
Event: refer
Subscription-State: active;expires=60
Contact: <sips:bob@client.biloxi.example.com>
Content-Type: message/sipfrag
Content-Length: ...*

- NOTIFY에는 새로운 헤더가 추가된다.
  - 'Event:refer'
  - 'Subscription-State' : active, expire
-

- B(UAC)는 새로운 call-transfer를 위해서 새로운 INVITE를 발행한다. 이때 발행되는 INVITE는 기존 INVITE와는 다르다.
*INVITE sips:carol@chicago.example.com SIP/2.0
Via: SIP/2.0/TLS client.biloxi.example.com:5061
 ;branch=z9hG4bKnashds1
Max-Forwards: 70
From: Bob <sips:bob@biloxi.example.com>;tag=8675309
To: Carol <sips:carol@chicago.example.com>
Call-ID: 7436222@atlanta.example.com
CSeq: 1 INVITE
Contact: <sips:bob@client.biloxi.example.com>
Referred-By: <alice@atlanta.example.com>
Allow: INVITE, ACK, CANCEL, OPTIONS, BYE, REFER, NOTIFY
Supported: replaces
Content-Type: application/sdp
Content-Length: ...

v=0
o=bob 2890844539 2890844539 IN IP4 client.biloxi.example.com
s=
c=IN IP4 client.biloxi.example.com
t=0 0
m=audio 3458 RTP/AVP 0
a=rtpmap:0 PCMU/8000*

  - 'Referred-By' 라는 헤더가 추가되었다. (call-transfer에 의한 INVITE임을 표기)
- 이후에는 일반적인 INVITE처리와 동일하게 진행된다.
- 새로운 UA와 RTP 세션이 만들어지게 된다.
- B(UAC)는 call-transfer가 성공된 이후, 이 결과를 A(UAS)에게 NOTIFY를 통해서 알려주어, A-B사이에 남아 있던 세션을 끝낸다.
  ! 이 NOTIFY는 Invite(Referred-By)를 보낸 UA에서 보낸다.

## Transfer - Attended
**Overview**  
- call-hold를 이용하여 call-transfer가 이루어진다.
- call-transfer의 대상이 되는 새로운 UA에게 미리 통화를 한 후에, REFER를 이용한 call-transfer를 수행한다.


**Flow**  

- B(UAS)가 한쪽에 hold를 걸어놓은 채 다른쪽에 통화를 한다.
-
- A(UAC)가 INVITE(replaces)를 발행한다.


# Reference
- rfc 5359
https://tools.ietf.org/html/rfc5589#page-5

- rfc 5589
https://tools.ietf.org/html/rfc5589#page-5
