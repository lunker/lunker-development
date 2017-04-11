# Java 8

## default method, static method  
- interface에 method를 구현할 수 있다.  
- default accessor로 method를 구현하면, 해당 interface를 구현한 모든 클래스에서는 default method를 사용할 수 있다.  
- static 으로 method를 구현하면, interface를 구현한 클래스를 통하지 않고, interface를 통해서 직접 method를 사용할 수 있다.  

## Functional Interface  
- "자바 인터페이스에서 구현해야할 메서드가 딱 하나만 있다면 이를 함수형 인터페이스(Funtional Interface)라고 합니다."
- 기존에도 이미 인터페이스에 method가 1개만 있는 경우는 많았다.
- 단지 @functional interface는 컴파일 레벨에서 해당 인터페이스가 구현할 method를 1개만 가지고 있는 인터페이스라는 것을 미리 알리기 위함.  
- 그럼, 이 functional interface는 람다에서 왜 필요한가 ?
- 람다에서 함수형 인터페이스의 필요성? 역할은 무엇인가 ?
- 모든 method는 어떤 의도나 동작 방식을 가지고 있다. 이런 의도를 표현하는 것이 함수형 인터페이스이다.  
- 자바8에서 기본적인 형태의 functional interface를 미리 정의해둠.
  - consumer/supplier/function/predicate  4가지.

## lambda
- 익명 클래스와 기능적으로는 동일하다.  
- 하지만 차이점은 분명히 존재한다.
  - 익명 클래스의 인터페이스 구현으로 인한 반복되는 코드가 사라지게 된다.
  - 익명 클래스에서의 this는 익명 클래스 자신을 가리키지만, 람다 표현식에서의 this는 람다 표현식을 감싸고 있는 클래스를 가리킨다.  
  - 또한 성능면에서도 익명 클래스에 비해 이점이 있다.  

## Stream
- Collection을 stream으로 다룰 수 있게 되었다.
- 기존의 collection을 stream으로 생성할 수 있다.  
- stream은 "생성","중간연산","최종연산" 으로 수행된다.  
- 스트림은 값을 저장하지 않는다. 연산 파이프 라인을 거치는 데이터 구조를 통해 값을 나르기만 한다.  
-


---
**참고**  
- http://www.moreagile.net/2014/04/AllAboutJava8.html
- http://jinson.tistory.com/entry/%ED%95%9C%EA%B8%80%ED%99%94-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-5-%EB%9E%8C%EB%8B%A4%EA%B0%80-%ED%95%84%EC%9A%94%ED%95%9C-%EC%9D%B4%EC%9C%A0-2
- 자바8 살펴보기 : http://www.moreagile.net/2014/04/AllAboutJava8.html

- public : 클래스, 변수, 메소드 생성자 등의 모든 접근을 허용한다.
             보통 상수(static final 변수), 메소드(get/set) 등에 많이 사용.

- protected : default와 같으나 추가적으로, 다른 패키지의 하위클래스에서도 상속 가능.

- default : 같은 패키지에 있는 (클래스, 변수, 메소드, 내부클래스)에서 접근 가능하다.
              접근 변경자가 없는 선언되지 않은 것이 default

- private : 같은 클래스에서만 접근이 가능하다.
              보통 인스턴스 변수, 외부에서 호출해서는 안되는 메소드
