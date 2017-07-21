# Overview



# QoS of VoIP
- rtp의 품질은 rtcp SR, RR packet에 미디어 관련 품질 정보가 담겨져서 보내어진다.
- You get the (accumulated) information from the SR and RR in the
statistics (stats) from rtpbin, or more specific the rtpsessions and
rtpsources inside.

I'm going to add a new signal soonish that allows you to also get the
raw RTCP packets whenever one is received, if that's closer to what you
need.
@ 참고
- gstreamer get raw RTCP data  http://gstreamer-devel.966125.n4.nabble.com/how-to-capurure-RTCP-Sender-Report-and-receive-report-td4670470.html
http://gstreamer-devel.966125.n4.nabble.com/RTCP-receiver-report-data-td3055679.html

#### Parameters
- The QoS level
of VoIP applications depends on many parameters, such as: bandwidth, One Way Delay
(OWD), jitter, Packet Loss Rate (PLR), codec type, voice data length, and de-jitter buffer size.
In particular, OWD, jitter, and PLR have an important impact.

- 주로 jitter, packet loss, latency를 중요하게 여긴다.

1) One Way Delay
- source ~ destination까지 도달하는데에 걸리는 시간

2) Jitter
- packets arrive at the destination with varying delays (between packets) referred to as
jitter
- destination에 패킷들이 도달하는 중간의 딜레이

3) Packet Loss
- 다양한 네트워크 환경으로 인하여 제한적이지만 voip를 위해 udp를 사용한다.

4) Latency


@ 참고
http://cdn.intechopen.com/pdfs/13379/InTech-An_introduction_to_voip_end_to_end_elements_and_qos_parameters.pdf


# RTCP SR, RR data
- SSRC of the RTP stream, fraction of packets lost, last
sequence number, average interarrival jitter.

- SSRC of the RTP stream, the current time, the number
of packets sent, and the number of bytes sent.

---
#References
https://gstreamer.freedesktop.org/documentation/plugin-development/advanced/qos.html

https://gstreamer.freedesktop.org/documentation/design/qos.html

- cisqo voip qos 관련 문서
http://www.cisco.com/c/en/us/td/docs/ios/solutions_docs/qos_solutions/QoSVoIP/QoSVoIP.html


- how to get rtp qos parameters from gstreamer
 http://gstreamer-devel.966125.n4.nabble.com/How-to-best-obtain-packet-loss-statistics-from-rtspsrc-td4674255.html


VoIP can guarantee high-quality voice transmission only if the voice packets, for both the signaling and audio channel, are given priority over other kinds of network traffic.
