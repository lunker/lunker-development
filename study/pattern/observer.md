Observer Pattern 

- 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고, 자동으로 내용이 갱신되는 방식으로, 일대다 의존성을 정의함



- 주제객체(Observable) 
- 구독객체(Observer) 

- 옵저버패턴은 주제객체와 구독객체의 관계를 느슨한결합(Loose Coupling)을 이용해 관리한다. 
이로 인한 이점은 아래와 같다.
	- 주제는 옵저버의 구상클래스가 무엇인지, 무엇을 하는지 알지 못해도 된다 
	- 옵저버의 추가, 제거가 자유롭다 
	- 새로운 형식의 옵저버를 추가해도 주제를 변경할 필요가 없다 
	

- 상태를 전달하는 방법은 2가지	
	- PUSH: 주제객체가 구독객체에게 상태를 보내는 방식
	- PULL: 구독객체가 주제객체에게 상태를 가져오는 방식 (요청)  















--- 
- http://friday.fun25.co.kr/blog/?p=157
- 
