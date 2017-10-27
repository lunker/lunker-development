# Proxy & Reverse Proxy


# Proxy
- client들이 실 서비스에 접속을 요청하면, proxy가 이를 받아서 요청을 대신 처리하고, 응답을 돌려준다.
- 이 과정에서 caching도 지원하여 속도도 더 월등해진다.

# Reverse Proxy
- 아파치등의 웹 서버는 일반적으로는 브라우저의 요청을 내부 application server(tomcat, web logic 등)에 전달하고 처리 결과를 브라우저에 전송하는 reverse proxy 용도로 많이 사용하므로 실무라면 reverse proxy 설정 방법만 익히시면 되지 않을까 싶습니다.
Reverse Proxy는 실제 요청을 처리하는 서버의 앞 단에 존재하며, 실제 서버로 들어오는 요청을 대신 받아서 해당 서버에 전달하고 그 결과를 받아서 요청한 곳으로 전달해주는 역할을 하는 서버를 의미한다. Reverse Proxy는 보안(실제 서버를 외부에 숨길 때) 및 부하 분산(여러 서버에서 요청을 처리할 때) 등의 이유로 필요하다.
