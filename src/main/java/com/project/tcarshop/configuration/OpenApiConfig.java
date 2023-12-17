package com.project.tcarshop.configuration;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "TCarShop API Documentation",
                version = "1.0.0",
                description = "Website quản lý xe dùng Java Spring boot",
        contact = @Contact(
                name = "Hồ Minh Trung",
                url = "https://github.com/bykytadev",
                email = "trung@7-mau.com")
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local Development Server"),
                @Server(url = "http://171.239.86.22:8080", description = "Production Server"),
        }
)

@Configuration
public class OpenApiConfig {

}