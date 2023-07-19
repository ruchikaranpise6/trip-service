========VM variables=========

 -DMYSQL_USER=root
 -DMYSQL_PASSWORD=root
 -DMYSQL_PORT=3307

========steps for docker=============

1. docker run -p 3307:3307 --name mysqldb mysql

this command will give you an error as usernmae and password are not set.

so delete created docker container-

use command "docker ps -a" it will give you an container Id or conatiner use.

to remove container use "docker rm mysqldb"

2. Now, give correct command

docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=user mysql

here, you can give any password.

3. Now your mysql is up on port 3307 - You can start using it.

4. Create an jar of your code

5. To create an image of your code - create Dockerfile with below statements -

FROM adoptopenjdk/openjdk11:alpine-jre
copy build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

 7. to build the image-
 docker build -t app .

6. to run this image use below command

docker run -p9090:8080 --name app -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root app -e MYSQL_PORT=3307 app


8. to connect to network

8.1 create => docker network create demo
8.2 to connect => docker network connect demo mysqldb
8.3 to check connection => docker container inspect mysqldb

9. stop our app container, remove and run it again in 'demo' network

docker run -p9090:8080 --name app --net demo -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root app -e MYSQL_PORT=3306 app

10. copy env variables in file called env

contents of a file -

MYSQL_HOST=mysqldb
MYSQL_USER=root
MYSQL_PASSWORD=root
MYSQL_PORT=3306

command to run with  a file ->
docker run -p9090:8080 --name app --net demo --env-file env app

11. to remove image forcly

docker rm -f mysqldb

12. to add volume while running mysql command
docker run -p 3307:3306 --name mysqldb --net demo --mount type=bind,source=/Users/rranpise/db,target=/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=user -d mysql

12. to restart container

docker restart app
=====================

application.yml -> content

spring:
  jpa:
    hibernate:
      ddl-auto: update
  datasource:
    url: jdbc:mysql://${MYSQL_HOST:localhost}:${MYSQL_PORT:3306}/user
    driver-class-name: com.mysql.jdbc.Driver
    username: ${MYSQL_USER:root}
    password: ${MYSQL_PASSWORD:root}

=========Curls==========
1. Request to create record

curl --location --request POST 'http://localhost:9090/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Ruchika",
    "id": "1"
}'

2. to get record by id

curl --location --request GET 'http://localhost:9090/users/1'

