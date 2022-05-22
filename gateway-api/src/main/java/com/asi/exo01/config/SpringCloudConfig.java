package com.asi.exo01.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
public class SpringCloudConfig {

		// TODO Auto-generated constructor stub
		@Bean
		@CrossOrigin(origins = "http://localhost:3000")
		public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
			return builder.routes()
				.route("authModule", r -> r.path("/auth/**")
					.uri("http://localhost:8081/"))
				.route("cardModule", r -> r.path("/cards/**")
						.uri("http://localhost:8082/"))
				.route("userModule", r -> r.path("/users/**")
						.uri("http://localhost:8083/"))
				.route("transactionModule", r -> r.path("/transactions/**")
						.uri("http://localhost:8084/"))
				.route("gameModule", r -> r.path("/game/**")
						.uri("http://localhost:8085/"))
				.build();
		}
}
