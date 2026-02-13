# ======== dockerの起動　========
cd cloud-service-emulation-tools
docker-compose up -d

# ======== jarの作成・配置 ========
# プロジェクトに移動
cd nifi-scripting-libs

# クリーンしてからパッケージ化し、依存JARを target/libs に集める
mvn clean package dependency:copy-dependencies -DoutputDirectory=target/libs

# 自分が書いたコードのJARをコピー
cp target/*.jar ../data/custom-lib/

# 集めてきたOSSのJAR(Jacksonなど)を全てコピー
cp target/libs/*.jar ../data/custom-lib/

# 親フォルダに戻ってから再起動
cd ..
docker restart nifi-core

