package com.example.mybatisStore.springswagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Swagger API Test")
                .version("v1.0.0")
                .description("Swagger API 테스트 입니다.")
                .contact(new Contact().name("HyoJin").email("munhyojin7338@gmail.com").url("https://github.com/munhyojin7338/myBatisStore"));

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
