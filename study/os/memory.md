# Memory

## Stack & Heap & Data
1) Stack
- 함수 호출과 관련한 데이터들이 적재된다.
- 함수가 실행되면서 필요한 매개변수, 지역 변수 등의 데이터가 생성되고 소멸된다.
- 함수 호출을 위한 복귀 지점 등의 데이터도 저장된다.
- stack memory size는 컴파일 타임에 결정된다.


2) Heap
- Runtime에 크기가 결정된다.
-


3) Data
- 전역변수, static 변수 등이 적재된다.
- 프로그램이 실행될 때 생성된다.
- 프로그램이 종료될 때 시스템에 반환된다.
-  

→stack의 지역변수는 사용하고 소멸하므로 데이터 용량의 불확실성을 가지므로 밑에서부터 채워 올리고 heap은 위에서 부터 채워 내려진다. 용량의 불확실성은 컴파일러가 알아서 메모리영역을 선택(랜덤적)



-stack영역에서의 주소값은 시작주소는 밑에서부터(먼저선언된 순서) 그다음 주소는 순서대로 정해진다.



HEAP overflow-heap이 위에서부터 주소값을 채워져 내려오다가 stack영역을 침범하는 경우.

STACK overflow-stack영역이 heap을 침범.



출처: http://sfixer.tistory.com/entry/메모리-영역code-data-stack-heap [Block Busting]
