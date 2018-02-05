[proxy]
* 리팩토링
* gradle화 진행
* 통화 기능 구현
* TDD일부 구현

[kms]
* Media Server의 Failover 구현
  [목적]
    - 무중단 서비스를 구축하기 위하여

  [Dependency]
    - c&c++
    - redis
    - Java8
    - redis & Invoker(Spring Boot Application) 구현

* Media Server의

* opensource library custom화 & 사내 라이브러리화(kurento client)
  - open source의 버전업 관리를 위하여 interface화 해서 필요 기능 구현
  - 해당 라이브러리 nexus를 통한 배포

[기타]
* ELK를 이용한 로그 모니터링 시스템
  [목적]
    - 
  [SKills]

* media server monitoring (kmm)
  [Dependency]
  - Java8
  - Spring boot
  - 내장DB
  - websocket을 이용하여 event driven으로 구현

* 로그 모니터링 시스템 개발(sip-agent)
  [Dependency]
  -
  [Overview]
  - 각 application에서 남기는 로그들을 수집하여 Parser에게 전송하는 component 개발.
