package com.girly.schtick.trip.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalancerConfiguration {

    @Bean
    public ServiceInstanceListSupplier discoveryClientServiceInstanceListSupplier(ConfigurableApplicationContext applicationContext) {
        return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().withSameInstancePreference().build(applicationContext);
    }
}
