User CRUD Spring Boot API Server

### 테스트 방법
1. H2 데이터베이스를 설정해주세요
    - H2 데이터베이스 설치 (https://www.h2database.com/html/main.html)
    - jdbc:h2:~/simple  으로 접속해주세요 (세션 키 유지한 상태에서)
    - simple.mv.h2 파일 생성을 확인해주세요
    - jdbc:h2:tcp://localhost/~/simple  로 접속이 잘 되는 지 확인해주세요
2. 테스트코드를 실행해주세요
    - src/test/java/com/cloudy/simplespring/service/UserServiceTest.java
3. HTTP Client 파일도 만들었습니다
    - src/test/java/com/cloudy/simplespring/UserAPItest.http