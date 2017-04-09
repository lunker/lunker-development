# item 8 : obey the general contract when overriding equals




- 'equas' method를 overriding할 때는 다음과 같다.  
- class에 논리적인 '=' 개념이 존재 할 때 overriding 해야한다.( 단순히 object의 id의 equal 체크와는 다르다.)
- class의 equal method가 container 같은 곳에서 비교할 때 쓰이나 봄.  
  ex) list.contains(object)를 수행할 때, 해당 class의 equals를 사용하여 찾고자 하는 객체가 있는 지를 검사한다. 그렇기 때문에 잘못된 'equals'의 구현은 시스템에서 오류를 찾기 어렵게 만든다.  



**recipe for high-quality equals method**  
- == operator를 사용하여 argument가 자신의 object를 가르키는지 체크한다.
- instanceof operator를 사용하여 올바른 type인지 체크한다.  
- 올바른 type으로 casting 한다.
- argument와 현재 object의 field를 검사하여 동일성을 체크한다.
- 항상 equals와 함께 hashcode method도 overriding 해라.  
-
