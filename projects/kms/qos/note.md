# 정리

- RTP QoS는 RTP의 품질은 제공하는 RTCP에서 전송하는 데이터를 기반으로 측정한다.
- RTCP에는 SR(Sender Report) data, RR(Receiver Report) data가 존재한다.
- 각 데이터에는 다음 항목의 데이터가 전송되어진다.
  1) SR
    -

  2) RR
    -

    (참고: http://www.freesoft.org/CIE/RFC/1889/19.htm, http://www.freesoft.org/CIE/RFC/1889/20.htm, ])
- 한편, RTP QoS의 주요 지표로는 다음 3가지가 사용된다.
  - Jitter, Latency, packet loss
  1) Jitter
  2) Latency
  3) Packet Loss

- Kurento Media Server에서 사용중인 GStreamer에서는 이미 RTCP Packet을 처리하여 SR, RR에 맞는 통계정보를 제공하고 있다.
- RtpManager->RtpSession에서 SR, RR의 정보를 가져올 수 있다. 그리고 Kurento Media Server에서는 GStreamer의 statistic data를 가져올 수 있는 방안을 제공하고 있다.
-


- ssrc: 한 rtp세션 내에서는 미디어 소스마다 다른 ssrc값을 가진다

@ 참고 :
<rtp의 이해>

http://blog.secmem.org/137
