# Bye 시나리오

- Bye stack :
  - SCFServlet -> SCFBeanContainer -> CommunicationImpl -> Conversation -> ParticipantAgent


<Conversation>

  # __ending(SuccessResponseInput i) ::

  - Invoke <CallBean> CommunicationEvent.Type.FINISHED


<ParticipantAgent>

  # forwardBye() ::

  # forwardRequest() ::
  - active bye UA한테 200 ok (bye)를 전송한다.
  - 그리고, passive bye ua를 찾기 위하여 sipsession을 찾는다.
  - 초기 bye request를 이용하여 새로운 bye SIP Request를 생성한다.
    - SIP header를 기존 bye request에서 가져와서 셋팅한다.
  - 전송!

<CallBean>
  # CommunicationEvent.Type.FINISHED
  - 통화 종료 후, call history를 저장한다.
  - 이를 위해서 rest 호출.
