# Kurento Media Server Failover
- RTP는 udp를 사용하기에, TCP와는 달리 socket이 끊어지고 나서도 별도의 에러를 발생시키지 않는다.
-


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
- 이를 위해 여러가지 library를 추가적으로 사용한다.
  - libnice
  - gst-plugins-bad

2) 구현

[Regenerate RtpEndpoint]
1) Overview


3) 해당 프로젝트
  - kms-elements
  - kms-core

2) 구현
- Kurento의 RtpEndpoint는 socket 생성시 any로 생성하기에 vip로 생성하지 않아도 failover로 endpoint를 생성하여도 문제가 생기지 않는다.
- RtpEndpoint의 SDP에 존재하는 media정보 중 origin(o=), connection(c=)에 kurento media server의 ip정보가 들어간다.
- 해당 부분은 RtpEndpoint.conf.ini를 추가적으로 생성하였고, 여기에 'real_ip', 'virtual_ip'를 설정하였다.
- (구현 블라블라)

# flow
- MediaStateChagned 'CONNECTED'가 발생하면 RtpEndpoint, WebRtcEndpoint, MediaPipeline 관련 정보를 저장한다.
- kms가 down될 경우,keepalive에 의해 vip가 BACKUP machine에게 넘어간다.
- machine state가 변경되면 shell script를 실행하여 Invoker에게 HTTP POST를 통해 다운된 machine의 IP(현재 backup or fault)\
