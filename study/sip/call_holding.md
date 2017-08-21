# Call hold
- hold를 누르면 media가 흐르지 않아 묵음을 만든다.
- rfc 2543에서는 sdp의 address를 0.0.0.0으로 한다고 한다.
- rfc 3264에서는 더이상 이를 권장하지 않는다.


- hold를 하게되면, 이전에는 sendrecv mode였던 media stream이 sendonly로 바뀌게 된다.
- 이전에 recvonly였다면, stream은 inactive로 바뀐다.
- 각 stream은 독립적으로 'on-hold' 상태에 들어갈 수 있다.
- hold를 위한 invite(offer)에 대해서는 answer를 날려서는 안된다.
- 일반적으로는, hold를 누르면
  -> UA는 SDP에 모두 'sendonly'로 되어있는 sdp를 전송한다.
  -> UA는 local mute를 수행. 미디어가 전송되지 않는다.

- call hold 시나리오(rfc5359) :
  https://www.rfc-editor.org/rfc/rfc5359.txt
  http://www.tech-invite.com/fo-sip/tinv-fo-sip-service-02.html
