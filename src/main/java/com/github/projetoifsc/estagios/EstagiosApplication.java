package com.github.projetoifsc.estagios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableCaching
public class EstagiosApplication {

    public static void main(String[] args) {
        SpringApplication.run(EstagiosApplication.class, args);
    }

}
