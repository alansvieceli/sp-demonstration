package br.com.alan.Demonstration.configs.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

  @Bean
  public OpenAPI customizeOpenAPI() {
//    final String securitySchemeName = "bearerAuth";
    return new OpenAPI()
//        .addSecurityItem(new SecurityRequirement()
//            .addList(securitySchemeName))
//        .components(new Components()
//            .addSecuritySchemes(securitySchemeName, new SecurityScheme()
//                .name(securitySchemeName)
//                .type(SecurityScheme.Type.HTTP)
//                .scheme("bearer")
//                .bearerFormat("JWT")))
        .info(new Info().title("Swagger Documentation for Demonstration Spring Boot API")
            .description("Restful API")
            .version("1.0"));
  }
}
