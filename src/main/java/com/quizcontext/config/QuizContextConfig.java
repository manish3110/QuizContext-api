package com.quizcontext.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/*
 * @Configuration indicates that the class contains beans to be managed by the Spring container.
 */
@Configuration
public class QuizContextConfig {
  /*
   * When you use @Bean on a method inside a @Configuration class, you're saying,
   * when you need an object of this type, use the code inside this method to create it.
   */
  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
