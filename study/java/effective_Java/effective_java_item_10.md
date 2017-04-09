# item 10 : Always override toString()  

- println, printf 등에 object가 넘어가거나 string concatenation or print by debugger일때 자동적으로 toString()이 호출된다.
- toString()은 객체가 가지고 있는 모든 정보들을 반환한다.
- 일반적으로 toString()을 override하지 않고 default를 사용할 경우, 클래스명@123123 와 같은 형식으로 출력되기에 객체에 대해 원하는 정보를 알 수 없다.  
- **String.format()을 이용하여 일관되게 출력해라!** 
