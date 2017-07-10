# Event  

## MediaStateChanged

<RtpEndpoint>
- rtcp bye message가 와야 "DISCONNECTED"가 된다.
- rtcp packet은 특정 interval마다 전송되므로 바로 catch 되지는 않는다.  

<WebRtcEndpoint>
- 통화 끊으면 바로 발생한다.


## MediaFlowInStateChanged, MediaFlowOutStateChanged  
- 정상 통화중에서도 발생하곤 한다.  
-
