package com.mysite.myapp.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;


@Configuration
@EnableWebMvc
// @ComponentScan("fr.formation.restcontroller") : not needed as all the package is scanned - thanks to SpringBoot
public class ApiConfig implements WebMvcConfigurer {
	public MappingJackson2HttpMessageConverter jsonConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = jsonConverter.getObjectMapper();
		
		Hibernate5Module module = new Hibernate5Module();
        module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        module.disable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);
        
		objectMapper.registerModule(module);
		return jsonConverter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(this.jsonConverter());
	}
}