# SIP UAC basic behavior

### UAS behavior(rfc 3261, section 8.2)
- outside dialog request에 대해서는 method와는 무관하게 처리해야하는 공통적인 규칙이 있다.
- request header에 to tag가 존재해야만 한다.
- to tag가 존재하는 request에 대하여, dialog identifier는 계산하고, 이를 기존에 존재하는 dialog들과 비교하여 매칭되는게 있는지 확인한다.
- if) find matching dialog, 이 request는 mid-dialog request이다. 이때에는 outside of dialog request와 동일하게 처리한다.(section 8.2참고)
- if) to tag는 존재하지만, 일치되는 dialog가 없는 경우,
 uas가 뒤졌거나, misroute된 경우이다.

**processing order of steps**  
0) authentication
- **digest access authentication** 참고!

1) method inspection
- if) 지원되지 않는 method,  
  - 405 response를 보낸다.
  - 405 reponse와 함께 Header의 ALLOW field에 사용 가능한 Method list를 추가한다.
- if) 지원되는 method,
  - goto next steps

2) header inspection

**8.2.2.1 To and REQUEST-URI**
- TO : 초기 Request의 Recipient
- REQUEST-URI :

**8.2.2.2 Merged Requests**  
- To Field에 tag가 없다면 기존에 존재하는 transaction과 연관된 Request인지 체크해야한다.  

3) Content Processing(section 8.2.3)
- UAS가 이해할 수 없는 Content-type, Content-Language, Content-encoding이면 415(Unsupoorted Media Type) Response를 발행한다.
  위 Error Response와 함께 Accept Header Field를 붙여서 UAS가 이해할 수 있는 content에 대해서 나열한다.  

4) Applying Extension

5) Processing the Request  

6) Generating Response(section 8.2.6)
- INVITE Method에만 Provisional Response를 사용하고, 나머지 Method들에서는 Final Response를 바로 발행하여라.

**8.2.6.2 Headers and Tags**  
- Response의 Call-ID는 request의 call-id의 값과 같아야한다.
- Cseq도 같아야 한다.
- Via Field는 Request의 Via와 순서까지 동일해야한다.  
- Request에 To Tag가 있었다면 Response에도 동일한 To Tag가 있어야함.
> Tag 관련 :: section 19.3

---

### UAC behavior(rfc 3261, section 8.1)
**uac behavior outside of a dialog**  
- INVITE, OPTION이 해당된다.  

**8.1.1 Generating the Request**  
**8.1.1.1 Request-URI**  
- TO Field의 값과 같아야한다. (REGISTER 제외)
- 만약 이미 route-set field가 있다면, Request-URI에 영향을 미치게된다.
- Route-Set은 outside of dialog message들이 지나가야 하는 Server의 list들이다.
- Route-Set이 존재하는 경우에는 12.2.1.1을 따라서 Request-URI를 정해야한다.  

>>>>> 12.2.2.1

**8.1.1.2 To**  
- To Tag는 dialog의 peer를 확인하기 위함이다.
- 하지만 dialog가 수립되지 않았을때에는 To Field에 To Tag가 존재하지 않는다.
- To Field에 대한 자세한것은 20.39를 참조.

**8.1.1.3 From**  
- logical identity of the initiator of the request.
- UAC가 Request를 만들때이므로, From에 Tag가 들어가야 한다.

**8.1.1.4 Call-ID**  
- unique identified to group together a series of messages.
- Dialog내에서 ua들간에 전송되는 모든 Request와 Response는 같아야한다.
=>> 그래서 b2bua를 구현할 경우, 자기가 자체적으로 UAC 역할을 수행해야 하기 때문에 CreateRequest를 하여 새로운 Request를 만들고 새로운 Call-ID가 생성되게된다.

**8.1.1.5 Cseq**  
- **a way to identify and order transaction.**

**8.1.1.7 Via**
- **Transaction에 사용될 Transport**와 **Response가 보내어질 location을** 지정한다.  
- 반드시 **branch parameter**를 가지고 있어야한다. 이 param은 해당 Request에 의해 만들어진 transaction을 식별한다.
- request가 transport layer에 의해서 maddr, ttl 등의 값이 설정된다.
- Via관련 :: 16.6 item8 , 16.7 item 3

**8.1.1.8 Contact**  
- dialog를 만들 수 있는 모든 request에 포함되어야한다.
- Contact Field는 subsequent request를 위해 사용된다.

**8.1.3 Processing Response**  
- UAC는 모든 final response에 대해서 알지 못하는 것이더라도 x00 response로 간주하여 처리할 수 있어야한다.
- ex) 431 response를 받게 되면, 400으로 처리해야 한다.
- 또한, 100번 이상의 인식할 수 없는 Provisional Response에 대해서는 183(session progress)로 처리해야 한다.
따라서, **UAC는 100 response와 183 response를 반드시 처리할 수 있어야한다.**  

**8.1.3.4 Processing 3xx Response(keep)**
- 3xx response는 redirection 관련 response.
- UAC는 Response의 Contract field를 사용하여 redirect request를 만들어야한다.

**8.1.3.5 Processing 4xx Response**  
- 4xx Response는 method와는 무관하게 Response에 대해서 특정 handling을 해줘야한다.
- if) 401, 407
  - section 22.2, 22.3에 따라 인증 과정을 거쳐야한다.

**8.1.2 Sending the request**  
- request의 destination이 계산되어야한다.
