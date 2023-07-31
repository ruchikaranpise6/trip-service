package springboot30.springboot30.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import springboot30.springboot30.httpclient.CustomTripServiceClient;

@Configuration
public class AppClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8082")
                .build();
    }

    @Bean
    public CustomTripServiceClient getClient() {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient()))
                .build();

        return httpServiceProxyFactory.createClient(CustomTripServiceClient.class);

    }
}
