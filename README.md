## sun Spring Kafka test

### 1.Start zookeeper server:

$ ./bin/zookeeper-server-start.sh ./config/zookeeper.properties

### 2. Start kafka-server:

$./bin/kafka-server-start.sh ./config/server.properties

### 3. Create topic: 

$./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic sunt01

### 4. Run project

### 5. curl "http://localhost:9680/kafka/test/sendmsg01"
