package com.project.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class Appconfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
     httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
             .authorizeHttpRequests(Authorize -> Authorize.requestMatchers("/api/**").authenticated().anyRequest().permitAll())
             .addFilterBefore(null,null).csrf().disable()
             .cors().configurationSource(new CorsConfigurationSource() {
                 @Override
                 public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                     CorsConfiguration cfg =new CorsConfiguration();
                     cfg.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
                     return null;
                 }
             });
       return  null;

    }

}
