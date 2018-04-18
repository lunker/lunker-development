Akka 의 장점

- 반응성(responsiveness) : 빠르게 응답하는 것이다. nonblocking/asynchronous 에 따른 시간의 절약을 보장한다.

- 탄력성(elasticity): 유연한 스케일을 보장한다. Scale out 을 자동으로 보장해준다. (자동까진 그렇고, 구성파일 설정에서 가능하다).. 확장성이란 말에는 Scale-down이 포함이 안되어 있다보니..

- 유연성(resilience)  : 장애 허용와 관련, 장애나 에러 발생시에 그런 사실에 구애받지 않고, 일관성있는 반응성을 유지
    replication(중복), isolation(격리), delegation(대리)와 같은 기법 사용 

- 메시지 중심(message-driven) : event-driven 에서, 메세지 중심으로 한 것은, 사건은 목적지가 없지만, 메세지는 목적지가 있기 때문.

- 모듈화 : 아카세계에서의 컴포넌트는 Actor 이고, 이 Actor는 서로 완벽하게 독립적이며, 코드의 응집성, 느슨한 결합, 캡슐화와 같은 프로그래밍 원리를 와벽하게 구축한다.

- Java 보다 추상수준이 더 상승된 것으로 보면 어떨까? 



Akka 의 특징 

- Actor의 메일박스,Dispatcher에 의한 thread 할당 

- Actor 간의 메세지 송수신 및 라이프 사이클

- try,catch와 달리, 어느 액터가 발생시킨 예외는 그 Actor의 supervisor가 곧바로 처리하겠다라는 strategy.

- if-else 구문 대신에 상태기계을 이용하여 처리(Procedure 객체)... 

- 병렬 처리 매카니즘의 router을 통해 쉽게 확장

- 메세지를 보내고 잊지 않고 트래킹할 때 사용되는 future (Patterns.ask).. nonblocking 가능한 onSuccess,onComplete,onFailure

- Actor와는 다르게 값(상태), 동작을 동시에 포함하는 것에 비해 , 내부 코드가 없는 Agent는 값(상태)만 포함

- 구성파일 설정을 통한 clustering 구현 


