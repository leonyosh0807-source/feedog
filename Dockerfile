# ===== ビルド用ステージ（Maven入り）=====
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# 依存関係を先に解決（キャッシュが効く）
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# ソースをコピーしてビルド
COPY src ./src
RUN mvn -q clean package -DskipTests


# ===== 実行用ステージ =====
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

