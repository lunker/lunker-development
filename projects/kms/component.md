# KMS

## Overview
- KMS는 전적으로 KurentoClient의 action에 따라 움직이게 된다.
- Kurento Media Server는 kurento-client가 보내는 명령을 kms가 받고, 이를 kms-element의 method들을 호출하여 수행한다.  
- kms-element는 kms-core를 통해서 Media Stream handling을 하는 gstreamer, gst-plugins 들을 사용한다.

## Flow  

[General]
- kurento client에서 action을 취한다.
  - kms의 websocketransport, servermethod를 통해서 해당 action을 처리한다.
    - create, invoke, 등이 있다.
    - 이에 맞는 gst-plugin(good, kms-core, kms-element) 등을 호출하여 처리한다.  

switch(action)

  case (create endpoint) ::  
    - kurento client의 operation을 통해서 생성을 요청한 endpoint를 찾는다.
    - 해당 endpoint의 gst-plugin을 호출하여 register를 등록한다.  
    - gst_factory_create를 통해서 해당 gstelement(kmsXXXEndpoint)를 생성한다.

  case (create, invoke . . . ) ::
    - serverMethod::invoke()
    - MediaObjectImpl.invoke(operation)  
    - 해당 operation이 존재하는 object.method()를 호출한다.  
    - 해당 operation은 gst-element의 class_init()에 있는 klass->xxxx 로 정의한 method명과 같다.  

  case GarbaseCollection ::
    - 2단계로 수행된다.
    - 현재 kms에서 돌고있는 session들에 대해서 'use' 상태이면 'not use' 상태로 변경시킨다.  
    - 만약 'not use'이면 해당 session에 대해서 reference들을 지운다.  

    ** unref
     - 이후에 delete을 통해 객체를 삭제하게 된다. 만약 삭제된 이후에 해당 메모리 영역을 참조하게 되어 프로그램이 죽는 일을 방지하고자, 해당 객체들의 참조를 삭제시킨다.

  case keepAliveSession ::
    - 현재 session이 살아있음을 알린다.
    - sessionInUse 의 값을 use로 setting하여, GarbaseCollection의 unref 대상에서 제거되도록 한다.  
