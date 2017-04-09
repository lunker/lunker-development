# SIP 정리

# General UA Behavior(method independent rules of uac, uas, message outside of dialog)
- uac, uas의 behavior는  
1) 해당 request / response가 inside or outside of dialog 인지
2) method of request  

위 2가지에 의해 결정된다.  

### UAC Behavior
- sip request는 다음 header field를 반드시 가져야 한다.  
to, from, cseq, call-id, max-forward, via
-
### uas behavior

---

# Dialog(section 12, request/response within dialog)
- dialog = peer-topeer sip relationship between two user agents
- dialog는 dialog ID로 식별된다.  
이 dialog id는 call-id value, local tag, remote tag로 구성된다.  
- dialog에 참여하고 있는 ua의 dialog id는 서로 다르다.  
**dialog id**  
한 쪽의 local tag는 다른 ua의 remote tag와 동일하다.  

- 또한, dialog ID는 to field에 tag를 가지고 있는 모든 request와 response와 관련이 있다.  

### Creaion of Dialog  
- non-final response에 의해 만들어지는 dialog는 **early dialog** 라고 불린다.  
-

#### UAS Behavior
- uas는 모든 request의 record-route header field의 값들과 그 값들의 순서를 그대로 유지해서 response 해야한다.
- 그리고, response에 반드시 **contact field**를 넣어야한다. 이 값은 해당 dialog의 subsequent request를 받을 uas의 주소이다. (2xx response에 대한 ack가 그 예이다.)


---
# Proxy(section 16)
- sip message들을 ua들한테 routing하는 역할.
- request를 포워딩하기 전에 수정해서 보낸다.  

- proxy는 request를 받았을때, proxy 자체적으로 이 요청에 대해서 응답을 해줘야 하나 결정해야한다.
ex) 잘못된 request이거나, 인증안된 유저일 경우, proxy의 역할(forwarding)을 하지않고, 잘못된 요청이라는 것을 client에 응답을 해줘야한다. 즉 이경우에는 proxy는 uas의 역할을 해야한다.  


### Stateful proxy  
- stateful proxy는 sip transaction processing engine이다.  
- section 17의 behavior를 참고하여라.

1) validate the request (section 16.3)
2) preprocess routing information (section 16.4)
3) determine targets for the request (section 16.5)
4) forward the reuqest to each target(secton 16.6)
5) process all responses (section 16.7)

#### Request validation  
- 아래와 같은 체크를 해야한다.  
1)

- 이 체크중 하나라도 실패하면, proxy는 uas로써, forwading 대신 response를 보내야 한다.(section 8.2)
-

#### preprocess routing information(section 16.4)
- proxy는 반드시 Request의 **REQUEST-URI field**를 체크해야한다.  
- proxy는 Route Header Field의 가장 마지막 값을 Request-URI 필드에 넣는다. 그리고 Route-Header field의 가장 마지막 값을 지운다.

- 만약 Route-Header field의 값이 자기 자신(proxy)를 가리키면, 해당 값을 request에서 지워야한다.  


#### Determining 
