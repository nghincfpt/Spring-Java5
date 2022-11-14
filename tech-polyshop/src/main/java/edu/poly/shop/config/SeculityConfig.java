package edu.poly.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;

@Configuration
public class SeculityConfig {
	@Bean
BCryptPasswordEncoder getBCryptPasswordEncoder() {

 return new BCryptPasswordEncoder();
}
}
