# Simple Service
Simple spring + Kotlin + JPA application
- Policy 
- Post
- User

## Database
Using flyway
- Rule : V{date}{time}__{Description}

## application.yml
make file and set
```properties
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/notice_board?serverTimezone=UTC&characterEncoding=UTF-8
    username: {YOUR}
    password: {YOUR}
  flyway:
    enabled: true
    baseline-on-migrate: true
    url: jdbc:mysql://localhost:3306/notice_board?serverTimezone=UTC&characterEncoding=UTF-8
    user: {YOUR}
    password: {YOUR}
```

## Swagger
http://localhost:8080/swagger-ui/index.html#/

## Author
- Donghyuk Lee, mrgamza@gmail.com

## License
- MIT license.
