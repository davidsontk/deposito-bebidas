package br.com.principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StarterApplication {

    private static ApplicationContext context;

    private static Logger log = LogManager.getLogger(StarterApplication.class);

    public static void main(String[] args) {
        context = SpringApplication.run(StarterApplication.class, args);

       // SpringApplication.run(StarterApplication.class, args);
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
