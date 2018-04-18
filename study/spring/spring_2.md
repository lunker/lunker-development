


* StereoType annotation 
- provides hints for people reading the code and for Spring that the class plays a specific role
- Spring에서 해당 class 등을 인식 할 수있도록 해준다. 

- @RestController, @RequestMapping, Spring Web MVC 관련해서 내용이 많다고 헀다. 무엇인지 찾아보자!
(위 2개의 annotation은 Spring Boot가 아닌, Spring annotation에서 온것이다. Spring framework 공부가 필요한 부분) 



@EnableAutoConfiguration
- Spring boot가 제공해주는 기본적인 설정에 따라 설정 하라는 annotation
- 이 설정은 사용자가 추가한 dependency들에 의해서 결정되어진다. 

- 예를들면, 'spring-starter-web' 의존성을 추가함에 따라 여러 dependency들이 추가된다.
그러면 그에 따라 추가되는 'tomcat, websocke' 등등의 dependency들 때문에 '@EnableAutoConfiguration'이 이 의존성들을 보고서 그에 맞는 설정들을 추가한다 


# Index 
@@ javax.validation 




