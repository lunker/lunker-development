# Nginx  
-



## udp load balancing  
- nginx는 관리자에 의해 정의된 1개 이상의 address에 대해서 listen한다.
-


## Configuration Example
-
stream{
  server {
    litesn 8888;
    proxy_pass stream_backend;
  }

  upstream stream_backend{
    hash or least_time 등등 load balancing method

    server ip:port;
    server ip:port;
    server ip:port;
  }
}


=> ngingx가 설치되어 있는 host의 8888 port를 listen.
=> 8888 port로 들어온 stream들을 <stream_backend>로 보냄.



**참고**  
- https://www.nginx.com/resources/admin-guide/tcp-load-balancing/
