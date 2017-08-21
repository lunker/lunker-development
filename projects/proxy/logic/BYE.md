# Bye 시나리오


- Bye stack :
  - SCFServlet -> SCFBeanContainer -> CommunicationImpl -> Conversation ->






<Conversation>

  # __ending(SuccessResponseInput i) ::

  - Invoke <CallBean> CommunicationEvent.Type.FINISHED





<CallBean>
  # CommunicationEvent.Type.FINISHED
  - 통화 종료 후, call history를 저장한다.
  - 이를 위해서 rest 호출.
