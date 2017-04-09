# homer 5 setting

1) apache2
#### apache start시에 port binding error (443)
- ssl.conf에서 port comment 처리

#### apache 403 forbidden
- apache root 및 접근 경로들 permission 부여

2) mysql & php
#### codev의 설정 중 빠진 부분
- yum install php5-mysql
- yum install mysql-client mysql-devel

3) kamilio ::: 모니터링 서버에 설치
- src/makefile에서 install_bin의 install_touch를 주석처리 + manually touch ~!
- start : sudo /usr/local/sbin/kamailio start

4) homer api & ui
- homer api : github에서 내려받은 소스 중 ${GIT}/homer-api/api/.htaccessa 빼먹지 말고 꼭 apache의 root로 넣기 ㅠㅠ
- 나머지는 하면됨.

5) capagent ::: proxy, lb가 돌고 있는 서버에 설치
- github 참조  

//- init.d script에서 => sudo chkconfig captagent on

** Ubuntu기준으로 작성된 init.d . . . ㅠㅠㅠ**  

- https://gist.github.com/yuuichi-fujioka/c4388cc672a3c8188423  

---

### CapAgent 구성  

tls,

capagent는 암호화된 패킷을 통으로 보낸다.

이를 kamail가 풀어서 저장해야함.


/etc하단에 있는 kamailio의 설정 중(tls.cfg)에다가 인증서 관련 설정을 해야함
tls.cfg에다가 인증서 설정 .
