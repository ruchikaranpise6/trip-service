package kafkaconsumerwikimedia.kafkaconsumerwikimedia.consumer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikimediaConsumer {

  private static final Logger logger = LoggerFactory.getLogger("WikimediaConsumer");

  @KafkaListener(topics = {"wikimedia"}, groupId = "myGroup")
  public void consumer(String eventMessage) {
    logger.info("Message received - " + eventMessage);
  }
}
