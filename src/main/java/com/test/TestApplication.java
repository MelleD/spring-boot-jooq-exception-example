/*
 * Copyright (c) 2023 Robert Bosch Manufacturing Solutions GmbH, Germany. All rights reserved.
 */

package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

   public static void main( final String[] args ) {
      SpringApplication.run( TestApplication.class, args );
   }

   @Bean
   StartupListener startupListener() {
      return new StartupListener();
   }

}
