## Kurento Media Server
- kurento client가 붙는것은 websocket server이다.(open source library)

'keepalive방식?'
- server가 보내나, client가 보내나 ?
- keepalive 주기도 garbage collection과 연관이 있는거 같다.
- 'keepalive'는 thread를 통해서 WebsocketTransport::keepAliveSessions를 호출한다.
  - WebsocketTransport::keepAliveSessions()를 하면 MediaSet에 있는 sessionInUse를 true로 돌려놓는다.


** kurento Client 생성
- MediaSet::keepAliveSession()을 통해 sessionInUse에 넣는다.
- 나머지 sessionMap, reverseSessionMap 등에는 MediaSet::ref()를 통해서 넣는다.


** kurento client destroy**  
- WebsocketTransport::processMessage() -> servermethod::closeSession을 수행.  
- 


** proxy shutdown
- WebsocketTransport::closeHandler() 가 호출.
  - connections에서 해당 client session을 지운다.
  - keepAliveThread에서 connections를 가져와서 해당 session들을 inUse 상태로 바꾼다.
  - 그래서 closeHandler()를 통해 connections에서 제거하면, 해당 세션은 없어지게 된다.
  - 그래서 G.C가 2번 돌면, in use -> not use -> media delete 를 하여 객체를 없앤다.

**
- WebSocket을 통해서 Proxy와 연결을 맺는다.
- 그리고 WS에서 생성된 sessionId를 이용하여 kms-core 등에서 세션을 파악한다.
- Websocket에서 close handler를 하고나면 erasing connection을 통해서


**
- ping, pong은 단순 kms가 살아 있음을 체크하기 위함.

[Handle Scenario]

case 통화중에 Proxy Shutdown
- kurento client socket connection closed.

case call
  if ) proxy alive && not release & not destroy
    - [MediaStateChanged] Disconnected 발생
    - [MediaFlowOut,In StateChanged] not flowing 발생
    -


[Kurento Client Method Mapping]
- WebsocketTransport::process() => servermethod::process() => ServerMethod::servermethod()에서 handler에 등록된 method를 호출한다.  
-
