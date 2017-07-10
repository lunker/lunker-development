# About dynamic payload type mapping error rtpsession::source_clock_rate()
-> RtpSession의 callback에 설정되어 있는 clock_rate를 가져온다.

즉, RtpSession에서 초기 생성 시에 설정한 callback을 찾아야

rtp_source_set_callbacks

session의 callback을 봐야함.

rtp_session_set_callbacks

============================================
kms_base_rtp_endpoint_request_pt_map ()


10710

1차 추청.

gst_pad_query_caps_default() 을 수행할때,
caps에 filter가 있어야 [96,???] [111]이 뜬다.
즉, filter가 있어야 dynamic과 다른것을 매핑해주는거 같다.
