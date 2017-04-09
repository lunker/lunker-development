# Generic  
- Class의 타입을 parameter로 만든 것.
- Generic을 사용 안하고 Object class를 이용하여 캐스팅을 통해서 사용할 경우 run time에서 에러를 발견할 수 있다.
- Generic을 사용하면 compile time에서 발견할 수 있다.
- Generic은 클래스뿐만 아니라 Method에서도 사용할 수 있다.




#### Generic Method
- 컴파일러가 타입추론(type inference)를 통해서 처리한다.


#### Type Bound
- Generic으로 사용될 타입에 상속 관계를 선언함으로써 사용되는 type에 제한을 가할 수 있다.
- T extends Numbers :: T에 들어올 type들은 Numbers를 상속해야한다.

#### Type Wildcard
- 
