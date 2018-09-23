package org.parentsstepahead.psa;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PsaApplication {




    public static void main(String[] args) {
        SpringApplication.run(PsaApplication.class, args);
    }
}
