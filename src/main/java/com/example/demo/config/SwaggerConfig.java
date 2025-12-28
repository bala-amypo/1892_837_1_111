package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server httpsServer = new Server();
        httpsServer.setUrl("https://9219.408procr.amypo.ai");
        httpsServer.setDescription("HTTPS Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Hostel Roommate Compatibility Matcher API")
                        .version("1.0")
                        .description("Backend APIs for Hostel Roommate Compatibility System"))
                .servers(List.of(httpsServer));
    }
}
