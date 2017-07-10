# tcp_time_wait  

## time wait ?
- active close를 수행하는 측에서 발생되는 현상
- close()를 수행하고 바로 소켓을 없애버리지 않고, 네트워크 상에서 아직 도달못한 패킷이 있을 수도 있기에
이를 버리지 않고 받기 위하여 2MSL동안 대기 후 소켓을 지움.
- 그래서 time_wait 상태에 머무르는 동안에는 해당 connection을 재사용할 수 없다
##
- active closer()가 close()를 수행하고 FIN ACK를 전송하고 나면 time_wait 상태로 빠진다.


## 해결책
- **so_reuseaddr**  
  - connection 식별 pair의 port를 time_wait 상태에 있더라도 그냥 사용할 수 있도록 한다.
  -

##
- 주로 client가 active close를 하기에 client에서 time_wait상태가 발생한다.  





- 서버측에서는 가용포트가 줄어드는 문제가 아니라, 오픈된 파일 개수 제한에 걸려서 발생하는 문제가 대다수이다.
  -



**참고**
- http://sunyzero.tistory.com/198
