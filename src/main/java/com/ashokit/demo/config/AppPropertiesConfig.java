package com.ashokit.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
@ConfigurationProperties(prefix="userMng")
@EnableConfigurationProperties
public class AppPropertiesConfig {
	
	private Map<String,String> messages = new HashMap<>();

}
