package springboot30.springboot30.httpclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/custom-trip")
public interface CustomTripServiceClient {

    @GetExchange
    ResponseEntity<String> getCustomTrip();
}
