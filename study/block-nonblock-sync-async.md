# sync-async & block-nonblock

# block/non-block
  - 함수 호출 후, callee function의 결과를 기다리나 안기다리나
  - 호출 되는 함수가 바로 리턴하느냐 마느냐의 관심사
  - non-blocking : 호출된 함수가 바로 리턴해서 호출한 함수에게 제어권을 넘겨주고, 호출한 함수가 다른 일을 할 수 있는 기회를 줄 수 있으면 non-blocking
  - blocking : 그렇지 않고 호출된 함수가 자신의 작업을 모두 마칠 때까지 호출한 함수에게 제어권을 넘겨주지 않고 대기하게 만든다면 Blocking이다.


# sync/async
  - 함수 호출 후 해당 함수의 종료 여부를 신경쓸것인가?
  -> 신경쓴다면 물어보거나 기다리거나
  -> 신경을 누가 쓸 것인가? caller? callee?
  -> callee가 신경쓴다면, caller가 넘겨준 callback을 수행시킨다.
  -> caller가 신경쓴다면, polling 등의 방식으로 완료 여부를 체크한다.


- http://homoefficio.github.io/2017/02/19/Blocking-NonBlocking-Synchronous-Asynchronous/
