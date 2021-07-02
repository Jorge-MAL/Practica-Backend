FROM openjdk:15-jdk-slim
COPY "./build/libs/adminservice-0.0.1-SNAPSHOT.jar" "adminservice.jar"
EXPOSE 8077
ENTRYPOINT ["java","-jar","adminservice.jar"] 