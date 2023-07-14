package com.girly.schtick.api.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JWTValidatorUtil jwtValidatorUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            if (routeValidator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("Missing Authorization Header");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7); //this is token
                }
                try {
                    //call to security service to validate token but this approach can easily get hack.
                    //restTemplate.getForObject("http://SPRING-SECURITY-DEMO/security/validate?token=" + authHeader, Boolean.class);

                    if (!jwtValidatorUtil.validateToken(authHeader)) {
                        throw new RuntimeException("Token is not valid");
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            return chain.filter(exchange);
        }));
    }

    public static class Config {

    }

}
