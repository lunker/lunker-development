# JVM
---

## JRE
- Java API + JVM  
- JVM:: Java Application을 읽어 들여서 자바 API와 함께 실행한다.  
---

## JVM
- Java 프로그램이 실행되면, JVM은 OS로부터 이 프로그램이 필요로 하는 메모리를 할당받고, JVM은 이 메모리를 용도에 따라 여러 영역으로 나누어 관리한다.

## JVM 구조  
**구성요소**  
- Execution engine
- Class Loader
- Runtime Data Area

- **Execution Engine**  
  - Runtime Data Area에 할당되어 있는 bytecode를 읽어서 실행시킨다.  
  - Byte code를 실행 가능하게 해석해주는 기능
  - 바이트 코드를 jvm내부에서 기계가 실행할 수 있는 형태로 변경한다. 그 방식에는 2가지가 있다.
    - 인터프리터 :: 바이트 코드를 실행할 때 마다 읽어서 기계어로 변경한다.
    - JIT Compiler :: 인터프리터 방식으로 동작하다가 적절한 시점에 바이트코드 전체를 컴파일하여 네이티브 코드로 변경하고 이후에는 메서드를 더이상 인터프리팅 하지 않고 네이티브 코드로 직접 실행한다. 변경한 코드를 캐시에 보관해둔다.  

- **class loader**  
  - jvm내로 class를 로드하고 link를 통해 적절히 배치하는 일련의 작업을 수행하는 모듈.
  - Class 파일을 메모리(Runtime Data Area)에 적재
  - 동적 로드를 수행한다. 컴파일 타임이 아니라, 런타임에 클래스를 처음으로 참조할 때 해당 클래스를 로드하고 링크하는 특징이 있다.
  - 클래스 로더는 로드된 클래스들을 보관하는 namespace를 갖는다.
  - 클래스를 로드할 때 이미 로드된 클래스인지 확인하기 위해 namespace에 보관된 FQCN을 기준으로 클래스를 찾는다. fqcn이 같더라도 네임 스페이슥 다르면,(== 다른 클래스 로더가 로드한 클래스)이면 다른 클래스로 간주된다.
  - class loader는 계층 구조를 갖는다. 최상위 class loader는 bootstrap class loader이다.
  - bootstrap class loader :: Object class를 비롯하여 java api들을 로드한다.
  -

- **Runtime Data Area**  
  - 프로그램을 수행하기 위해 os에서 할당받은 메모리 공간.
  - class, stack, heap, native method, pc register 공간으로 구성된다.

  1) Class Area(==Method area, code area, static area)
    -

  2) Stack Area
    - method 호출 시마다 각각의 stack frame이 생성.
    - method 안에서 사용되어지는 값들, 호출된 method의 parameter, local variable, return value 등의 값을 임시로 저장.
    - method가 끝나면 해당 stack frame이 삭제된다.

  3) Heap Area
    - new 연산자로 생성된 객체와 배열을 저장하는 공간
    - Class Area에 로드된 class만 생성가능하다.
    - Garbage collector를 통해 메모리가 반환된다.

  4) native method stack area
    - 자바 이외의 언어에서 제공되는 method들이 저장되는 공간

  5) pc Register
    - thread가 생성 될 때마다 생성되는 공간
    - thread가 어떤 부분을 어떤 명령으로 실행할지에 대한 기록
    - 현재 실행되는 부분의 명령과 주소를 저장  

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



**참고**  
- http://d2.naver.com/helloworld/1230
- http://stackoverflow.com/questions/2129044/java-heap-terminology-young-old-and-permanent-generations
- http://lyb1495.tistory.com/3
- http://drkein.tistory.com/95
