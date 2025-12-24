package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    // ✅ THIS METHOD IS REQUIRED BY DemoMassiveTestNGTests
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Demo API")
                        .version("1.0"))
                .servers(List.of(
                        new Server().url("https://9219.408procr.amypo.ai/")
                ));
    }

    // Optional Spring Bean (won't break tests)
    @Bean
    public OpenAPI customOpenAPI() {
        return api();
    }
}
