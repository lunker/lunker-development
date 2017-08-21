# call transfer

- 돌려주기
- A-B와 통화하다가 A가 c를 알려주면, b-c와 통화한다.

## transfer-unattended
- transfer가 실패하면, 다시 초기 caller와 다시 session을 수립한다.
- transfer가 성공해도, 초기 session은 사라지지 않는다. 초기 session은 refer 관련 세션이 끝나야 같이 사라진다.
- refer에 refer-to header로 돌려줄 callee를 지정한다.


## transfer-unattended
- 
