package arv.gatewayservice;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ArvikV
 * @version 1.0
 * @since 13.04.2022
 */
@Configuration
public class GatewayConfig {
    @Bean
    @LoadBalanced
    public RouteLocator getPathsToServices(RouteLocatorBuilder builder) {
        return builder.routes()
                //.route(r -> r.path("/**").uri("http://localhost:8083"))
                .route(r -> r.path("/user-service/**").uri("http://localhost:8081"))
                .route(r -> r.path("/**").uri("http://localhost:8085"))
                .build();
    }
}
