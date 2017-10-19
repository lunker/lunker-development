# 테스트 케이스



## Caller Hold
- keepalive 이전에 바로 hold -> call off hold -> 통화 수행 :: 성공
- keepalive 이전에 바로 hold -> keepalive -> call off hold -> 통화 수행
- keepalive 이후에 hold-> call off hold -> 통화 수행 :: 성공
- keepalive 이후에 hold-> keepalive-> call off hold -> 통화 수행


## Callee Hold
- keepalive 이전에 바로 hold -> call off hold -> 통화 수행 :: 성공
- keepalive 이전에 바로 hold -> keepalive -> call off hold -> 통화 수행

- keepalive 이후에 hold-> call off hold -> 통화 수행 :: 성공
- keepalive 이후에 hold-> keepalive-> call off hold -> 통화 수행


## 추가적인 Hold 케이스

- 위의 조합들 섞어서 . . .
