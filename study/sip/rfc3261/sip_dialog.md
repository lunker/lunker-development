# Dialog (RFC 3261, section12)

#### About
- request, response are used to construct a dialog - how subsequent requests and responses are sent within a dialog.

#### Dialog ID
- Call-ID, local tag, remote tag로 구성된다.
- Dialog에 연관된 UA들은 서로 다른 dialog id를 가진다.
- UAC, UAS에 따라 Dialog ID를 계산하는 방법이 다르다.
if) UAC :
if) UAS :  
---

## 12.1 Creation of Dialog
- Dialog는 Request에 대해서 non-failure response를 생성함으로써 만들어진다.
- non-final response에 의해 만들어지는 dialog는

#### 12.1.1 UAS behavior
- request에 대해서 Dialog를 만들 수 있는 Response를 발행할 경우, UAS는 Request에 있는 Record-Route header field를 그대로 복사하여 Response에 담아야 한다.
- Contact header field를 넣어야 한다.  
  Subsequent request를 받을 UAS의 주소를 담는다.  
  이 Contact 주소는 outside dialog에서도 그대로 쓰인다.  
- 이제 UAS는 dialog의 state를 설정한다. 이 state는 dialog가 있을동안 유지되어야한다.
- route-set header field는 반드시 Record-Route header field에 있는 list로 채워야 한다.

#### 12.1.2 UAC Behavior
-


## 12.2 Requests within a Dialog  
- Dialog가 만들어진 이후, dialog내에서 새로운 transaction이 필요할 경우가 있다.

### 12.2.1 UAC Behavior

#### 12.2.1.1 Generating the Request  
- 
