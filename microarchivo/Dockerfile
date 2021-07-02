FROM openjdk:15-jdk-slim
COPY "./build/libs/microarchivo-0.0.1-SNAPSHOT.jar" "microarchivo.jar"
EXPOSE 8082
ENTRYPOINT ["java","-jar","microarchivo.jar"] 