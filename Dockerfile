# 第一阶段：编译 (使用 Eclipse Temurin 提供的 JDK 11)
FROM maven:3.8.6-eclipse-temurin-11 AS build
COPY . .
RUN mvn clean package -DskipTests

# 第二阶段：运行 (使用 Eclipse Temurin 提供的 JRE 11)
FROM eclipse-temurin:11-jre
COPY --from=build /target/*.jar app.jar
# Render 默认会随机分配端口，但 Spring Boot 默认是 8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]