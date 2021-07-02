FROM openjdk:15-jdk-slim
COPY "./build/libs/registryservice-0.0.1-SNAPSHOT.jar" "registryservice.jar"
EXPOSE 8079
ENTRYPOINT ["java","-jar","registryservice.jar"] 