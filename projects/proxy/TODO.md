# TODO

<scf>
- acceptedDomain :: properties(ReadAddressProperties.java)와 rest(AcceptedDomainsServiceImpl.java) 2개가 있는데 현재는 rest만 쓰는듯.이거 없애도록.
- proxy_registrar에 있는 model들. rest와 proxy가 공통으로 사용할 수 없나 ?
- proxy_registrar의 용도 및 scf(sip)과의 관계, 역할 명확히

- scf관련 aop (logging) 적용 검토

- gradle화 & 관련 lib들 소스 있나 확인

- 하드코딩(key, name, 등등등) 걷어내기

- project내부에 있는 lib 폴더를 tomcat에서 사용하도록 변경

- statemachine ?

- invite를 날릴때마다 OPMD로 인하여 스레드 생성 -> 스레드 풀 사용으로 변경

- changeRedisInfo()-> sip request가 들어올때마다 registration 정보를 엎어친다...;

doRequest
- communicationsessionutil, sipapplicationsessionutil 사용 안하고 소스 바꾸도록.


// - register 된 device list를 local에서 사용하지 않고, rest를 통해서 매번 가져오는거 같다...?

- SIP Message에서 필요한 부분 가져오는 parser 따로 필요할듯.

- SIP Message send하는 method 및 클래스 하나로 통합.

- homer5를 위한 logging 모듈화
- 세종 연동 테스트 코드 '07079999800' 관련 코드 삭제
- test case, test code 작성
- ParticipantAgent 등 안쓰이는 코드 및 로직 정리

- update처리시에, 180 ringing이 와야 update를 처리하고 있다. 하지만, rfc에는 180이 아니라 offer/answer를 기준으로 하기에 이를 바꿔야함.
- sip request 처리시에 기본적으로 필요한것들을 공통적으로 처리하는 전처리 모듈을 따로 개발.
- Constants에 HISTORY_STATUS_ONE... 이게 뭐니





- domain(회사별), xxx,yyy에 따라 다른 서비스를 제공해야 할 수도 있다. 이를 다르게 동적으로 정할 수 있도록!


=====================================
<proxy_registrar>

- java swagger -> rest api 문서화
- auto rest docs
- swagger를 이용하면 가능하지 않을까... ? -> rest 호출 관련 테스트 툴
- proxy_registrar aop (logging) 적용 검토
- rest api를 json으로 떨구고, 이를 읽어와서 proxy에서 사용하는 방법은 없나 ? -> url or parameter 변경으로 인해서 빵꾸나기 쉬움.
- rest 호출 관련 테스트 툴의 필요성
- spring statemachine : https://github.com/spring-projects/spring-statemachine
- invalidusecode 하드코딩 수정
- Registrar 로직이 이상하다.
  -> AoR, useragent, callid를 이용하여 해당 계정의 비밀번호를 가져온다.
  -> 비밀번호가 있으면 비밀번호를, 없으면 null을 반환한다.
  -> 반환 결과가 null이 아니면 인증 성공으로 한다.

- 매번 invite때마다 device list를 가져오기 위해서 rest를 요청하는데, 이를 varnish cache를 이용해서 빠르게 하기.
- rest call 이후 response를 받은 다음에 condition을 바꾸지 않고 미리 바꾼다.
- 하드코딩 싹다 정리





====================

공통적인 일
[forwardRequest()]
- SipUri 설정 (client)
- RouteHeader 설정 (lb)
=> 이것을 설정 하기위해서 target을 찾아야 하는데,
target을 쉽게 찾는 방법 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

* caller, callee 라고 구분 짓지 말고 , source&target으로 구분.
* SipUri 설정하기!

[relay] ????????????????????????????????????????????????????????????알수없음
- network변경해도 proxy에 re-invite를 안보내준다.
- network 변경하면 바로 register 들어온다.

as-is:
  - 마지막 re-invite찾아서 거기로 메세지를 보냄.

to-be:
  - sip message전송할때 무조건 registration 정보를 보고서 sipuri 설정해야함.

* attribute 사용하는거 안하는거 정리

——————
** find target session :: sipsession이 opmd로 인해 2개 이상…ㅠㅠㅠ

=======================================================================
=======================================================================
=======================================================================
=======================================================================
=======================================================================
=======================================================================

doRequest에서는

proxy는 callee를 모르는 상태
-> 일차 전처리

전처리~~~
  - callee를 알아야 하는 경우
  - callee를 몰라도 되는 경우  : keepalive, options 등등등  

레스트 다녀온 후에 callee의 정보가 정해짐.
—————————
상대방이 정해졌을때, Conversation을 만들때
1) 상대방은 정해졌는데, conversation은 만들지 않아도 되는 경우
-> busy 등등 ( callee에게 메세지를 줄게 없을때)
2)
——————————
상대방이 정해지고, push를 보내고
—————————(forwardRequest)
** forwardRequest에는 꼭 보내야 할것만 들어오도록 전처리
** 지금은 forwardRequest에서 보내거나 안보내거나 갈리고 있따
** kurento client 처리 로직도 섞여있다

————————— 공통과제
- SAS, SS attribute에서 custom객체 삭제
  - 필요하면 id를 통해서 가져와서 사용하도록
  -
- 내로그
-
