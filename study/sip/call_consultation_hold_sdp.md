# Consultation Hold
![invite]

v=0
o=alice 2890844526 2890844526 IN IP4 client.atlanta.example.com
s=
c=IN IP4 client.atlanta.example.com
t=0 0
m=audio 49170 RTP/AVP 0
a=rtpmap:0 PCMU/8000

![200ok]
v=0
o=bob 2890844527 2890844527 IN IP4 client.biloxi.example.com
s=
c=IN IP4 client.biloxi.example.com
t=0 0
m=audio 3456 RTP/AVP 0
a=rtpmap:0 PCMU/8000

![invite with call hold]
INVITE sips:alice@client.atlanta.example.com SIP/2.0
Via: SIP/2.0/TLS client.biloxi.example.com:5061
;branch=z9hG4bKnashds7
Route: <sips:ss1.example.com;lr>
Max-Forwards: 70
From: Bob <sips:bob@biloxi.example.com>;tag=314159
To: Alice <sips:alice@atlanta.example.com>;tag=1234567
Call-ID: 12345600@atlanta.example.com
CSeq: 1 INVITE
Contact: <sips:bob@client.biloxi.example.com>;+sip.rendering="no"
Allow: INVITE, ACK, CANCEL, OPTIONS, BYE, REFER, NOTIFY
Supported: replaces
Content-Type: application/sdp
Content-Length: ...
v=0
o=bob 2890844527 2890844528 IN IP4 client.biloxi.example.com
s=
c=IN IP4 client.biloxi.example.com
t=0 0
m=audio 3456 RTP/AVP 0
a=rtpmap:0 PCMU/8000
a=sendonly



![200ok with call hold invite]
v=0
o=alice 2890844526 2890844527 IN IP4 client.atlanta.example.com
s=
c=IN IP4 client.atlanta.example.com
t=0 0
m=audio 49170 RTP/AVP 0
a=rtpmap:0 PCMU/8000
a=recvonly


![invite with other ua (initial)]
v=0
o=bob 2890844834 2890844834 IN IP4 client.biloxi.example.com
s=
c=IN IP4 client.biloxi.example.com
t=0 0
m=audio 50170 RTP/AVP 0
a=rtpmap:0 PCMU/8000

![200ok with other ua invite]
v=0
o=carol 2890844922 2890844922 IN IP4 client.chicago.example.com
s=
c=IN IP4 client.chicago.example.com
t=0 0
m=audio 3456 RTP/AVP 0
a=rtpmap:0 PCMU/8000



[!invite with call of with 1st ua]
:: cseq 1 증가, sess-version 증가.
INVITE sips:alice@client.atlanta.example.com SIP/2.0
Via: SIP/2.0/TLS client.biloxi.example.com:5061
;branch=z9hG4bKnashds7b
Route: <sips:ss1.example.com;lr>
Max-Forwards: 70
From: Bob <sips:bob@biloxi.example.com>;tag=314159
To: Alice <sips:alice@atlanta.example.com>;tag=1234567
Call-ID: 12345600@atlanta.example.com
CSeq: 2 INVITE
Contact: <sips:bob@client.biloxi.example.com>
Content-Type: application/sdp
Content-Length: ...
v=0
o=bob 2890844527 2890844529 IN IP4 client.biloxi.example.com
s=
c=IN IP4 client.biloxi.example.com
t=0 0
m=audio 3456 RTP/AVP 0
a=rtpmap:0 PCMU/8000


[! 200 ok with call of hold invite]
v=0
o=alice 2890844526 2890844528 IN IP4 client.atlanta.example.com
s=
c=IN IP4 client.atlanta.example.com
t=0 0
m=audio 49170 RTP/AVP 0
a=rtpmap:0 PCMU/8000
