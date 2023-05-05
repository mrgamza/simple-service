# Simple Service
Simple spring + Kotlin + JPA application
- Policy Get 
- Student Get, Post

## Database
```mysql
CREATE DATABASE {db_name};

CREATE TABLE `student`(
	`id` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`name` VARCHAR(255) NOT NULL,
	`age` INT
);
```

## application.properties
make file and set
```properties
### Mysql setting ###
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/{db_name}?serverTimezone=UTC&characterEncoding=UTF-8
spring.datasource.username={db_user}
spring.datasource.password={db_password}

### jpa setting ###
spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
spring.jpa.show-sql=false
```

## Endpoint
| Method | Endpoint             | Body                   | Description          |
|:------:|----------------------|------------------------|----------------------|
|  Get   | /                    | -                      | Welcome (String)     |
|  Get   | /view                | -                      | Welcome (Html)       |
|  Get   | /policy              | -                      | All Policy List      |
|  Get   | /policy/{id}         | -                      | ID policy            |
|  Get   | /student             | -                      | All Student List     |
|  Get   | /student?name={name} | -                      | Student List by name |
|  Post  | /student             | {"name": "X","age": 1} | Insert Student       |

## Author
- Donghyuk Lee, mrgamza@gmail.com

## License
- MIT license.
