# 13. tcp connection management  

## 13.1 Intro  
- tcp는 unicast connection-oriented protocol이다.  

## 13.2 tcp connection establishment and termination  
- TCP Connection은 2개의 ip와 2개의 port로 식별된다.
- TCP Connection은 setup, data transfer, teardown으로 이루어진다.  
  -

- TCP는 bidirectional이기 때문에, half-close가 가능하다.
- TCP에서 close() (sending FIN)의 의미는, 더 이상 보낼 데이터가 없다는것을 의미한다.
  - passive closer의 tcp에서 FIN을 받으면, application에 data flow를 종료했다는 것을 알린다.  
  - close()는 both direction을 끊어버린다.  

### 13.2.1 TCP half-close  
- tcp에서 half-close를 하기 위해서는, close()를 수행할 때, "나는 더이상 보낼 데이터가 없지만, 나한테 오는 데이터는 받을거야"라고 할 수 있는 API가 있어야 한다.

### 13.2.2 Simultaneous Open and Close  


### 13.2.3 Initial Sequence Number (ISN)
- client가 syn을 보내기 전에, isn의 값을 결정한다.
- isn 값은 시간에 따라 달라지기 때문에, connection 마다 다른 값을 가지게 된다.
- tcp의 connection은 4개의 값으로 결정된다. 그래서 만약, isn이 connection마다 달라지지 않게 되면, 초기에 끊어졌던 4개의 값에(tuples) 대해서 나중에 다시 연결하고, 해당 connection으로 delayed segment가 들어가게 되면 이를 정상적인 packet으로 인식하는 문제가 발생할 수 있기 때문에, connection마다 다른 isn 값을 가져야 한다.  

### 13.2.5 Timeout of Connection establishment


## 13.3 TCP Options  

### 13.3.1 MSS  
- peer로 부터 받고자하는 segment의 최대 크기이다.
- connection이 맺어지고 나면 each end는 자신의 mss를 알린다.
- mss announce가 없으면 default 536 byte를 사용한다.

## 13.4 Path MTU discovery with tcp  
- 
