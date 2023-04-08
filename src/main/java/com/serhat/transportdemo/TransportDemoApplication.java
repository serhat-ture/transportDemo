package com.serhat.transportdemo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransportDemoApplication {
    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }


    public static void main(String[] args) {
        SpringApplication.run(TransportDemoApplication.class, args);
    }

}
