



UpstreamInvite

IncomingDPIProcessor
- media session 설립. using MediaController  

InviteDPIProcessor
-> doProcess() => processInviteRequest()  ::: 하는거 없음


B2BUABuilderProcessor
->processRequest()


sanityCheckProcessor
-> doProcess ::: 하는거 없음

InviteProcessor
-> doProcess() -> processInviteRequest() ::: 그냥 message.setRequest.... ㅡㅡ


ProtocolAdapterProcessor
-> processRequest  ::: 헛짓

NATHelperProcessor
-> processRequest :::  로직 파악해야함.

DispatchDPIProcessor
-> doProcess() ::: Request는 그냥 전송, Response는 처리 후 전송
