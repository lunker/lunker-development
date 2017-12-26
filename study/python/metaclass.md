# Metaclass  
- 파이썬에서는 클래스 또한 객체이다.
- 메타클래스는 클래스의 클래스이다. 즉, 파이썬에서 다루어지는 모든 객체들을 생성하는 최상위 클래스이다.
- type 클래스는 객체를 생성하는 메타클래스이다.
모든 것, Python에서의 모든 것은 객체입니다. 여기에는 정수, 문자열, 함수, 클래스를 포함합니다. 이 모든 것들은 객체입니다. 그리고 이 모든 것들은 클래스로부터 생성됩니다:

- __metaclass__는 클래스 객체를 만들때 사용되어진다.
  - python은 클래스 정의에 __metaclass__가 있는지 먼저 확인한다. 있을경우, 이를 이용하여 클래스 객체를 만든다.
  - 발견하지 못하면 type을 사용한다.


- 메타클래스의 주 목적은 클래스가 만들어질 때 클래스를 자동으로 바꾸기 위함이다.
- 메타클래스를 정의하면, 모듈 내에 있는 모든 클래스의 생성에 영향을 미친다.
-










# Ref
- https://code.tutsplus.com/ko/tutorials/quick-tip-what-is-a-metaclass-in-python--cms-26016
-
https://tech.ssut.me/2017/03/24/understanding-python-metaclasses/
