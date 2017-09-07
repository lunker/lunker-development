# Kurento Media Server Test   


#### Overview
- 기본적으로 Kurento Media Server에는 각 plugin들 마다 unit test 코드들이 작성되어 있다.
- e2e 테스트를 위해서는 별도의 kurento java project가 있지만, 여기에서는 해당 프로젝트와는 별개로 boost test를 이용한 테스트를 돌리기 위한 문서이다.
- 기본적으로 kms 서버를 기동시킨 후, kurento client 대신 jsoncpp client를 직접 사용하여 kms를 기동시켜서 Media Element들을 생성 후 테스트가 진행된다.

#### Set Env
- MEDIA_SERVER_CONF_FILE  // configuration dir =>/etc/kurento/kurento.conf.json 의 위치
- SERVER_DIR  // binary dir

#### Run!
cd ${KURENTO_REPO}/build/
make help
sudo make ${TEST_NAME}
