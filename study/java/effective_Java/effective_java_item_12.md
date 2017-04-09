# item 12 : Consider Implementing Comparable  

- Comparable interface : order comparison을 가능하게 해준다.
- Comparable interface를 구현한 Class에 대해서 Ordering을 하게되면,
Arrays.sort(array of objects)로 하면 된다.
- Comparable interface를 구현함으로써 많은 generic algorithm을 사용할 수 있게 된다.  
- Value Class에서 명백한 natural ordering을 가진다면, Comparable interface를 구현하는 것을 고민해라.  
- compareTo()는 두 객체를 비교하여 음수, 0, 양수를 반환한다.

#### Comparable Interface 구현 방침 .
- x.compareTo(y) == sgn(y.compareTo(x))
- x.compareTo(y) >0 && y.compareTo(z) >0  ====> x.compareTo(z) >0
-
