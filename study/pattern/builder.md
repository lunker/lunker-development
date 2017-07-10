# Builder

- new foo(a,b,c,d,e,f,g,h, . . . ) 이런식으로 생성하면 귀찮음. 실수나 오타를 발견하기도 어렵다.
- new builder().a(a).b(b). . ....build()로 보기 좋게 바꾸기 위해 사용한다.
- 더불어 실수, 오타의 여지를 줄여주고, 생성 parameter의 조건에 제어를 가할 수 있다.
- builder 패턴의 가장 기본적인 아이디어를 객체 생성의 책임을 분리하는데에 있다.  
  - 내가 만들려 하는 객체 생성의 역할을 다른 객체에 위임하는 것.

- bulider pattern은 창조적 디자인 패턴이며 이것은 factory pattern 또는 abstract factory pattern과 매우 비슷하다. 이 패턴에 들어가기 전에 factory pattern과 abstract factory pattern들의 문제점(수 많은 attributes을 사용해야 패턴을 사용할 수 있는 점)에 대해 먼저 알아보자.
factory pattern과 abstract factory pattern에는 3가지 중대한 문제점이 있다.
수 많은 파라메터들이 클라이언트 클래스로 부터 전달 되는데 이것은 에러를 발생시키는 경우가 많다. 왜냐하면 거의 대부분의 경우 argument(인자)들의 type이 같고 클라이언트 쪽에서는 인자들을 정확히 유지시키기 어렵기 때문이다.
몇몇의 파라메터들은 값을 보낼때 선택적인데 factory pattern에서는 모든 인자를 전송해야 한다. 그리고 선택적인 파라메터들은 꼭 null을 입력해서 보내야한다.
만약 생성시키는 object가 무거운 경우(파라메터가 많은 경우) 만들기가 매우 복잡해지며, 이런 factory pattern의 복잡성으로 인해 결국 혼란스럽게 된다.
우리는 이런 문제점을 생성자(constructor)의 인자 갯수를 바꿈으로 해결할 수 있다. 하지만 이런 방식의 문제점은 모든 attribute들이 명시적으로 set 되지 않는 한 object의 상태는 일괄성이 없어지게될 것이다.
builder pattern은 선택적인 파라메터가 많을 경우 제공 상태를 일관성 있게 해주고, object를 생성시킬때 step-by-step으로 만들 수 있도록 제공해주며 최종에는 만들어진 object를 리턴한다.


- 불필요한 생성자를 만들지 않고 객체를 만든다.
- 데이터의 순서에 상관 없이 객체를 만들어 낸다.
- 사용자가 봤을때 명시적이고 이해할 수 있어야 한다.

**참고**  
- consumer supplier를 이용한 builder-pattern 구현  (https://01010011.blog/2016/12/29/java8-consumer-supplier-%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-builder-pattern-%EA%B5%AC%ED%98%84/)
- factory, builder pattern 비교 http://seotory.tistory.com/29
