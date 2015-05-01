package com.javatrainee.batch27;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Workshop2coreApplication {

    public static void main(String[] args) {
        SpringApplication.run(Workshop2coreApplication.class, args);
//        Workshop2coreApplication a = new Workshop2coreApplication();
//        a.matching();
    }
    
//    @Scheduled(fixedDelay = 5000)
//    public void matching()
//    {
//    	System.out.println("COba coba");
//    }
}
