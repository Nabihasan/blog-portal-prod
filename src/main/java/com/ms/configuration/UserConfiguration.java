package com.ms.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * This is @Configuration class.
 */
@Configuration
public class UserConfiguration {
      /**
       * This is @encoder method.
       * @return BCryptPasswordEncoder object
       */
      @Bean
      public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
      }
      }
