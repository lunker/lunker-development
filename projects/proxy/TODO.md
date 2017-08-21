# TODO

<scf>
- acceptedDomain :: properties(ReadAddressProperties.java)와 rest(AcceptedDomainsServiceImpl.java) 2개가 있는데 현재는 rest만 쓰는듯.이거 없애도록.
- proxy_registrar에 있는 model들. rest와 proxy가 공통으로 사용할 수 없나 ?
- proxy_registrar의 용도 및 scf(sip)과의 관계, 역할 명확히

- scf관련 aop (logging) 적용 검토
- gradle화 & 관련 lib들 소스 있나 확인 => 있음. 소스 따서 커스텀화
- 하드코딩(key, name, 등등등) 걷어내기
- project내부에 있는 lib 폴더를 tomcat에서 사용하도록 변경
- statemachine ?
- invite를 날릴때마다 OPMD로 인하여 스레드 생성 -> 스레드 풀 사용으로 변경
- changeRedisInfo()-> sip request가 들어올때마다 registration 정보를 엎어친다...;
- communicationsessionutil, sipapplicationsessionutil 사용 안하고 소스 바꾸도록.
- register 된 device list를 local에서 사용하지 않고, rest를 통해서 매번 가져오는거 같다...?
- SIP Message에서 필요한 부분 가져오는 parser 따로 필요할듯.
- SIP Message send하는 method 및 클래스 하나로 통합.
- homer5를 위한 logging 모듈화
- 세종 연동 테스트 코드 '07079999800' 관련 코드 삭제
- test case, test code 작성

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
  ->

- 매번 invite때마다 device list를 가져오기 위해서 rest를 요청하는데, 이를 varnish cache를 이용해서 빠르게 하기.
-
