- communicationsession과 sipapplicationsession의 차이 ?
- session.isConnected는 무엇을 의미하는가 ?


- initial request, non-initial request에는 무엇이 있는가
  - initial : invite, bye ?
  - non-initial : bye, info

  ? 왜 bye가 두번이나 존재하지 ???
  ? 일반적인 bye는 subsequent request로 들어간다. initial bye는 언제 들어오는가????

!
- IPPhone에서 070xxx로 전화를 걸면, CommunicationImpl에서 일단 outbound로 인식을 하고 관련 처리를 한다.

! inboundcall, outboundcall

  # InboundCall
    - 외부에서 proxy로 들어온 call
    -

  # OutboundCall  
    - 내부 (typhone user)들이 외부 gateway를 사용하는 call을 요청한 경우
    - 우선, domain을 기준으로 outbound call인지를 판단한다.
    - 하지만 결국에는 typhone user가 아니어야 outboundcall로 인식하고 pbx로 흘려준다.
    - typhone user 계정 정보가 존재하면 outboundcall이 아니다.


  # 판단 기준
    - sender의 도메인으로!
    - sender의 도메인이 203.240.134.4(s/w) :: inbound call
    - receiver의 도메인이 203.240.134(s/w) :: outbound call


! InboundCall
-

! OutboundCall
- caller의 pstnnumber가 존재하는지 확인한다.
  - pstn number가 존재하면 유효한지 확인한다.
  - 유효하지 않을 경우,  403 Forbidden Response 발행

  # Invoke <CallBean> CommunicationEvent.Type.GET_CALLEE_ACCOUNT
    - callee account를 가져온다.
    -
