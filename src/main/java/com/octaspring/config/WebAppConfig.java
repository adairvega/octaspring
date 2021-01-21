package com.octaspring.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.octaspring.controller")
public class WebAppConfig implements ApplicationContextAware{
   
   private ApplicationContext applicationContext;
   
   @Override
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      // TODO Auto-generated method stub
      this.applicationContext = applicationContext;
   }
   
   @Bean
   public MessageSource messageSource() {
      
      ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
      messageSource.setBasename("messages");
      return messageSource;
   }
   
   @Bean
   public SpringResourceTemplateResolver templateResolver() {
      //Indicar dónde están las vistas
      SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
      templateResolver.setApplicationContext(this.applicationContext);
      templateResolver.setPrefix("/WEB-INF/templates/");
      templateResolver.setSuffix(".html");
      return templateResolver;
   }
   
   @Bean 
   public SpringTemplateEngine TemplateEngine() {
      SpringTemplateEngine templateEngine = new SpringTemplateEngine();
      templateEngine.setTemplateResolver(this.templateResolver());
      templateEngine.setEnableSpringELCompiler(true);
      return templateEngine;
   }
   
   @Bean 
   public ThymeleafViewResolver viewResolver() {
      ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
      viewResolver.setTemplateEngine(this.TemplateEngine());
      return viewResolver;
   }
   
}
