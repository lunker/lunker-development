#

- ForwardRequest
  if) initial request
    - sip request를 위해서 관련 정보들을 SipSession에 저장한다.
    - lb에서 남겨준 header정보와 sip request header 정보들을 이용하여 sipsession에 저장한다.
      - client port, client ip가 via에 receved, rport로 기재되어 있지 않으면, lb에서 남겨준 custom header로 이를 대체한다.
      -
    - changeRedisInfo(fromCaller); // 새로운 메세지가 올때마다 레디스를 엎어친다.. ㅡㅡ ;
    - 
- ForwardResponse

- ForwardAck

- ForwardMessage
