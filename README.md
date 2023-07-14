# Simple Service
Simple spring + Kotlin + JPA application
- Policy Get 
- Post Get, Post

## Database
```mysql
CREATE DATABASE {YOUR_WANT_NAME};

CREATE TABLE `user`(
	`id` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255) NOT NULL,
	`age` INT
);

CREATE DATABASE {notice_board}

CREATE TABLE `post`(
    `id` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` VARCHAR(255) NOT NULL,
    `comment` VARCHAR(255) NOT NULL
);
```

## application.yml
make file and set
```properties
spring:
  datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    jdbcUrl: jdbc:mysql://localhost:3306/{YOUR}?serverTimezone=UTC&characterEncoding=UTF-8
    username: {YOUR}
    password: {YOUR}

  notice-datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    jdbcUrl: jdbc:mysql://localhost:3306/notice_board?serverTimezone=UTC&characterEncoding=UTF-8
    username: {YOUR}
    password: {YOUR}
```

## Swagger
http://localhost:8080/swagger-ui/index.html#/

## Author
- Donghyuk Lee, mrgamza@gmail.com

## License
- MIT license.
