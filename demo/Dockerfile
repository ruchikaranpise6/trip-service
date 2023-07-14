FROM adoptopenjdk/openjdk11:alpine-jre
copy build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]