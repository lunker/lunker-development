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
-