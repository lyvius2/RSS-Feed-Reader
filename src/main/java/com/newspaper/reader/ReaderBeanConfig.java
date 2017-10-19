package com.newspaper.reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReaderBeanConfig {

	@Bean
	public Gson gson() {
		return new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
	}
}
