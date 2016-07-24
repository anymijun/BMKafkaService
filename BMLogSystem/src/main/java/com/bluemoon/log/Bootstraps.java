package com.bluemoon.log;

import com.bluemoon.log.jpa.domain.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses=City.class)
public class Bootstraps {
    public static void main(String[] args) {
        SpringApplication.run(Bootstraps.class, args);
    }
}
