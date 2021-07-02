FROM openjdk:15-jdk-slim
COPY "./build/libs/configservice-0.0.1-SNAPSHOT.jar" "configservice.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","configservice.jar"] 