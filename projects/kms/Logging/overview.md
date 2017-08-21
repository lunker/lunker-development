# Overview

1) callid prop 을 모든 gst object에 만든후, logging function에서 일괄 적용.

- <kurento-media-server> 의 logging.cpp에서 'debug_objet()'라는 함수가 존재한다.
- 여기에서 gst library를 이용하여 해당 gobject로부터 값을 가져올 수 있다.
- 이때에, g_object_get을 통하여 property의 값을 가져올 수 있는지 테스트 해봐야함.
- 가능하다면, debug_object에서 만들어내는 fmt에 'call-id'를 추가하여, 유의미한 media call logging을 만들어 낼 수 있다.

2) boost multi file backend logging을 이용하여 media flow를 위한 별도 로직 추가 ?



# References
- boost multi file backend logging
https://stackoverflow.com/questions/34362871/use-channel-hiearchy-of-boost-log-for-severity-and-sink-filtering/34372526#34372526
----------------
# History

####  Setup
- Install for cross compiling
- sudo apt install -y g++-multilib

#### CMake
- c/c++ mixing일 경우 ,
  add_library, add_executable()에 *.h 은 빠져야한다!
- add_dependencies:
  최상위 target이 해당 lib을 참조하도록 한다.


- find_path:
  해당 파일이 존재하는 경로를 찾는다.
- find_library:
  주어진 경로에 lib<name>.so 등 binary가 존재하는지를 찾는다.
