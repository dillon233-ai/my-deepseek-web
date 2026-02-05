# 第一阶段：编译 (使用 Eclipse Temurin 提供的 JDK 11)
FROM maven:3.8.6-eclipse-temurin-11 AS build
COPY . .
RUN mvn clean package -DskipTests

# 第二阶段：运行 (使用 Eclipse Temurin 提供的 JRE 11)
FROM eclipse-temurin:11-jre
# 这里的 target/*.jar 改成具体一点，防止拷贝了不该拷贝的原始包
COPY --from=build /target/项目名-版本号.jar app.jar
# 如果你偷懒，也可以用下面这一行（只要 target 下只有一个 jar）
# COPY --from=build /target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]