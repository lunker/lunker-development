# TODO
- kms log 정리
- media server 이용자 현황 방안
	- turn rest api test
	- kms 사용자 현황 조사 방안 수립
———
LIST
- log, call history 정리
- media server session check api 생성 => 수치 테스트 필요
- failover
	- rip, vip 셋팅 & 통신 가능 여부 테스트 => ok
	- keepalived parallel 설정 가능 여부 (for n+1 architecture)
- conferencing 조사
- kurento benchmark, e2e test project build
- kmswebrtcsession과는 달리, kmsiceniceagent는 gst-element-name이 없다. 이거 확인!
- kurento media element conf.ini, kurento.conf.json 등 관련 설정 파일들이 install 및 load 경로가 다른거 파악!
- kurento media server redis module 제작
- kurento media server redid connection info configurable
- rtpendpoint vip, rip 되는거 확인
- kurento client reconnect trying logic disable
- failover 시에 segmentation fault 발생. . . . ㅡ ㅡ
- kms_webrtc_transport_src_nice_configure에 session clustering mode check logic 추가


<Logger>
- destroy 로직 구상
- 성능테스트
- messagequeue 구현
