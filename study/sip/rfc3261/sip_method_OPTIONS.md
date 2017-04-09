# Options(RFC 3261, Section 11)

### Overview
- allows UA to query another UA or proxy server as to its capabilities.  
- 상대방 UA에 대해서 supported method, content types, extension등에 대한 정보를 미리 구할 수 있다.  
- OPTIONS' target은 Request-URI field로 결정된다.  
- 만약 proxy server로 전송되어야 하면 Request-URI에는 User Part없이 보내어진다.(REGISTER처럼)


#### Construction of OPTIONS Request  
-
#### Processing of OPTIONS Request  
- 200 ok :: UAS is ready to accept call
- 486 busy here :: UAS is busy.
- UAS의 기본적인 state를 결정하는데에 사용된다.
- dialog내에서 만들어진 OPTIOINS Request는 200 ok를 받는다.
- Allow, Accept, Accept-Encoding, Accept-Language 등의 정보가 Response에 담겨진다.
