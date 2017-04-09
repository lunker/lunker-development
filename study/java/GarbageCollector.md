# Garbage Collector  
- Minor GC : 0.5초이내 끝난다.
- Full GC : 수초가 수요되고 도는동안 Java Application이 멈춰버린다.



- Stop the world : GC를 실행하기 위해 JVM이 어플리케이션 실행을 멈추는 것.
  GC를 수행하는 스레드를 제외한 모든 스레드가 멈추게 된다.

- 메모리 해제 :: Heap이나 Method Area에 있는 특정한 객체들을 메모리에서 삭제.

## GC절차(http://stophyun.tistory.com/37)  
- 자바 객체는 Eden영역에 속한다.(메모리할당)
- Eden 영역이 간당간당해지면 GC 필요성이 생긴다.
-
