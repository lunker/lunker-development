# Pattern language
- 집이나 마을을 설계할 때 반복적으로 활용하면 좋을, 작은 단위의 설계 패턴들

# 마이크로서비스
- 독립적으로 배포 가능한 서비스들의 묶음


* Monolithic Applications
[특징]
- 단일, Monolithic App
- 전체 App을 함께 배포해야 함
- 전체 앱이 단일 DB사용
- 기술 계층 중심으로 구성
- 각각의 런타임 인스턴스에 상태를 보관
- 전체 앱이 하나의 기술스택을 채택

[문제점]
- scaling
- performance
- deploy
- down


* Microservices
[특징]
- 각 마이크로서비스를 독립적으로 배포
- 각 서비스들은 각자의 데이터 저장소를 가짐
- 비즈니스 기능 중심으로 구성
- 상태는 외부에 보관 (stateless)
- 각 마이크로서비스가 각자의 기술을 선택
- http를 통한 rest, messaging 또는 binary 통신을 이용

- 일부분의 장애가 전체의 장애로 이어지지 않는다




* 마이크로서비스 환경에서는 중간에 추가되는 마이크로서비스들로 인해 latency가 늘어나게 된다.
* eventual data consistency를 고려해야한다.
- 당장 데이터 정합성이 맞지는 않지만, 시간이 지남에 따라 점차 맞춰져가는 것
- 
