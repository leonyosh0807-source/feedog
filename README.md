# feedog

## Feedog（クラウド版）

### アクセスURL
- 食事入力画面: https://feedog.onrender.com/feed
- ログ一覧画面: https://feedog.onrender.com/logs

### 実行環境
- Java 17
- Spring Boot 3.3.5
- PostgreSQL

### 必要な環境変数
- SPRING_DATASOURCE_URL
- SPRING_DATASOURCE_USERNAME
- SPRING_DATASOURCE_PASSWORD
- SPRING_DATASOURCE_DRIVER_CLASS_NAME

### Dockerでの起動（将来AWS用）
```bash
docker build -t feedog .
docker run -p 8080:8080 feedog
