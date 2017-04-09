# 12. tcp

### 12.1.1 ARQ and Retransmission

- multihop packet sending 시에는 packet reordering, packet duplication, packet drops 과 같은 문제가 발생할 수 있다.

**packet drop**  
- 직관적으로 해결하기 위해서는 packet을 제대로 받을때까지 resend한다.
  - 이를 위해서 2가지가 고려되어야 한다.
    - receiver가 packet을 받았는지,
    - receiver가 받은 packet이 sender가 보낸 packet이 맞는지
  - 그러면 receiver는 packet을 보내고 얼마의 시간동안 ack를 기다려야 하는가? ==>
  - 만약 ack가 손실되면 어떻게 하나 ? ==> packet을 재전송한다.
  - receiver가 packet을 받았지만, error가 있는경우 어떻게 하나 ? ==> checksum, crc사용.

- ack를 받지 못해서, 여러가지 상황으로 인하여 sender가 재전송 했을 경우, receiver는 중복된 packet들을 받게 된다. ==> sequence number를 이용하여 packet을 구분한다.
  - 모든 packet들은 독립적인 sequence number를 받게된다.
  - 그래서 receiver는 이미 해당 packet을 받았는지, 안받았는지 sequence number를 통해서 확인할 수 있다.  

### 12.1.2 Windows of Packets and Sliding Windows   
- "window" : sender가 전송은 했지만 아직 ack를 받지못한 packet들.

### 12.1.3 Flow Control and Congestion Control  
-

### 12.2.2 Reliability in TCP  
- application data는 tcp가 생각하는 최적의 chunk size로 전송되어 진다.
- 일반적으로는 fragmentation이 일어나지 않도록 ip datagram 의 사이즈에 맞게 자른다.
- tcp는 packet을 보내고, receiver는 checksum을 체크하여 packet의 에러 여부를 확인한다.
- 에러가 존재하면, 해당 packet의 이전 packet에 대한 ack를 전송한다. -
