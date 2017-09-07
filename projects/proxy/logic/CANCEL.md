# CANCEL

-  ParticipantAgent::purgeParticipant() -> ParticipantAgent::forwardCancel()

<ParticipantAgent>

  # purgeParticipant() ::
  - ForwardCancel()을 호출한다.
  - cancel의 원인 (180 ringing timeout or cacnel )에 따라 call history를 남긴다.
  - cancel push를 날린다.

  # ForwardCancel() ::
  - SipSession에 call이 cancel됐음을 표시한다.
  - 등록되어 있는 장비들에 대해서만(SIPSession이 있는 디바이스들) cancel을 저장해둔다.
  - PSTN Callee 일경우, typhone 유저가 아니기에 s/w에다가 cancel을 보내준다.
    - request uri를 s/w에 맞게 변경한다.
  - cancel.send() 수행.
  - 해당 콜 관련 kurento media element release
