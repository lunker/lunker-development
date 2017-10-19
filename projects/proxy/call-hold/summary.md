Voiceloco Call-Hold

* Overview
proxy에 SIP 서비스 중 call-hold 기능을 추가로 개발하였다.
call transfer, call forwarding 등의 기능을 위해서는 call-hold 구현이 선행되어야 한다.

call-hold는 통화 시 통화를 끊지 않고 보류시키는 기능이다.
이를 위해서는 추가적인 INVITE 처리와 그에 따라 media server의 구현이 필요하다.

* Call Hold란
Call Holding은 기존에 유지되고 있는 세션을  

* Call Holding 구현 방안
- sdp의 connection 부분에 0.0.0.0을 기입하여

1) rfc 3264
- 'a=sendonly' 추가

2) rfc 3264 - inactive
- sdp의 media attribute로 'a=inactive'를 추가하여 rtp media가 흐르지 않는것을 명시한다.

3) rfc 2327
- c= 0.0.0.0



3) xxxx



* IMS Call Holding 구현
*voiceloco ims의 call holding은 RFC와 세종 IPPhone의 구현 스펙을 기준으로 1차 개발됨*

rfc xxx에 따라서 다음 방식으로 구현을 하였다.

[call holding Offer]
a=sendonly

[call holding answer]
a=recvonly

[call off holding offer]
a=sendrecv

[call off holding answer]
a=sendrecv


* Sip Flow Example
*세종 IPPhone에서 생성된 Sip Message를 바탕으로 작성됨*



* Reference
- webrtc hold offer/answer
http://www.muazkhan.com/2014/05/webrtc-tips-tricks.html

- rfc 5359
