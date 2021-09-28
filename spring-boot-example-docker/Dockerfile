FROM openjdk:8-jdk-alpine
ENV TZ=Asia/Shanghai
EXPOSE 8080
ARG JAR_FILE
ADD target/${JAR_FILE} /app.jar
ENTRYPOINT ["/usr/bin/java", "-jar","/app.jar"]