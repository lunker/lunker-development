# re-INVITE(RFC 32361, section 14)

### Overview
- describe how to modify the actual sessioin.
- changing address, ports, adding media stream, delete media stream 등이 포함된다.
- sending new INVITE Request를 통해 할 수 있다.
- re-INVITE는 dialog와 session paramter를 동시에 수정한다.

#### UAC Behavior  
- media를 수정하고싶으면 send INVITE with new offer.
- re-INVITE는 절대 fork되지않는다. single final response만 만들어진다.
- re-INVITE의 request-uri는 AOR이 아니라 현재 dialog를 맺고 있는 UA의 주소이다.  
-
