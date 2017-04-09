# Subsequent Request

### caller or callee generate subsequent requests

콜이 생성되고 나면, caller나 callee 가 invite 또는 bye request를 생성할 수 있다.
caller나 callee가 다시 request를 만들 때 이전 request의 header field들을 그대로 복사하여 사용한다.  

- to : remote address
- from : local
- contact : 이전 request의 contact와는 다를 수 있음.
- request-uri :

### receiving subsequent Requests
체크를 통해 3가지 case로 나누어서 처리한다.  
if) call-id가 새로울 경우,

if) call-id가 이미 존재할 경우,  
해당 request 기존에 존재하는 call에 대한 것이다.  


if) 위 두 케이스에 해당되지 않을 경우,  
기존의 call과 TO, FROM을 비교하고, cSeq가 더 크면 새로운 request로 처리한다.  



### re-INVITE  
- tag on the To header ?  
- call이 설립된 이후에 media stream의 ip주소나 코덱을 변경해야 함.  
=> 즉, sdp offer/answer를 진행해야한다.  
- sip 세션 설립 후에 주고 받을 수 있는 SIP 메세지는 BYE뿐이다.
- re-INVITE는 세션을 설립하기 위해 사용하는 INVITE / 200 OK/ ACK 절차를 다시 진행하는 것.  

- 세션 파라미터를 수정하는것에는 address, ports의 변경, crud media stream 등이 포함된다.  
-  

### update
- 기존의 다이얼로그를 유지하면서 세션 파라미터를 재협상하는 절차.  
-



**참고**  
- rfc 2543(https://www.ietf.org/rfc/rfc2543.txt)  
-
