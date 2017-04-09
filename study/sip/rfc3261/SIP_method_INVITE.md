# INVITE(RFC 3261, section 13)

#### Overview  
- ask a server to establish a session.
- UAC는 1개 이상의 2xx response나 non-2xx final response를 받을 수 있다.  
- Provisional Response : 1xx번대.
**- UAC는 종류에 상관없이 final response를 받을때 마다 ack를 보내야 한다.(200 ok가 아니어도 보내야한다.)**  
-> 300 ~ 699의 final response는 transaction layer에서 ack가 처리된다.
-> 2xx final response는 uac core에 의해서 ack가 발행된다.

- UAC가 INVITE Message를 보낸다.
- SIP Proxy는 INVITE 요청을 받은 후 100 Trying메세지를 UAC에게 전송해준다. (= INVITE Message를 수신했으며, INVITE Message를 UAS에게 보내기 위해 처리중임을 의미)
- Proxy는 INVITE Message에 VIA field에 자신의 주소를 추가한다.
- UAS가 INVITE Message를 수신하면, Ring이 울린다.
- 그 다음에 180 Ringing Provisional Response를 Proxy Server에 전송한다.
- 180 Ringing Provisional Response를 UAC가 받게 되면, UAC의 Ringback Tone이 울리게 된다.
- UAS가 수화기를 들면, 200 OK with SDP가 UAC에게 전송된다.(이 200 ok message의 header field 역시 초기 request에 있던 heaeder field와 동일하게 보낸다. 다만, Contact Field의 정보가 바뀐다.)  
**Contact Field**  
- 신규 요청을 생성할 경우 이 field를 참조한다.  
- UAC는 200 ok를 수신한 후 , Ringback tone을 중지하고, ACK를 보낸다.
- sdp offer가 invite에 있으면 answer는 2xx response에 있어야 한다. 반대로 offer가 2xx에 있다면 answer는 ack에 담겨야 한다.
- sdp는 Content-Disposition header field의 값이 'session'이어야 SIP body에 담을 수 있다.


---

## UAC Processing(section 13.2)

### Creating the Initial INVITE(13.2.1)
- INVITE는 outside dialog request 이다.(section 8.1.1 참고)
-
- Expire Header : 지정된 시간동안에 INVITE에 대한 final response를 받지 못하면 uac가 해당 request를 CANCEL을 보내서 취소시킨다.(CANCEL - section 9)
- offer/answer model인 SDP를 담아서 message들을 보낸다.  
- SDP는 **Content-Disposition Header Field = 'session'** 이어야 body에 쓰일 수 있다.
- INVITE Message를 만들고 난 이후에는 section8에 따라 Request를 보낸다.
- multiple 2xx response를 받을 수 있다.
- 2xx response에 대한 ack는 기존 dialog에서 쓰인 header field와 동일해야 한다.

### Processing of the INVITE Responses(13.2.2)
#### 1xx Responses
-

#### 3xx Responses(Redirection)
- response에는 callee의 new address가 Contact Header field에 담겨있다.
-
#### 2xx Responses(13.2.2.4)
-
