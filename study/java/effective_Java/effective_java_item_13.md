# Item 13: Minimize the accessibility of classes and members  

- 잘 설계된 module의 척도 중 하나는 내부의 데이터와 다른 모듈의 구현부를 얼마나 많이 숨겼는가이다.
==> Encapsulation.
- 모듈들은 내부 구현을 숨긴채 API를 통해서 서로 통신한다.
- 
- **Instance fields should never be public**
==> 변할 가능성이 있는 instance field를 public으로 하게 되면 해당 field에 대해서 통제력을 잃게된다.  
- **class with public mutable fields are not thread-safe**  
- static field에 대해서도 마찬가지이다.  
- 일반적으로 상수 표현식으로 publbic static final을 사용한다. 이 final 변수에는 mutable object에 대한 reference가 들어갈 수 있다. 이렇게 되면 final variable의 의미가 사라지게 된다.
reference는 변하지 않아도 referenced object의 값은 얼마든지 바뀔 수 있다.

- nonzero-length array always mutable.
- public static final Thing[] List = {}; 와 같은 코드일 경우 다른 방법으로 구현해라.  







#### Summary  
- 가능한 최대한으로 accessibility를 줄여라.
- minimal public API를 설계.
- public class는 public field를 가지면 안된다.
