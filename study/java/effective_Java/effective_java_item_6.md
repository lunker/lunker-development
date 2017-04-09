item 6. eliminate obsolete object references  


- garbage-collected language이기에 메모리 관리를 신경안써도 될 것 같지만, 실제로는 그렇지 않다.  
- memory leak은 garbage collector의 활동을 늘리는 이유이기 때문에 성능의 저하로 이어진다.
- 또한 이러한 memory leak은 disk paging을 야기하고 더 나아가서는 OutOfMemoryError를 뱉는다.  
- 의도치않게 참조가 유지되고 있는 객체는 GC의 대상이 아니게 되고, 해당 객체에서 참조중인 다른 객체들도 마찬가지이다. 즉, 하나의 객체로 인하여 여러 객체가 살아남아있게 된다.

- 사용이 끝난 객체에 대해서는 null처리를 하여라.
- null처리를 통해 GC의 처리 대상으로 올릴 수 있고, 코딩을 하면서도 에러를 찾기 더 쉬워진다.  


**Memory Leak**  

1)

2) cache

3) listener and other callback  
- store only weak references to them
-
