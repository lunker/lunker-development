# Lambda


- 클래스 없이 함수구현체가 존재할 수 있게됨
- 왼쪽의 (User 01, User 02) 부분은 functional interface(추상 메소드가 하나만 있는 인터페이스)에 선언된 추상메소드의 argument 를 나타낸다.
- 오른쪽 부분은 추상메소드의 구현내용(implementation)을 적어주는데 return type은 interface 의 추상메소드 signature를 따라 자동으로 결정된다. ( Runnable의 경우 void 임 ).
- 추상 인터페이스 메소드의 구현체 내부에서 외부에 있는 변수에 접근이 가능하다. ==> "클로저", "변수포획" 이라고 불린다.  
- 


**참고**  
- https://www.slideshare.net/gyumee/java-8-lambda-35352385
