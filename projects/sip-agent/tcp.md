# sip-agent

1. agent에서 tcp로 전송시에, 특정 상황또는 특정 케이스에 대해서 connection을 끊어버린다.
->> 이로인해 유실되는 메세지가 있다.
->> agent는 보냈지만, kamailio에서는 connection을 끊어버려서 시마이... or  
 agent의 tcp단에서 끊음...?
->>

# kamailio

1. sip msg이외의 패킷을 받았을때에도 동일한 로직이 도는데,
이때 parsing error가 난다.
fin 받을때에도 logic을 타는 듯 . . .

### handle_io()

- 초기 connection에 대해서 tcp_read_req()를 수행하고, resp를 받는다.
  - 그리고 해당 connection을 connection_list에 등록하고, State-> f_tcpconn으로 변경하여 두번째 메세지 read부터는 다른(축소된) 로직을 타게끔 한다.
-
Trustno18004!



<handle_io() Flow>

tcp_read_req(){

  tcp_read_headers(){

    tcp_read() {

      tcp_read_data();

    }

  }

  receive_tcp_msg()

}


## Issue

- handle_io() <- tcp_read_req () <- receive_tcp_msg():: ret<0이 발생.
- 그 에러에 따라서 release_tcpconn()을 수행.   



## TODO
- packet parsing error, tcp conneciton error를 분간해야 한다.
- tcp byte stream을 분기해야 함 . . .

or

hep.c에다가
parsing에러나면 버퍼를 구현해서 거기다가 내용을 저장.


====================

170425


## 현상
-

msg_parser::parse_msg()
=>

sipcapture::sip_capture_preparse() => msg_parser.c::parse_headers()
   - call msg_parser::get_hdr_field() :
    - hf empty 발생.

##

sipcapture.c에서 sip_capture() => sip_capture_parpare() =>

여기에서 buf로 부터 sip_msg를 읽어온다.  

sip_capture_prepare 하기전에 이미 짤려서 온다.


##

hep.c :: parsing_hepv3_message()에서는 전부 가져온다.
-> receive.c()에 넘겨온 buff에는 sdp가 짤려서 온다.
