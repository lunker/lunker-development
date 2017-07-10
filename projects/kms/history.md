# history  

* proxy가 죽어도 media stream은 끊기지 않는다.
* [문제!]
  - mediastatechanged : disconnected 발생시 해당 media object를 release하려고 했다.
    -> ip phone을 끊었는데 check가 발생하지 않는다 ?! 그리고 webphone까지 끊어야 disconnected가 발생했다.
      -> 내가 잘못 본거일수도 있으니, 내일 아침에 로그 레벨을 줄여서 다시 테스트해보자.  
      -
  - ip phone에서 끊었는데, webrtcendpoint가 not flowing이 발생했다.
    =>> ip phone을 끊으면, webrtcendpoint not flowing IN이 발생한다. ip phone에서 보내는 media element가 없기 때문.
  - rtpendpoint는 이후에 rtcp bye가 와야 끊긴다.

* [Issue]
    - rtcp bye가 특정 interval마다 전송되므로, RtpEndpoint Bye 인경우, 상대방은 끊긴지도 모르고 소리가 안들리게된다.  
    - rtp endpoint bye시에는 "webrtcendpoint media not flowing in"이 발생한다. 그래서 이 이벤트가 발생하면 kms에서 강제release()를 수행하려고 하지만, 과연 정상 통화 중에서도 "webrtcendpoint media not flowing in"이 발생 안할것인가? 검증이 필요함.   

  * [검증]
    - 장시간 정상 통화시,  
      - 1차) 30분 통화
        - rtpendpoint media not flowing out 발생.

      - 2차 ) ㅇㅇ분 통화

    - ip phone active bye
      - webrtc not flowing in 발생
      - 일정 시간 후 rtcp bye를 받으면 그제서야 rtpendpoint disconnected 발생  

    - webphone active bye
      - webrtcendpoint disconnected 발생
      - rtpendpoint media not flowing in 발생

    - [1차 결론]
      - "media not flowing in" 은 proxy의 비정상 종료 후 통화가 종료됐을 때 발생되는 이벤트이다.
      - media disconnected 역시 발생되는 이벤트.
      - media disconnected 일때에만 releaseReleatedComponents()를 수행하면, rtpendpoint active bye시에 webrtcendpoint 측에서 일정 시간동안 묵음처리 후 통화가 종료되게 된다.
      - 그래서 "media not flowing in"으로 처리하도록 한다.

* [시도]
1. // MediaStateChanged::Disconnected 일때 MediaSet.cpp에 releaseReleatedComponents()를 수행.
2. media not flowing in 일때 releaseReleatedComponents ()를 수행.
  TODO
    - implement MediaSet::releaseReleatedComponents (objectId)
      - find parent object id
      - release object by parent id (to release all related objects)
    - call MediaSet::releaseReleatedComponents (objectId) on "media not flowing in"  

* [문제]
- ip phone active bye 시에, media not flowing in 일때 release를 시켰다.
- 그런데 생각보다 release까지 delay가 존재한다.  
- closeHandler()가 발생한 이후,(kurento client destroy) 약 12초 정도 있다가 media not flowing in이 발생했다.
  - 근데 다시 생각해보니, closeHandler()는 proxy의 비정상 종료를 의미하므로, closeHandler()와 "media not flowing in" 사이의 시간 간격은 아무런 의미가 없다.  
  - 다만 지금 문제는 ip phone active bye 후 바로 webrtcendpoint 해제가 되지 않는다.
  - 테스트를 위해 너무 짧은 GC의 interval이 영향을 미친것도 같다.
  - GC interval : 20 - > 200 변경후 재 테스트.
  - GC의 영향보다는 WebRtcEndpoint의 release가 문제인듯 하다.
    - rtpendpoint "media now flowing in" 이 발생하고 바로 pipeline을 delete한다.
    - 정작 webrtcendpoint는 사라졌지만, webphone에서는 이를 인지하지 못한다.
    - 그리고 특정 interval 이후에 끊어진것을 감지하고 "네트워크 문제로 종료되었습니다" 를 뱉고 통화가 종료된다.
    - 즉, kms에서 webrtcendpoint를 release(async_delete)를 하기전에, webphone에다가 통화 종료 관련 event를 보내야 한다.  

- [정리]
  - ip phone active bye를 해서 "rtpendpoint media not flowing in"이 발생하면 해당 mediapipeline을 delete한다.
  - 그에 따라 바로 rtpendpoint, webrtcendpoint, pipeline을 지운다.
  - 그래서 webphone에서는 iceconnectionstatechange : disconncected가 된다.
  - 근데



* [문제]
- 음소거를 하게되면, 정말로 media not flowing 이 발생된다... ㅡ ㅡ
- ip phone에서 음소거를 하면, "webrtcendpoint media not flowing in" 이 발생된다 ㅋㅋ



* [재정리]
- ip phone active bye 후, webphone이 즉시 안끊겨서 묵음 현상이 발생해도 상관없다.
- 이 케이스는 매우매우매우 드물게 일어나기 때문에, 그냥 자원 해제만 잘 하면 된다.
  -> 그렇다면 나는 음소거 문제 및 네트워크로 인한 일시적인 media not flowing 이슈도 있기 때문에 Disconnected 일때에 release하는걸로.  
  ->

- 또한, ip phone 랜선 뽑으면
  - media not flowing out이 발생.
  - 15초 후 rtcp bye로 인해 disconnected가 발생되고
  - 그로 인해 media component 해제.  
  -

- web phone은 끊으면 바로 disconnected가 발생.
  - 하지만 ip phone은 끊어도 rtcp bye packet 전송 이후 disconnected가 된다.  

* [정리]
- ip phone active bye -> rtcp disconnected -> erase media element -> web phone detect icestate disconnecetd -> . . .  timeout -> send bye

- 이제 다 잘됨.
- 다만, 다 해제하고 난 이후에 keepAliveThread에서 계속 session을 살리는 작업을 한다.
  -> connections에서 지워야함.  


* [시도]
- media element release를 수행하면서, element가 해당 session의 마지막 element일 경우, session을 만료하도록 ?





---
* [조사]
* 170418
- pipeline, endpoint.release()를 수행후, 정작 kurento client가 살아있어도 async_delete()가 수행될까?
  -> 수행된다! 상관이 없음...
  -> media component 각각의 참조만 사라지면 destructor가 실행된다. session이 각각의 reference를 직접 가지고 있지 않는다. 그래서 session이 미처 남아있고 media component가 사라져도 해제는 충분하다.  
  ->

- release는 3가지 자료구조에서 지운다.
  - sessionMap.(sessionId) 에서 해당 object들을 지운다.
  - childrenMap에서도 지운다.
  -
