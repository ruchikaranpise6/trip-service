package kafkaproducerwikimedia.kafkaproducerwikimedia.producer;

import com.launchdarkly.eventsource.EventSource;
import kafkaproducerwikimedia.kafkaproducerwikimedia.handler.WikiMediaHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        String topic = "wikimedia";

        //to read real time stream data to wikimedia, we use event source

        WikiMediaHandler wikiMediaHandler = new WikiMediaHandler(kafkaTemplate, topic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(wikiMediaHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(5);
    }
}
