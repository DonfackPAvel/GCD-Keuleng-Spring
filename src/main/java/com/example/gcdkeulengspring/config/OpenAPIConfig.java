package com.example.gcdkeulengspring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Value("${GCD-Keuleng.openapi.dev-url}")
    private String devUrl;
    @Value("${GCD-Keuleng.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("noubissiepavel@gmail.com");
        contact.setName("Donfack Pavel");
        contact.setUrl("http://www.noubissie.com");

        License mitLicense = new License().name("MIT LICENSE").url("https://choosealicense.com/licenses/mit/");
        Info info = new Info()
                .title("gcdkeulengspring Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to mange gcdkeulengspring").termsOfService("https://www.noubissie.com/terms")
                .license(mitLicense);
        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }

}
