# Call hold

# IP-Phone에서 지원하는 hold 방안들
- nortel
  - sdp c= IN IP4 0.0.0.0
  - a=sendonly

- rfc 2327
  - sdp의 c=IN IP4 0.0.0.0


- rfc 3264
  - sdp에 a=sendonly


- rfc 3264 - inactive
  - sdp의 a=inactive



- nortel
  0.0.0.0
  a=sendonly

# IP-Phone
- keepalive는 uas (callee)에서 invite로 발행한다.
- iphone에서 200ok에 들어있는 sess-version은 개판이다.
- 이후에 rtp가 흐르고, keepalive용 invite에 들어있는 sess-version은 딱 sess-id +1 로 설정되어서 보내어 진다.

********************* keepalive invite에는 call-hold를 수행한 이후든, 전이든
uas는 sess-id+1을 sess-version으로 사용해서 keepalive invite를 전송한다.!
uac는 updateCounts를 반영하여 판별해야한다.

# Call hold logic
- call hold invite
  - 초기 invite에서 sess-version이 1 증가 되어서 발행된다.
  - a=sendonly가 추가적으로 붙는다.
  - c=에 0.0.0.0이 들어간다.

- call hold invite를 받으면,


## memo
! ip-phone 기준 작성

** keepalive **  
- callee와 caller 모두 keepalive를 보낸다.
- 하지만 callee(UAS)가 더 자주 보낸다.
- callee는 200 ok에서 발행했던 sess-id+1을 sess-version으로 사용하여 keepalive INVITE를 발행한다.
- caller는 세션을 만든 가장 최근 invite의 sess-version을 그대로 사용한다.

** caller hold**
- caller는 첫 통화를 위해 발행한 invite의 유효한 sess-id, sess-version를 가지고 있다.
- ipphone은 caller
- 그래서 caller가 hold INVITE를 발행할 경우, 다음과 같이 변경된 hold INVITE를 발행한다.
  - 가장 최근에 수행한 INVITE의 sess-version+1으로 sess-version 사용
  - a=sendonly 추가
  - c=0.0.0.0 으로 변경

** callee hold**  
- callee는 invite를 발행한 적이 없다.
- 그래서 hold INVITE를 발행시에, 다음과 같이 hold INVITE를 발행한다.
  - 200 ok에서 사용한 sess-id+1을 sess-version으로 사용
  - a=sendonly 추가
  - c=0.0.0.0 으로 변경

!!! 이슈
만약에 callee 가 hold를 발행하고 통화를 하다가 발행되는 keepalive의 sess-version은 ?
