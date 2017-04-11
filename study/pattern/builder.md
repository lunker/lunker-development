# Builder

- new foo(a,b,c,d,e,f,g,h, . . . ) 이런식으로 생성하면 귀찮음. 실수나 오타를 발견하기도 어렵다.
- new builder().a(a).b(b). . ....build()로 보기 좋게 바꾸기 위해 사용한다.
- 더불어 실수, 오타의 여지를 줄여주고, 생성 parameter의 조건에 제어를 가할 수 있다.
- builder 패턴의 가장 기본적인 아이디어를 객체 생성의 책임을 분리하는데에 있다.  
  - 내가 만들려 하는 객체 생성의 역할을 다른 객체에 위임하는 것.
  - 

**참고**  
- consumer supplier를 이용한 builder-pattern 구현  (https://01010011.blog/2016/12/29/java8-consumer-supplier-%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-builder-pattern-%EA%B5%AC%ED%98%84/)
