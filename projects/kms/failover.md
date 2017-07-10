# Failover  


### overview

### 목표

1) 재기동시, 기존 media stream 복구
2) shutdown 시, 다른 kms에서 media stream 처리


### Test  
- udp client에서 죽어있는 udp server로 sending 하여도 에러가 발생하지 않는다.
  -> rtp 통신 시, kms가 죽어도 client가 바로 죽지는 않는다.
  -> client에서는 media packet이 없기 때문에 timeout 후 통화 종료처리된다.

-


### Prototype

1) redis 설치

sudo yum install -y redis-server
redis-server --daemonize yes  

1-1) install hiredis
wget https://github.com/redis/hiredis/archive/v0.13.3.tar.gz
tar -xvf
sudo make install



2) kurento client java invoker 구현

3) kms 'mediastatechanged::disconneceted' 일 때 media 정보 저장.
