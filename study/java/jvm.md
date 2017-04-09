# JVM
---

## JRE
- Java API + JVM  
- JVM:: Java Application을 읽어 들여서 자바 API와 함께 실행한다.  
---

## JVM 구조  
**구성요소**  
- Execution engine
- Class Loader
- Runtime Data Area

- Execution Engine : Runtime Data Area에 할당되어 있는 bytecode를 읽어서 실행시킨다.  
-
- class loader : jvm내로 class를 로드하고 link를 통해 적절히 배치하는 일련의 작업을 수행하는 모듈.
- Java 프로그램이 실행되면, JVM은 OS로부터 이 프로그램이 필요로 하는 메모리를 할당받고, JVM은 이 메모리를 용도에 따라 여러 영역으로 나누어 관리한다.
---

## JVM의 기본 수행 과정  
- Class Loader를 통해 Class 파일들을 JVM으로 로딩
- 로딩된 Class 파일들은 Execution Engine에 의해 해석
- 해석된 프로그램은 Runtime Data Areas에 배치됨.
-

#### Runtime Data Area  
- 프로그램을 수행하기 위해 OS에서 할당 받은 메모리 공간  
- 총 5개의 영역이 존재한다.
1) method(Class Area)
2) heap
3) stack
4) PC Register
5) Native Method Stack  
6) Runtime Constant Pool

**Class Area**  
- 모든 스레드가 공유  
- Method 영역  
- Method Area, Code Area, Static Area로 불림

**Heap Area**  
- 모든 스레드가 공유
- new 연산자로 생성된 객체와 배열을 저장하는 공간  
- 클래스 영역에 로드된 클래스만 생성가능  
- Garbage Collector를 통해 메모리 반환   

**Stack Area**
- 스레드별로 생성된다.
- 메서드 안에서 사용되어지는 값들을(지역변수, 매개변수 등) 저장
- 메서드 수행이 끝나면 삭제됨  
- 메소드 작업에 필요한 메모리 공간을 제공한다.
- 메소드가 호출되면 해당 메소드를 위한 메모리가 할당된다.
- 스택 프레임이라는 구조체를 저장.
- 예외 발생시 사용하는 printStackTrace()의 stack이 이 부분  


**PC Register**  
- 스레드별로 생성된다.
- 현재 스레드가 수행중인 JVM 명령의 주소  

**Native Method Stacks**  
- Java외의 언어로 작성된 프로그램의 실행을 위함.
- Native Code로 되어있는 Function의 호출을 java 프로그램 내에서 직접 수행할수 있음.

**Runtime Contant Pool**
- 모든 스레드가 공유
---
## Garbage Collector  
- 참조되지 않는 객체들을 탐색 후 삭제
- 삭제된 객체의 메모리를 반환
- Heap 메모리 재사용  

## Heap Area 상세 구조  
(http://hipercube.tistory.com/entry/JAVA-JVM%EA%B3%BC-%EB%A9%94%EB%AA%A8%EB%A6%AC-%EA%B5%AC%EC%A1%B0%EC%84%B1%EB%8A%A5%EA%B0%9C%EC%84%A0%EC%9D%84-%EC%9C%84%ED%95%9C-GC%EC%9D%98-%ED%99%9C%EC%9A%A9)

- 
