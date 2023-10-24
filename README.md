# Kafka-Microservices-Event-Driven-order-stock-email-services

```properties
1. Kafka Broker : It's a message broker, which act as a broker to convey message between producer and consumer.

2. Kafka Topics : To identify the message we assign a message to a particular topic so that consumer can pick it up.

3. Kafka Partitions : Kafka topics are further divided into partitions, so that message can be balanced between those partitions. 
```

# Here total 4 services are created.

# a) Kafka-Single-Service 
```properties
Here I have published the string message and also the json object in the single service using kafka.
```

# b) Kafka-Order-Service
```properties
This will act as producer.
```

# c), d) kafka-stock-service, kafka-mail-service.
```properties
This will act as a message consumer both will be poiting to the same topic.
```

# Steps : 
1. download the apache kafka dependency.
```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```

2. Start the Zoo-keeper with the command inside kafka folder from terminal.
```properties
bin/zookeeper-server-start.sh config/zookeeper.properties
```

3. Start the kafka-server with the command inside kafka folder from terminal.
```properties
bin/kafka-server-start.sh config/server.properties
```

4. Note : To View the message in the topic with the command inside kafka folder from terminal.
where quickstart-events is the topic name.
```properties
bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
```

5. Producer Configuration in application properties.
```properties
# Producer
spring.kafka.producer.bootstrap-servers = localhost:9092
spring.kafka.producer.key-serializer = org.apache.kafka.common.serialization.StringSerializer
#spring.kafka.producer.value-serializer = org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer= org.springframework.kafka.support.serializer.JsonSerializer
spring.kafka.producer.properties.spring.json.add.type.headers=false
```

6. Create a Kafka Configuration class 
```java
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(topicName).build();
    }
```

7. Cosumer Configuration in application properties.
```properties
# Consumer
spring.kafka.consumer.bootstrap-servers = localhost:9092
spring.kafka.consumer.group-id= stock
spring.kafka.consumer.auto-offset-reset = earliest
spring.kafka.consumer.key-deserializer= org.apache.kafka.common.serialization.StringDeserializer
#spring.kafka.consumer.value-deserializer = org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer= org.springframework.kafka.support.serializer.JsonDeserializer
spring.kafka.consumer.properties.spring.json.trusted.packages=*
spring.kafka.listener.type-info-headers=false
```

8. Kafka listner because of different packaging
```java
@KafkaListener(topics = "guide", groupId = "email", properties = {"spring.json.value.default.type=com.kafka.emailService.dto.OrderDto"})
```
