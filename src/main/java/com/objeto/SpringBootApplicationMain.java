package com.objeto;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;

@EnableAdminServer
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplicationMain {
    public static void main(String[] args)
    {
        SpringApplication.run(SpringBootApplicationMain.class, args);
    }
}