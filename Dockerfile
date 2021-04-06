FROM openjdk:8
ADD target/orange-test.jar orange-test.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","orange-test.jar"]
