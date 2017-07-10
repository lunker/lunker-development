# Overview

- <kurento-media-server> 의 logging.cpp에서 'debug_objet()'라는 함수가 존재한다.
- 여기에서 gst library를 이용하여 해당 gobject로부터 값을 가져올 수 있다.
- 이때에, g_object_get을 통하여 property의 값을 가져올 수 있는지 테스트 해봐야함.
- 가능하다면, debug_object에서 만들어내는 fmt에 'call-id'를 추가하여, 유의미한 media call logging을 만들어 낼 수 있다.




# References
- boost multi file backend logging
https://stackoverflow.com/questions/34362871/use-channel-hiearchy-of-boost-log-for-severity-and-sink-filtering/34372526#34372526
