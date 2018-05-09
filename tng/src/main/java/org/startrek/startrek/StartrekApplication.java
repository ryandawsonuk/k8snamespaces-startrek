package org.startrek.startrek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StartrekApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StartrekApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(StartrekApplication.class, args);
	}

	@Bean
	@ConditionalOnMissingBean(type = "RestTemplate")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
