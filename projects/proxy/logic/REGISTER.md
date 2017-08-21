# Register Flow


SCFServlet->SCFBeanContainer->RegistrationHandler


<RegistrationHandler>
  # handleRegistration():

  - if REGISTER :
    - 401 not authorized를 발행한다.

  - REGISTER Request가 registration 인지, unregistration인지 판별한다.
    - unregistration이면,
      - AOR을 읽어와서 registrar cache에서 등록 정보를 삭제한다.
      - 200 ok를 발행한다.

    - registration이면,
      - auth가 없으면,(초기 REGISTER)
        - AOR을 이용하여 registrar에 cache되어 있는 유저 등록 정보를 삭제한다.
        - 407 PROXY AUTHENTICATION REQUIRED 를 발행한다.
        - 등록 종료.
      - Authorization이 들어 있으면,
        - <RegistrarBean> RegistrationEvent.Type.GET_PASSWORD을 수행한다.
        - 인증을 진행한다.
        - registrar에 등록 정보를 저장한다.
        - 200 ok를 발행한다.

    - 만약, 처리 중에 에러가 발생하면, 500 INTERNAL_SERVER_ERROR을 발행한다.

<RegistrarBean>
  # RegistrationEvent.Type.GET_PASSWORD
  - <AuthCheckServiceImpl> #getPassword()를 호출한다.
  - 위 함수에서 반환값이 존재한다면 인증 성공!

<AuthCheckServiceImpl>
  # getPassword()




## Expire
- SipServletRequest Expire : 900s
- SipApplicationSession expire : 15m
