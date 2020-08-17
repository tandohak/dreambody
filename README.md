# DREAM BODY
- 먹은 음식을 등록하여, 하루 섭취량을 확인하여 체중감량, 체중증가, 체중유지 등 원하는 목표를
  이룰 수 있게 해주는 서비스
  
## 로컬에만 있는 파일
- src/resources/application-docker.yml
- 운영서버 db정보
```yml
spring:
  jpa:
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL5InnoDBDialect
  hibernate:
    ddl-auto: none # 운영이기 때문에 테이블 자동 생성 하지 않음
  datasource:
    url: jdbc:mariadb://RDS주소:포트/[DB명]
    driver-class-name: org.mariadb.jdbc.Driver
    username: [계정]
    password: [패스워드]
```