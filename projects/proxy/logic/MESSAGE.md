# MESSAGE Flow


<Call Stack> ::
- SCFServlet->SCFBeanContainer->communicationImpl->IMConference->IMConferenceParty->IMParticipantAgent


IMConferenceParty::private SCFInternalState __initial(MessageInput i)
IMParticipantAgent::ForwardMessage()


<IMConference>
  # private SCFInternalState __initial(AbstractInput i) ::

  - SIP Message Request 에서 정보를 읽어서 MessageInfo 객체에 설정한다.
  - MessageInfo 객체를 CommunicationSession에 저장한다.
  - Invoke Type.SAVE_MASSAGE
    - 에러가 발생하면 500 INTERNAL_SERVER_ERROR 발행
  - Create 200 Ok response
  - message관련 헤더들을 추가한다.
  - 200 ok 전송.
  - 다른 유저들에게 메세지를 보내기 위하여 ForwardMessage를 수행한다.
  -

<IMConferenceParty>
  # private SCFInternalState __initial(MessageInput i) ::
  - 다른 user들에게 message를 포워딩한다.
  -

<IMParticipantAgent>

  # ForwardMessage() ::
  - device 정보들을 읽어온다.
  - SIP Message Request를 새롭게 생성한다.
  - custom header field를 추가한다.
    - chat_id
    - message_seq
    - message_Date
    - file_type
    - file_url
    - message_type
  - Message TIMER를 생성한다.
  - SIP MESSAGE Request forwarding.
  - Invoke CommunicationEvent.Type.PUSH_MESSAGE_START


<MessageBean>
  # CommunicationEvent.Type.PUSH_MESSAGE_START ::
  - MessagePush를 ios, android에 날린다.
