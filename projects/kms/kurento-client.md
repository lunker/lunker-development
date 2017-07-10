# kurento client build  

## Step

### generate kms-plugin api froms source
1) generate kms-api.jar
- CodeGenerator.cmake에서 generate boolean setting
- build/java가 생성되고, 거기에 있는 pom.xml을 이용하여 jar generate

2) install kms-api.jar
mvn install:install-file -Dfile=/work/kurento/kms-core/build/java/target/kms-api-core-6.6.2-SNAPSHOT.jar

-> 이거 대신
mvn install 하면됨... ㅡㅡ


2-1) change kms-api' pom.xml
- dependency걸려있는 kms의 version을 바꾼다.
  - range로 걸려있는 것을 6.6.2-SNAPSHOT으로 변경. (내가 작업한 api library를 가져오기 위함)

3) mvn packaging

- mvn package
- 생성된 kms-api.jar를 설치한다.

184263

### generate kurento-client
- mvn -Dmaven.test.skip=true clean package
-
mvn clean package org.kurento:kurento-maven-plugin:2.0.2:generate-kurento-client -Dmaven.test.skip=true
