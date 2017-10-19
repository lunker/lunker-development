# Kurento Media Server Failover

## Overview
- RTP는 udp를 사용하기에, TCP와는 달리 socket이 끊어지고 나서도 별도의 에러를 발생시키지 않는다.

# Media Element를 생성하기 위해서 기본적으로 socket 생성과 세션 정보(SDP, candidate) 생성에서 추가 작업이 필요.
- socket은 virtual ip로 binding한다.
- 세션 정보에는 real ip로 설정한다.

[Regenerate WebrtcEndpoint]
1) Overview

- WebrtcEndpoint는 webrtc를 사용하여 미디어 통신을 한다.
- 기본적으로 다음과 같은 특징
  - dtls-srtp
  - candidate (ice gathering)
  -
- 이를 위해 kurento에서는 추가적인 library를 사용한다.
  - libnice : webrtc signaling & rtp validation check
  - gst-plugins-bad : dtls-srtp translate

2) 구현

[Regenerate RtpEndpoint]
1) Overview


3) 해당 프로젝트
  - kms-elements
  - kms-core

2) 구현
- Kurento의 RtpEndpoint는 socket 생성시 any로 생성한다. 그렇기에 추가적으로 vip로 소켓을 생성하지 않아도 failover를 위한 endpoint 생성시에 문제가 되지 않는다.
- RtpEndpoint의 SDP에 존재하는 media정보 중 origin(o=), connection(c=)에 kurento media server의 ip정보가 들어간다.
- 해당 부분은 RtpEndpoint.conf.ini를 추가적으로 생성하였고, 여기에 'real_ip', 'virtual_ip'를 설정하였다.
- RtpEndoint를 통해서 생성되는 SDP의 ip에 property의 'real_ip' 값이 들어간다.
- 그리고
- (구현 블라블라)

# flow
- Kurento Media Server는 keepalive에 의해 vip를 소유하게 된다.
- MediaStateChagned 'CONNECTED'가 발생하면 RTP가 흐르게 되어서 통화가 시작됐다는 것을 의미한다.
- 따라서, 'CONNECTED'가 발생하면 해당 콜과 관련하여 생성된 RtpEndpoint, WebRtcEndpoint, MediaPipeline의 정보를 저장한다.
- KMS(master)가 다운이되면, keepalive에 의해 vip가 BACKUP machine에게 넘어간다.
- kms의 machine state가 변경되면 keepalive가 shell script를 실행하여 Invoker에게 HTTP Request를 요청한다.
- Invoker는 다운된 machine의 IP(현재 backup or fault)
