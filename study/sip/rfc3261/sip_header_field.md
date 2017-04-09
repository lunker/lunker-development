# SIP header field


### Request-URI  
- initial : **TO**  field와 같은 값으로 설정.  
- 단, **REGISTER** 일경우에는 예외.  
- next hop or proxdyt server uri를 의미한다.(최종 목적지라기 보다는 중간 중간 거쳐야 할 다음 장소를 의미.)  
즉, used to select routes across the network to find the destination. 반면, To header는 refers to the destination user uri. (실제 목적지)

### TO  
- request의 'logical' recipent or 사용자나 단말의 address-of-record가 적힌다.  
- To Field에 TO Tag가 존재한다.  
-

### FROM  
- logical identity of the initiator of the request  
-

### CALL-ID  
- The Call-ID header field acts as a unique identifier to group together a series of messages. It MUST be the same for all requests and responses sent by either UA in a dialog.

- dialog에 있는 ua들간에 주고받는 모든 request-response는 동일한 call-id를 갖는다.  
- 기존 dialog를 벗어나는 새로운 request일 때, call-id가 새로 만들어진다.  
- 그리고 이 call-id는 어떠한 다른 UA에서 만든 call-id와도 겹치지 않는다는 것을 보장해야 한다.  
-



### CONTACT  
- subsequent request를 위해 필요한 contact(sip uri)를 제공한다.  
-




**참고**  
- RFC 3261, 8.1.1.1 참고  
-
