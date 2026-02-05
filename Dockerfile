# 第一阶段：编译
FROM maven:3.8.5-openjdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

# 第二阶段：运行
FROM openjdk:11-jre-slim
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]