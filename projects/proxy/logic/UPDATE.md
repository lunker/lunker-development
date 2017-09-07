# Update



<ParticipantAgent>

  # ForwardUpdate() ::
  - 기존에 들어온 Invite가 저장되어 있다.
  - 이를 꺼내와서, rport, received정보를 update된 내용으로 업데이트한다.
  - update에 대한 200ok를 생성한다.
  - caller에게는 200 ok를 전달한다.
  
  if) 180 ringing을 수신한 기기에 대해서는,
    - 반대편 UA에게는 update를 새로 생성하여 전달한다.
    -
