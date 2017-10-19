# Call Hold

1) default hold
**[invite]
v=0
o=alice 2890844526 2890844526 IN IP4 client.atlanta.example.com
s=
c=IN IP4 client.atlanta.example.com
t=0 0
m=audio 49170 RTP/AVP 0
a=rtpmap:0 PCMU/8000


**[200 ok]
v=0
o=bob 2890844527 2890844527 IN IP4 client.biloxi.example.com
s=
c=IN IP4 client.biloxi.example.com
t=0 0
m=audio 3456 RTP/AVP 0
a=rtpmap:0 PCMU/8000


! 여기에서 call hold는 callee가 수행함.

**[invite with call hold]
v=0
o=bob 2890844527 2890844528 IN IP4 client.biloxi.example.com
s=
c=IN IP4 client.biloxi.example.com
t=0 0
m=audio 3456 RTP/AVP 0
a=rtpmap:0 PCMU/8000
a=sendonly

**[200ok with call hold]
v=0
o=alice 2890844526 2890844527 IN IP4 client.atlanta.example.com
s=
c=IN IP4 client.atlanta.example.com
t=0 0
m=audio 49170 RTP/AVP 0
a=rtpmap:0 PCMU/8000
a=recvonly

! call hold를 수행헀던 callee가 수행.ㅣ
**[invite with call off hold]  
v=0
o=bob 2890844527 2890844529 IN IP4 client.biloxi.example.com
s=
c=IN IP4 client.biloxi.example.com
t=0 0
m=audio 3456 RTP/AVP 0
a=rtpmap:0 PCMU/8000


**[200ok with call off hold invite]
v=0
o=alice 2890844526 2890844528 IN IP4 client.atlanta.example.com
s=
c=IN IP4 client.atlanta.example.com
t=0 0
m=audio 49170 RTP/AVP 0
a=rtpmap:0 PCMU/8000


2) consultation hold
- rfc 4235, rendering tag가 사용됨.
-
