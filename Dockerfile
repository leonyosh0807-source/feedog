# ===== ビルド用ステージ =====
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Maven 設定とソースをコピー
COPY pom.xml .
COPY src ./src

# テストを飛ばして jar を作成
RUN ./mvnw -q clean package -DskipTests || mvn -q clean package -DskipTests


# ===== 実行用ステージ =====
FROM eclipse-temurin:17-jre

WORKDIR /app

# ビルド済み jar をコピー
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
