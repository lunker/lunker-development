
# Supervisord

- supervisord가 parent process로 돌면서 각 program들을 subprocess로 구동시킨다.
- web ui가 제공되나 3rd party library라 부족한 부분이 많음.  
- pidfiles는 믿기 어렵다. 그러나 supervisor는 각 프로그램들을 subprocess로 구동시키기에 프로그램들의 상태를 정확히 알 수 있다.  
-> 그래서 해당 프로세스가 죽으면 os에서 바로 signal이 가서 알 수 있다.
-> 다른 솔루션들은 pid file에 의존하거나 주기적인 polling을 통해서 restart 시킨다.
- process들을 그룹화 하여 한번에 실행 가능 :: 동시인지, 순차적인지는 모르겠음  

- Event 기능이 추가되면서 monitoiring & notification framework를 개발할 수 있다.  
- 각 프로세스들은 subprocess로 구동되면서 foreground에서 구동된다.

- supervisord는 자신이 생성한 child process들만 관리할 수 있다. child process가 만든 process들은 supervisord가 죽일 수 없다. 그래서 이러한 경우에는 pidproxy program을 이용하여 관리해야함...
=> 근데 이 pidproxy는 결국 pid file을 이용해서 관리함.  

---  
# Monit
- 웹에서 관리 가능.
- 알림을 메일로 받을 수 있다.
- 각 process별 자원 사용 현황을 알 수 있음.
- background에서 daemon으로 실행된다.
- sleep하고 있다가 설정된 period마다 프로세스들을 체크한다

**체크되는 자원 항목**  
- 구동시간
- cpu 점유율
- memory 사용량  
-

**기능**  
- 주어진 pid file을 통해 process id를 사용하여 running 여부를 체크한다.  
- 해당 process가 죽어 있으면 alert
- 해당 process가 죽어 있으면 restart script를 추가해서 할 수 있다.  
- Checked Resource Usage
- process들의 자원 사용량을 볼 수 있음(cpu, memory, total cpu, total memory )
- 특정 자원 사용량이 bound를 넘기면 action을 취할 수 있다.
- 관련 process들을 group화 하여 한번에 관리할 수 있다.
  process = service
  group = process들의 집합.  
- alert시에는 특정 bound를 n회 넘으면 메일을 보내도록 설정할 수 있다.
- 모니터링의 대상은 process, file, directory, disk 등 다양하다.  
ex) file의 경우 로그 파일의 용량이 xxx를 넘으면 log rotate등의 액션을 취할 수 있다  
ex) disk의 용량 혹은 사용량이 얼마 이상이면 alert를 할 수 있다.  

ex) 스크립트나 프로그램을 특정 시간, 상황에서 실행시킬 수 있다. 그리고 그 결과에 따라 alert 가능  

이러한 모니터링은 웹에서 다 확인이 가능

---  
### pid files  
-


**참고
http://stackoverflow.com/questions/12156434/what-is-the-advantage-of-using-supervisord-over-monit
