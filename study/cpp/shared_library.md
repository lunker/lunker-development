# Shared Library


## Compiler
1) C Pre Processor (cpp)
- #define, #include 등의 구문을 전처리한다
- 결과로 <name>.i 를 생성

2) C compiler (cc1)
- 전처리한 소스 <name>.i를 어셈블리어로 컴파일한다
- <name>.s 생성

3) Assembler
- object 생성

4) Linker
- printf 등 외부 library에 있는 symbol을 링크하여 최종 프로그램(a.out) 생성


## dynamic loader
- 공유 라이브러리와 연결된 프로그램을 실행하면,내부적으로 dynamic loader가 먼저 동작한다.
- dynamic link 된 공유 라이브러리를 찾아서 메모리에 로딩
- entry function을 찾아서 호출
- 프로그램 실행 


https://www.lesstif.com/pages/viewpage.action?pageId=12943542
