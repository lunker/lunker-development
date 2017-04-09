# ICE-lite
https://tools.ietf.org/html/draft-rescorla-mmusic-ice-lite-00


## Introduction  
- NAT은 Network element가 direct communication을 할 때에 장애물이 된다.  
- NAT Traversing하는 기술들은 많지만, 현재 client 상황에 맞는 기술을 찾는 메커니즘이 필요하다.  
- ICE는 데이터를 보내고 받을 수 있는 가능한 모든 주소를 수집한다.  
- 이 주소들은 local address, address discovered via stun, address provided by media relays 이다.  

## Overview of Operation

- LII(Lite ICE Implementation) 은 ICE와 비슷하게 동작한다. 하지만 3가지에서 다르다.
1) 자신의 interface에서만 이용 가능한 candidate address를 수집한다.
2) controlling endpoint가 될 수 없다.
3) other endpoint로부터의 주기적인 체크에 응답만 할 수 있고, check를 생성할 수는 없다.  


- LII는 FII(Full ICE Implementation)과 호환가능.
- ICE는 bidirectional connectivity를 설립하기 위한 것.


- 양 단말은 SDP Offer, answer를 교환한다.
- 이때 LII는 **a=ice-lite** attribute를 붙여서 ICE-Lite임을 암시한다. 그리고 이것은 상대방에게 2가지를 의미한다.  
 1) 상대방이 controlling endpoint가 된다.
 2)  USE-CANDIDATE flag를 처음에 보내지 않아야 한다.  

- Connectivity Check는 FII에 의해서 주도적으로 진행된다. 그리고 FII는 일반적인 routine을 따른다.  
- FII는 USE-CANDIDATE flag없이 모든 체크를 보내고, 그 중에서 사용 가능할 것에 대해서 2번째 check를 보낼때에 USE-CANDIDATE flag를 보낸다.


## Lite ICE Specification  

#### Gathering Candidates  
- LII도 FII처럼 candidates를 수집한다. 하지만 locally attached interfaces(host candidates)만을 수집한다.(다른 종류의 주소들은 필요없다) => LII가 정의적으로 public IP address를 가지기 때문.

#### Setting Priorities  
- FII에서는 각 candidate에 priority를 부여한다.
- 하지만 LII에서는 1개의 candidate만을 가지기 때문에 priority를 부여할 필요가 없다.  


#### Encoding Candidates in SDP  
- LII가 candidate를 모았으면 이제 SDP offer/answer에 담아야한다.  

#### Receiving SDP offer/answers  
- LII가 peer로부터 sdp offer/answer를 받았을때, 가장 먼저**a=ice-lite** attribute가 있는지 확인해야한다. 있을 경우(양 측 모두 LII인 경우) ICE processing은 종료된다.


#### Processing Periodic Checks  
- ICE discovery동안에,  LII는 binding request를 받는다. (offer/answer에 있는 candidate로 부터)
- LII가 binding request를 받으면,  
1) Generate stun binding response
2)
