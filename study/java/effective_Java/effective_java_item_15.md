# item 15: Minimize mutability  
- immutable class :: instance cannot be modified. instance가 처음 만들어지고 초기화되고 나면 해당 instance의 내부 정보들은 사라지기 전까지 변하지 않는다.  

- immutable class를 만들기 위해서 다음 다섯가지 규칙을 따라라.  
1) object의 state를 바꿀 수 있는 method들을 제공하지 마라.(mutator 같은 것들)
2) class가 확장될 수 없음을 확실히해라.  
==> 일반적으로는 final class를 통해서 subclassing을 막는다.  
3) 모든 field들을 final로 만들어라.
4) 모든 field들을 private으로 만들어라.
5) Class의 field중에서 mutable object를 참조하고 있는 field가 있다면, Client code에서 이에 접근하지 못하도록.
