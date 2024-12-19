package com.onlineshopping.userservice.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Online Shopping Service"))
				.addSecurityItem(new SecurityRequirement().addList("OnlineShoppingService"))
				.components(new Components().addSecuritySchemes("OnlineShoppingService", new SecurityScheme()
						.name("OnlineShoppingService").type(SecurityScheme.Type.HTTP).scheme("basic")));
	}
}