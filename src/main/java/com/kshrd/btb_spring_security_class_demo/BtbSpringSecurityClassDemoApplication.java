package com.kshrd.btb_spring_security_class_demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@SecurityScheme(
        name = "basicAuth", // can be set to anything
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
@OpenAPIDefinition(
        info = @Info(title = "Sample API", version = "v1"),
        security = @SecurityRequirement(name = "basicAuth") // require all endpoint
)
public class BtbSpringSecurityClassDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BtbSpringSecurityClassDemoApplication.class, args);
    }

}
