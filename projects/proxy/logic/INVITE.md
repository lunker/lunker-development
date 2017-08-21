# Call Flow for ims (scf & proxy_registrar)

[Send INVITE]
- <Conversation>
  # __initial(InviteInput i) ::

  - sendRinging()을 수행하여 invite를 forwarding하기전에 caller에게 180 ringing을 준다.
  - invite를 처리하기전에 기본적인 연산들을 수행한다.
  - CommunicationSessionUtil에 콜 관련 정보들을 저장한다.
    - caller
    - callee
    - caller uuid
    - local address
    - call type (outbound, inbound, ...)
    - domain name
  - SipApplicationSessionUtil에 콜 관련 정보들을 저장한다.
    - callid,

  - invoke <CallBean> CommunicationEvent.Type.INITIALIZATION
  - invite에 대한 response를 만든다.
    - 403 forbidden
    - 404 not found
    -> call_ended state로 변경 후 콜 종료.
  - invite에 대한 response를 만든다.
    - 600 busy everywhere 발행
    - invoke CommunicationEvent.Type.BUSY
    - invoke CommunicationEvent.Type.PUSH_BUSY
    -> call_ended state로 변경 후 콜 종료.

  - invoke <CallBean> CommunicationEvent.Type.STARTED
    - rest로부터 등록되어 있는 유저의 device를 가져온다. (aor::useragent::uuid)
      - user device정보에서 'tel_no'가 없으면, 404 not found Response를 발행하고 CALL_ENDED state로 변경한다.
    - Redis로부터 registration 정보를 읽어와서 rest를 통해 가져온 device 정보와 비교한다.
    - 그래서, 해당 장비의 registration 정보가 없으면, push를 날려서 장비를 깨운다.
      - Invoke Type.PUSH_INVITE_ON_START :: registration정보가 날라간 device에 대해서, invite를 날리기 위하여 push(invite)를 전송한다.
      - state->CALL_STARTED로 변경한다.

- <CallBean>
  # CommunicationEvent.Type.INITIALIZATION // 통화를 시작하기전에 필요한 상대방의 현재 상태를 가져온다.
    - 사용자 차단 여부 확인
    - 통화중 여부 확인
    - <rest> call-histroy 추가



- <ParticipantAgent>
  # ForwardRequest ::
    - if) initial request
      - sip request를 위해서 관련 정보들을 SipSession에 저장한다.
      - lb에서 남겨준 header정보와 sip request header 정보들을 이용하여 sipsession에 저장한다.
        - client port, client ip가 via에 receved, rport로 기재되어 있지 않으면, lb에서 남겨준 custom header로 이를 대체한다.
        -
      - changeRedisInfo(fromCaller); // 새로운 메세지가 올때마다 레디스를 엎어친다.. ㅡㅡ ;

=============================================================================== 여기까지가 Invite & 180 Rining 처리 로직.

[Receive 180 RINGING]

- <ParticipantAgent>
  # ForwardResponse ::

  if) inbound Call || typhone call
    if) 180 RINGING
      - 타이머를 실행시킨다.
    if) 200ok.
      - 타이머를 종료한다.
  if) outbound call
    - info에 대한 200ok는 먹어버린다.

  if) kms rtp disconnected 이후에 들어오는 response에 대해서는 먹어버린다.


## 정리
- user validation을 진행한다.
- 해당 콜을 처리하기 위한 정보들을 Invite로부터 가져와서 communicationsession, SipApplicationSession에 저장한다.
- 그리고 Invite를 전달하기 위하여 callee의 device들 정보를 가져온다.
- 그리고 redis에 없는 기기들은 push를 사용하여 invite를 날리도록 한다.

즉, Invite를 처리하기 위한 전처리 과정을 수행한다.
