Note the use of the rendering feature tag defined in RFC 4235
[RFC4235] used in F5 to indicate that Bob’s UA is no longer rendering
media to Bob, i.e., that Bob has placed the call on hold. Feature
tags are also used in F12 with the automaton (defined in RFC 3840
[RFC3840]) and byeless feature tags (defined in RFC 4235 [RFC4235])
to describe the capabilities of the Music Server.

# Call hold with music


- 통화중에 수행한다.
- call holding을 수행하면서, 묵음 대신에 음악을 흘려준다.
- 기존 통화 session을 음악 session으로 대체한다.(새로운 세션을 생성하는것이 아니다)
- 이를 위해 refer를 사용한다.
- call holding을 수행하는 ua가 media server에게 refer를 전달한다.
- refer의 header에 담기는 정보로 ua와 media-server가 rtp session을 만들도록 한다.
-

![Invite]
:: supported에 'replaces', 'gruu'가 있다.
INVITE sips:bob@biloxi.example.com SIP/2.0
Via: SIP/2.0/TLS client.atlanta.example.com:5061
;branch=z9hG4bK74bf9
Max-Forwards: 70
From: Alice <sips:alice@atlanta.example.com>;tag=1234567
To: Bob <sips:bob@biloxi.example.com>
Call-ID: 12345600@atlanta.example.com
CSeq: 1 INVITE
Contact: <sips:a8342043f@atlanta.example.com;gr>
Allow: INVITE, ACK, CANCEL, OPTIONS, BYE, REFER, NOTIFY
Supported: replaces, gruu
Content-Type: application/sdp
Content-Length: ...
v=0
o=alice 2890844526 2890844526 IN IP4 client.atlanta.example.com
s=
c=IN IP4 client.atlanta.example.com
t=0 0
m=audio 49170 RTP/AVP 0
a=rtpmap:0 PCMU/8000

![200 ok with initial request]
v=0
o=bob 2890844527 2890844527 IN IP4 client.biloxi.example.com
s=
c=IN IP4 client.biloxi.example.com
t=0 0
m=audio 3456 RTP/AVP 0
a=rtpmap:0 PCMU/8000


![Refer to establish music session with ua]
- contact에는 첫 invite를 날린 user-agent의 contact가 REFER의 'Refer-to'에 들어간다.



!! REFER

REFER <request-uri>
From: 'call-hold' 수행자
To: media-server
Refer-To: call-hold를 받는사람의 정보.
  - <call-hold receiver의 contact 정보>;Replaces=
Referred-By: call-hold 수행자의 정보. (invite 처음 날릴 때, To:에 있는 정보와 같다.)
Contact:
-- no sdp  


![202 response for refer request]
:: 딱히 다른거 없음
SIP/2.0 202 Accepted
Via: SIP/2.0/TLS client.biloxi.example.com:5061
;branch=z9hG4bKnashds9
;received=192.0.2.105
From: Bob <sips:bob@biloxi.example.com>;tag=02134
To: Music Server <sips:music@server.example.com>;tag=56323
Call-ID: 4802029847@biloxi.example.com
Contact: <sips:music@server.example.com>
CSeq: 1 REFER
Content-Length: 0

[Notify from music server]
NOTIFY sips:bob@client.biloxi.example.com SIP/2.0
Via: SIP/2.0/TLS server.example.com:5061
;branch=z9hG4bK74bT6
To: Bob <sips:bob@biloxi.example.com>;tag=02134
Max-Forwards: 70
From: Music Server <sips:music@server.example.com>;tag=56323
Call-ID: 4802029847@biloxi.example.com
CSeq: 1 NOTIFY
Event: refer
Subscription-State: active;expires=60
Contact: <sips:music@server.example.com>
Content-Type: message/sipfrag
Content-Length: ...


-------------
music server에서 기존의 media-session을 대체하기 위해, call-hold receiver에게 invite를 날린다.

![invite to replace session after complete Refer]
:: invite를 받는 ua의 세션을 대체하기 위해서 sdp에 첫 invite에 있던 sdp정보와 같은것들을 넣는다.
:: sess-id, sess-version이 같다.
INVITE sips:a8342043f@atlanta.example.com;gr SIP/2.0
Via: SIP/2.0/TLS server.example.com:5061
;branch=z9hG4bK74rf
Max-Forwards: 70
From: <sips:music@server.example.com>;tag=0111
To: <sips:a8342043f@atlanta.example.com;gr>
Call-ID: a5-75-34-12-76@server.example.com
CSeq: 1 INVITE
Referred-By: <sips:bob@biloxi.example.com>
Contact: <sips:music@server.example.com>;automaton
;+sip.byeless;+sip.rendering="no"
Require: replaces
Replaces: 12345600@atlanta.example.com
;from-tag=23431;to-tag=1234567
Allow: INVITE, ACK, CANCEL, OPTIONS, BYE, REFER, SUBSCRIBE, NOTIFY
Supported: replaces
Content-Type: application/sdp
Content-Length: ...
v=0
o=MusicServer 2890844576 2890844576 IN IP4 server.example.com
s=
c=IN IP4 server.example.com
t=0 0
m=audio 49170 RTP/AVP 0
a=rtpmap:0 PCMU/8000
a=sendonly
