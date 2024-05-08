import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Arrays;
import java.util.Properties;

public class kafkaConsumer {
  public static void main(String args[]) {

      //properties for producer
      Properties props = new Properties();
      props.put("bootstrap.servers", "localhost:9092");
      props.put("group.id", "test-group");
      
      props.put("enable.auto.commit", "true");	// using auto commit
      
      props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
      props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

      //create kafka consumer
      KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);


      //subscribe to topic
      consumer.subscribe(Arrays.asList("firsttopic"));

      //infinite poll loop
      while (true) {
    	  ConsumerRecords<String, String> records = consumer.poll(100);
    	  for (ConsumerRecord<String, String> record : records)
    		  System.out.printf("offset = %d, key = %s , value = %s",record.offset(), record.key(), record.value());

      }
  }

}
