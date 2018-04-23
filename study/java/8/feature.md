# Java 8에 새롭게 추가된 특징들

## Lambda
- anomymous function
- method의 parameter로 넘길 수 있다.
- 코드 간결( 익명 클래스와는 달리 중복될만한 코드를 구현할 필요가 없다 )
- 비동기

[Functional Interface]
-

- 람다표현식은
  1. 변수에 할당하거나
  2. 함수형 인터페이스를 인수로 받는 메서드로 전달할 수 있으며
  3. 함수형 인터페이스의 추상 메서드와 같은 시그니처를 갖는다는 것

## Functional Interface
- Abstract method가 하나인 인터페이스
ex)
  - function -> parameter o , return o
  - consumer -> parameter o , return x
  - predicate -> parameter o, return boolean
  - supplier -> parameter x, return o


## Closure
-

## Method Reference

## Stream API

## Parallel Stream

## Default Method
- 인터페이스에 메서드 구현체를 추가할 수 있다.
- 그리고 인터페이스의 구현체에서 해당 method를 그대로 사용할 수 있다.
-

## Optional
- 값을 Optional<T> 로 캡슐화하여 NPE를 막는다.

## CompletaleFuture
