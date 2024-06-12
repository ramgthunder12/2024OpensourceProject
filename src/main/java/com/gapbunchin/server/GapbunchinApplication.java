package com.gapbunchin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.gapbunchin.server.service.UserService;

@SpringBootApplication
public class GapbunchinApplication {

    public static void main(String[] args) {
        SpringApplication.run(GapbunchinApplication.class, args);
    }

}
