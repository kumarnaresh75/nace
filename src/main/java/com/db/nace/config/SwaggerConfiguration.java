package com.db.nace.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableWebMvc
public class SwaggerConfiguration implements WebMvcConfigurer {

    @Bean
    GroupedOpenApi docker(){
        return GroupedOpenApi.builder()
                .pathsToMatch("/")
                .build();
    }
}
