package uz.najot;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/category/**")
                        .uri("lb://CATEGORY-SERVICE")
                )
                .route(r -> r.path("/product/**")
                        .uri("lb://PRODUCT-SERVICE")
                )
                .build();
    }
}
