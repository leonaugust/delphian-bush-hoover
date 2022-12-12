Delphian Bush. Hoover.
-----------------
**Launch landoop** 

    docker-compose up -d

    Open localhost:3030
    Wait the system to initialize(when 0 connectors shown)

---
**Launch Coin-Api**

Connectors -> New -> CoinApiSourceConnector

Properties:

    name=DelphianBushCoinApiSourceConnector
    tasks.max=1
    connector.class=com.delphian.bush.CoinApiSourceConnector
    topic=exchange-rates
    application=delphian-bush-coin-api-source-connector
    coin.api.key=API_KEY
    profile.active=test
    poll.timeout=60
    key.converter=org.apache.kafka.connect.json.JsonConverter
    value.converter=org.apache.kafka.connect.json.JsonConverter
    key.converter.schemas.enable=false
    value.converter.schemas.enable=false
---
**Launch CryptoPanic**.
Connectors -> New ->  CryptoPanicSourceConnector

Properties:

    name=CryptoPanicSourceConnector
    connector.class=com.delphian.bush.CryptoPanicSourceConnector
    tasks.max=1
    topic=news
    application=crypto-panic-source-connector
    crypto.panic.key=API_KEY
    profile.active=prod
    poll.timeout=60
    key.converter=org.apache.kafka.connect.json.JsonConverter
    value.converter=org.apache.kafka.connect.json.JsonConverter
    key.converter.schemas.enable=false
    value.converter.schemas.enable=false    

---
Cleanup

    docker-compose down --volumes
----
Read data from news topic

    docker exec --interactive --tty kafka-cluster \
    kafka-console-consumer --bootstrap-server 127.0.0.1:9092 \
    --topic news \
    --from-beginning
---
Known bugs:
- Landoop shows incorrect number of records in topics.