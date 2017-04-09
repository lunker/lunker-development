# Logstash
---  

## Conf
- input : logstash가 로그를 수집할 대상에 대한 정보를 설정한다.   
- filter : 수집한 로그에 대한 parsing   
- output : 수집된 로그를 적재할 대상
- codec : plain, json 등 데이터 형식 지정  

## 설치
1. ruby 설치
2. jruby 설치
3. logstash 다운로드 및 압축해제  

1) Collector
- logstash 설치
  - logstash conf 생성  
  - input, filter, output 설정

- log file -> redis
- 환경변수를 통해서 읽어들일 로그 파일 경로 설정.
- supervisor or crontab 통해 run.sh 실행  

2) Indexer
- redis -> ElasticSearch

3) ElasticSearch & Kibana  
-

## 참고  
- ELK  http://devmoons.tistory.com/entry/ELKElasticsearchLogstashKibana%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%A1%9C%EA%B7%B8%EC%88%98%EC%A7%91
-
(http://adahnlim.github.io/2016/05/24/ELK-Logstash/)
- elk with beats  
http://jjeong.tistory.com/1059

- logstash logging filter  
http://behonestar.tistory.com/90

- logstash defined regular expression(grok patterns)
 https://github.com/logstash-plugins/logstash-patterns-core/blob/master/patterns/grok-patterns
