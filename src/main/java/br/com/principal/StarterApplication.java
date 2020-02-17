package br.com.principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterApplication {

    private static Logger log = LogManager.getLogger(StarterApplication.class);
    

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }
}
