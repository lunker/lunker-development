# GC
- 1차 GC
  - kms에 있는 전체 session에 대해서 inUse->noUse로 바꾼다.

- 2차 GC
  - if) noUse
    - erase reference to invoke destructor (async_delete())
  - if) convert inUse -> noUse

##
- kurento client가 생성되고 나면, keepAliveThread가 돌기 시작한다.
  - keepAliveThread는 keepAliveSessions()를 수행한다.
    - 현재 KMS에 연결되어 있는 kurento client session들(std::map <std::string, websocketpp::connection_hdl> connections;)에 대해서 수행한다.
    - MediaSet()::keepAliveSssion()을 호출하여 현재 session들을 sessionInUse <- inUse로 바꾼다.  
    -

- kurento client가 죽으면, closeHandler()를 수행한다.  
  - connections에서 해당 kurento client session을 지운다.
  - 그래서 이후에 keepAliveThread가 수행하는 keepAliveSessions()의 대상에서 제거되어, GC의 대상이 되도록 한다.  
  -
