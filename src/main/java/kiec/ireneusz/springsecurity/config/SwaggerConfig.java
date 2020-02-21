package kiec.ireneusz.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private static final String BasePackage = "eu.aberit.abiflowbuilder";

    @Bean
    public Docket productApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.select()
                .apis(RequestHandlerSelectors.basePackage(BasePackage))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
}
