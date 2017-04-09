# BYE(rfc 3261, section 15)
---
### Overview  
- BYE를 받게되면, dialog와 연관되어 있는 모든 session들은 종료된다.

### behavior

#### uac behavior
- within a dialog request이다. (section 12참고)


#### uas behavior(15.1.2)
- section 8.2에서의 general UAS processing을 한다.
- bye request를 받으면, 존재하는 dialog에 대한것인지 확인한다.  
- 존재하는 dialog와 매칭되지 않으면, 481 response 를 발행한다.  
- 존재하는 dialog에 대한 bye request일 경우, section 12.2.2를 따른다.
- pending request에 대해서는 487 response를 발행한다.


**참고**
- rfc 3261, 15.
