
# 애매한거
SipServletRequest.isInitial => re-INVITE인지 여부를 확인하는 것인가....?

---

# Component

## WebEnvInit
- context의 parameter를 가져옴. . .
- Web.xml의 값들을 읽어와서 sip application에 필요한 기본 환경값들을 셋팅 + jedis 초기화 수행.

## WebEnv
- WebEnvInit에서 설정된 값들을 가져옴
-

## Auth

-

## SipFactory
- ?
- sip message 관련해서 만드는 factory pattern인듯
-

## Redis 구조

1) device list : set
- KEY : "DEVICE_LIST:sip:<aor>"
- VALUE : 해당 aor에 속해있는 device들의 contact

2) registar info : hash
- KEY : "REGISTRAR:<contact명>"
- value : 등록정보들, name:value  . . .

3)



## MainServlet

1) doRegister

 - auth validation 체크
  - invalid -> 401 response (unauthorized response)
  - valid -> registration 진행

  @ Registration 진행
   1) User Validation 진행
   2) isFetch 체크 -> 아직 뭔지 모르겠다
   3) is not fetch 일 때 -> RegistrationInfo 객체를 만들어서 redis에 등록.

   4)
   5) 각 client 별 session의 만료시간을 지정하여, 특정 시간동안 사용자의 반응이 없을 경우 다시 register를 수행하여 client의 상태를 지속적으로 update한다. => redis에도 expire를 걸어서 보완함.

---

# Refactoring
- RegistrationInfohandler , 213 line, while loop 내dㅔ서 contactStr을 계속 가져오고, URI Contact를 쓸데없이 계속 만듬.

- - RegistrationInfohandler.java,   addRegistrationInfo()
 -> jedis.hset 을 한번으로
- RegistrationInfohandler.java, removeRegistrationInfo()
 -> jedis.hdel . . . => jedis.del로 변경

-
