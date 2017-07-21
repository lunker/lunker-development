# DTLS & SRTP


### Overview

**DTLS**
- tls를 udp에 적용한 것.
- VOIP에서는 시그널링 암호화에 사용한다.
-

**SRTP**
-


### TLS
- "TLS Hello" : 암호화 알고리즘 협상
-


- client에서 tls 세션키를 생성한다.
- 해당 세션키를 서버에서 보낸 public key로 암호화 하여 전송한다.
- 서버에서는 private key로 복호화 하여 클라이언트와 서버가 srtp enc/dec를 위한 세션키를 공유하게 된다.
- 생성된 세션키는 aes암호화/복호화, sha-1 인증 두 가지에 모두 쓰인다.
### SRTP
- RTP와 동일한 포맷으로 이루어져 있다. 다만 rtp payload가 암호화 되어있다.
- 추가적으로 인증을 위해 Authentication Tag가 붙는다.  
- 전화기는 RTP 헤더와 페이로드(Payload)를 SHA-1으로 해슁할 때 TLS를 통해 교환된 세션 키를 함께 사용합니다.
- 참고로 srtp mki(master key index)는 쓰이지 않는다. (확실한가?)

1) srtp 패킷 암호화
- aes알고리즘과 세션키를 이용하여 암호화한다.
-


2) srtp 패킷 전송 및 인증을 위한 처리

**SRTP 패킷 인증**
- caller에서 rtp 패킷을 암호화 할때 (sha-1 hashing) 이전 tls에서 교환된 세션 키를 사용하여 암호화한다.
- rtp header + rtp payload를 tls 세션키를 사용하여 hashing.
- hashing한 값을 srtp packet에 넣어서 보낸다.
- callee에서는 srtp패킷의 sha-1 Authentication tag를 동일한 세션키를 사용하여 검증한다.





**참고**  
- http://www.nexpert.net/362
-
