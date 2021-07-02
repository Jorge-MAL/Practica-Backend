FROM openjdk:15-jdk-slim
COPY "./build/libs/gatewayservice-0.0.1-SNAPSHOT.jar" "gatewayservice.jar"
EXPOSE 8078
ENTRYPOINT ["java","-jar","gatewayservice.jar"] 