# Nexus Repository  
### Download nexus Repository oss 3.x
wget
tar
bin/nexus run
bin/nexus start  

### make nexus as serrvice
https://books.sonatype.com/nexus-book/reference3/install.html#service-linux

### Nexus Repository setting
- create repository as hosted

- add deploy plugin to maven pom.xml
  - add <distributionManagement>
  - add Server Info to ~/.m2/settings.xml
  ex)
  <distributionManagement>
    <repository>
      <uniqueVersion>false</uniqueVersion>
      <id>lunker-dev-snapshot</id>
      <url>http://10.0.1.159:8081/repository/lunker-snapshot/</url>
      <name>voiceloco:lunker-snapshot</name>
      <layout>default</layout>
    </repository>
  </distributionManagement>


- run maven deploy command in maven project
  mvn clean deploy -Dmaven.test.skip=true


- using nexus repository with gradle
  - add
    apply plugin: 'maven'
  - add
    maven {
      url "http://10.0.1.159:8081/repository/lunker-release/"
    }
