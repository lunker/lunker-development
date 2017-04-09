# Item 7. Avoid finalizers


- 자바의 메모리 해제는 GC에 의해 수행된다.
- finalize()는 gc에 의해 호출된다.  
- finalize()에서 발생되는 exception들은 try-catch로 잡을 수 없고 gc가 버려버린다.
- 또한, finalize()는 실행된다는 보장이 없다. 실행이 될 수도 있고 안될 수도 있다.


- 그래서, finalize()가 실행되기를 기대하고(보장하고) 거기에 중요 로직을 넣으면 안된다.  
예를들어, db에 대한 자원을 해제한다는가 이런것을 넣을경우 시스템이 중단될 것이다.

- finalize()를 하게되면, 객체가 unreachable이 되고 gc가 돌기전에 finalize queue에 객체들이 쌓인다. 그래서 queue가 꽉 차게 될 경우 out of memory가 발생하여 시스템이 죽을 수도 있다.

- finalize()에서 예외가 발생할 경우, 해당 예외는 무시되고 해당 객체의 finalization은 중지된다. 그러면 해당 객체는 corrupt state로 남게된다. 이때 다른 객체에서 해당 객체를 사용하려 할 경우, 객체의 state가 이상하기 때문에 이상한 동작을 하게된다.

- 또한, finalizer를 사용하는 데에는 성능 저하를 야기한다.

- 그러면 finalizer대신에 파일이나 스레드와 같이 종료가 필요로 하는 자원을 사용할 경우, 어떻게 종료해야 하는가?
-> expicit termination method를 제공해라!
-> 그래서 해당 instance가 더이상 필요치 않을 때 해당 method를 호출하도록한다.


**explicit termination**  
- try-finally 구문을 사용하여 예외가 발생해도 실행이 보장됨.



**그러면 언제 finalizer를 사용해야 하는가?**  
- explicit termination method가 호출되지 않았을 때 . . .자원의 해제를 보장하기 위한 안전망으로 사용되어야 한다.  
