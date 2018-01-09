# Event Sourcing

- 이벤트 소싱은 모든 변화에 대한 로그를 얻을 수 있다.
- event object에 의해서 생긴 domain objects에 있는 변화를 모두 보장할 수 있다.
- 이러한 특징으로 인해, 주요한 특징을 가진다.
  * Complete Rebuild:
    *
  * Temporal Query
  * Event Replay

- event sourcing의 대표적인 예는 version control system이다


## Structuring the Event Handler Logic

- 'Processing domain logic' : application에서 조작하는 비즈니스 로직을 담당한다
- 'Processing selection logic' : event에 따라 어떤 비즈니스 로직을 처리할지 선택한다.
