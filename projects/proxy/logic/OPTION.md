# OPTION Flow

- MESSAGE와 똑같이 OPTION도 여기에서 처리된다.
<Call Stack> ::
- SCFServlet->SCFBeanContainer->communicationImpl->IMConference->IMConferenceParty->IMParticipantAgent


IMConferenceParty::private SCFInternalState __initial(MessageInput i)
IMParticipantAgent::ForwardMessage()





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
  - 전송.
