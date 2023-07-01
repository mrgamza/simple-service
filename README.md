# Simple Service
Simple spring + Kotlin + JPA application
- Policy Get 
- Student Get, Post

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

## Endpoint
| Method | Endpoint            | Body                        | Description          |
|:------:|---------------------|-----------------------------|----------------------|
|  Get   | /                   | -                           | Welcome (String)     |
|  Get   | /view               | -                           | Welcome (Html)       |
|  Get   | /policy             | -                           | All Policy List      |
|  Get   | /policy/{id}        | -                           | ID policy            |
|  Get   | /user               | -                           | All Student List     |
|  Get   | /user?name={name}   | -                           | Student List by name |
|  Post  | /user               | {"name": "X","age": 1}      | Insert Student       |
|  Get   | /post               | -                           | All Post List        |
|  Get   | /post?title={title} | -                           | Post List by name    |
|  Post  | /post               | {"title": "X","comment": 1} | Insert Post          |

## Author
- Donghyuk Lee, mrgamza@gmail.com

## License
- MIT license.
