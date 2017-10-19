# TDD  


## How?

- 기본적으로 동작 가능한 코드를 작성한다.
- 해당 메서드가 수행할 기능에 대해서 테스트 코드를 미리 작성한다.
- 테스트 코드들이 모두 통과 될 수 있도록 코드를 추가한다.
- 리팩토링을 진행한다.
- 이를 반복한다.

*TDD는 다음과 같은 순서로 진행을 하면 된다. 이 순서는 켄트벡이 제시한 순서이다.
1. Quickly add a test(테스트 프로그램을 작성한다.)
2. Run all tests and see the new one fail
(모든 테스트 프로그램을 수행시키고 테스트에 실패한 부분을 확인한다.)
3. Make a little change(소스를 추가하거나 변경한다.)
4. Run all tests and see them all succeed
(다시 모든 테스트를 수행시키고 모두 테스트를 통과했는데 확인한다.)
5. Refactor to remove duplication(중복을 제거하기 위해 Refactoring 한다.)*

그리고, 수시로 객체 지향과 패턴을 적용하여 리팩토링 하여라.


- 버그를 발견하면, 해당 버그를 찾아내는 단위 테스트를 작성한다.
- 버그를 수정 후, 해당 단위 테스트를 통과해야한다.
- 테스트는 위험이 있는 곳에만 집중시켜야한다.
-

##
"단위 테스트 케이스의 이름은 명확하고 일관되게 테스트의 의미를 반영해야 한다."


"private 메소드를 포함한 모든 메소드들은 가시범위에 상관없이 적절한 단위 테스트들을 수행해야 한다."

"테스트 코드 내에서 아무것도 출력하지 마라 "
"정적 변수를 테스트 클래스 내에서 사용하지 마라. 만약 사용했다면, 각 테스트 케이스 실행시마다 재 초기화해라"


## JUnit
- test fixture : 기본적으로 테스트의 샘플 역할을 하는 객체
- test suite : 여러개의 test suite나, test case들을 묶어서 실행할 수 있다.
-

@ Test Case


@ Test Suite
- https://www.tutorialspoint.com/junit/junit_suite_test.htm
- https://github.com/junit-team/junit4/wiki/Aggregating-tests-in-suites


## 단위 테스트와 기능 테스트
- 단위 테스트::
  - 단위 테스트의 목적은 프로그래밍 생산성 향상이다.

- 기능 테스트::
  - 목적은 소프트웨어 전반이 제대로 돌아가는지 확인하는 것이다.
  - 고객에게 품질 보증만 할 뿐 프로그래머의 생산성과는 무관하다.


# Reference
- tdd 관련
https://nesoy.github.io/articles/2017-01/TDD
- junit test suite 사용법
https://www.tutorialspoint.com/junit/junit_suite_test.htm
