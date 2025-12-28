package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // ⚠️ DO NOT rename this method
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hostel Roommate Compatibility Matcher API")
                        .version("1.0")
                        .description("Backend APIs for Hostel Roommate Matching"));
    }
}
