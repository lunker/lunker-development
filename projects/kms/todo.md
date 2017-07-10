# TODO
1.
- proxy 비정상 종료 시나리오
  - 기존에 수립된 통화가 2번의 GC 후 끊긴다. 끊기지 않도록 막아야함.
  - proxy가 해제 못한 media component들은 2번의 GC후에야 끊기게 된다. 그동안에 kms가 rtpendpoint로 rtcp를 보낸다.

2.
- proxy에서 어떠한 경우에도 release를 못한경우, 남아 있는 element release 처리 .

===>
Solve)
- 일단, 통화가 끊긴 후에는 자원을 즉시 해제하도록 해야한다.  
  -> 통화가 끊겼을때 발생하는 event를 이용하여 kms가 직접 release, mediaset()의 release를 호출하도록 해서 바로 해제시키도록 한다.
  -> **정상 시나리오와, proxy shutdown시의 시나리오를 수행하여 다르게 발생되는 이벤트가 있는지 확인한다.**   

  **Event**  
  - 정상 시나리오 : connected, flowing만 발생. 통화중에 not flowing 발생.
  - proxy shutdown(release, destroy X) : disconnected, not flowing 발생.

- 두번째로는, 기존에 수립된 통화(media component)를 보존해야 한다.
  - proxy가 정상적으로 종료시켰는지, proxy shutdown으로 인한 client disconnect 인지 분간해야한다.
  - 그래서 그에 따라 sesison을 바로 invalidate 상태로 빠지게 하는게 아니라, alive, invalidate 사이에 XXX라는 상태에 빠지게 하여 GC의 대상에서 벗어나도록 한다.  

  **Test**  
  - childrenMap == 0 & sessionMap size == 0 => session dead
    

2.
- Proxy가 살아있는데, release, destroy를 못한 경우,  
  - 통화가 끊기면 rtp stream은 끝나지만, rtcp는 계속 살아남아있게된다.
  - 그래서 2번의 GC후에야 GC를 통해서 Media Element들이 해제된다.

/*
- proxy가 정상적으로 release, kurento client destroy를 하면,
  - 2번의 GC없이 바로 async_delete가 호출되어 Media Component를 삭제한다.
*/
