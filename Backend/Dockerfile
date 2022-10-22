FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/docker-spring-boot.war docker-spring-boot.war
ENTRYPOINT ["java","-jar","/docker-spring-boot.war"]
