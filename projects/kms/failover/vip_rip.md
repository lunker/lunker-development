libnice
rip, vip 셋팅

- kms_ice_nice_agent_add_stream 으로 niceagent에 nicestream을 추가하고
- nice_agent_set_port_range을 수행하여 candidate에 들어갈 port range를 설정한다.

basertpendpoint 에서 max_port, min_port를 property로 가진다.
-> 이거를 사용해서 나중에 connection을 만들때 port range를 설정한다.

@ nice_agent_set_port_range
-> agent에 있는 해당 stream에 여러개의 component가 존재한다.
-> component의 'min_port', 'max_port'를 셋팅한다.

@ nice_agent_gather_candidates

nice_interfaces_get_local_ips()을 통해 현재 kms의 network interface를 검사하여 local ip를 가져온다.
=> 여기에서 가져온 ip를 candidate의 ip로 사용한다.

nice_address_set_port() 등을 사용하여
start=min_port로 한 후, candidate을 생성한다.

discovery_add_local_host_candidate :: candidate 생성 부분

1) config.status 에 vip 때려넣는다.
-> vip가 바뀔 때 마다 컴파일 다시해서 재기동해야함.

2)

=======================================================================================================
# libnice
- property 'session-clustering-mode', 'vip', 'rip' 셋팅
- mode에 따라 candidate 생성 방안 분기
- vip를 이용하여 socket 생성, rip를 이용하여 candidate 생성



# kms-elements
- webrtcsession에서
g_object_set ()을 통해 property 'session-clustering-mode', 'vip','rip' property set

- get vip, rip from config file

=================================================================================================





# rtpendpoint vip, rip 개발

- <kmsrtpendpoint.c>에서 nice_interfaces_get_local_ips을 통해서 sdp에 들어가는 host ip를 정한다.
- <kms-core> <kmssdpagent>에서 create_offer, create_answer 등에서 kms_sdp_agent_origin_init 여기에서 rtpendpoint의 sdp에 들어가는 address를 정한다. (origin과 connection 등)
=> kmssdpagent의 agent->priv->addr을 private ip, real ip로 설정해야한다.

- kms의 conf를 이용하여 value를 셋팅하려면, BaseRtpendpointImpl -> kmsbasertpendpoint로 property를 넘겨야한다.


-
[kms-core]
-
  <kmsbasesdpendpoint> kms_sdp_session_set_addr ->
  <kmssdpsession> set kmssdpagent's property 'addr'

->
kmssdpagent의 addr을 이용해서 sdp를 생성....?


# <RtpEndpoint> vip, rip 작업 flow
1) add key-value 'real_ip', 'virtual_ip'
2) read config value in 'BaseRtpendpointImpl'
3) create property in 'kmsbasertpendpoint'
4) add new variable 'real_ip' & 'virtual_ip' in kmsbasertpendpointprivate
5) pass it to


##### 수정
SdpEndpointImpl에다가 작업해야할듯

=======================



[kms-elements] kmsrtpendpoint의 kms_rtp_endpoint_set_addr()에서 local interface를 긁어오고(libnice api 사용), 여기에서 ip를 가져와서 kmsbasesdpendpoint에 셋팅한다.
[kms-core] kmsbasesdpendpoint의 self->priv->addr에 local ip가 들어있다.
->

### Summary
RtpEndpoint는 현재 binding socket address가 any(0.0.0.0)이므로, vip로 socket을 생성해줄 필요가 없다.
sdp 생성에 쓰이는 ip address는 local interface에서 긁어와서 사용한다.
긁어올때 rip로 긁어오도록 하면 vip-rip 구현완료.
