FROM openjdk:21
EXPOSE 8080
ADD build/libs/k8s-example-0.0.1-SNAPSHOT.jar k8s-example-0.0.1.jar
ENTRYPOINT ["java", "-jar", "k8s-example-0.0.1.jar"]