# CANCEL(RFC 3261, section 9)

### Overview
- client가 전송한 request를 취소할 때 사용한다.
- UAS가 이미 final response를 보냈을 경우에는 소용이 없다
- INVITE의 경우, invite에 대해서 cancel을 보내면 ringing을 멈추고, invite에 대해서 487 error response를 발행한다.????
---

#### client behavior(section 9.1)
- INVITE에 대해서만 사용하도록 한다. 다른 method들은 반응이 즉시 일어나기 때문에, cancel의 사용은 race condition을 만들게 된다.  
- CANCEL request의 header는 취소할 기존 request의 header field(request-uri, call-id, to, cseq, from)가 동일해야 한다.  
- CANCEL request를 생성한다.
- provisional response가 도착하지 않았으면,CANCEL REQUEST를 보내지 않고 기다린다.  
- 만약 초기 request에 대한 응답을 64*T1의 시간동안 받지 못한다면, 초기 request는 취소된것으로 간주하고 transaction을 처리한다.
---

#### server behavior  
- UAS가 cancel에 대해 해당되는 request를 찾지 못하면, 481 error response 반환.  
- 해당되는 request가 존재하면, final response의 발행 여부에 따라 달라진다.  
  아직 response를 발행하지 않았으면, 해당 request를 cancel한다.  
- **하지만**, original request의 method가 무엇이든간에(invite가 아니어도) cancel request와 해당되는 original request가 있다면 uas는 일단 200 ok response를 발행한다. ?
---

**참고 및 연관자료 **
- rfc3261, 9
- proxy usage of CANCEL :: seciton 16.10
- what conditions a uac would cancel an invite request :: section 15
-
