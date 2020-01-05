package com.truliooapp.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.trulioo.normalizedapi.ApiClient;
import com.trulioo.normalizedapi.api.ConfigurationApi;
import com.trulioo.normalizedapi.api.ConnectionApi;
import com.trulioo.normalizedapi.api.VerificationsApi;

@Configuration
public class Config {
	
	@Value("${basepath}")
	String basePath;
	
	@Value("${apikey}")
	String apiKey;
	
	@Bean
	public ApiClient apiClient() {
		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(basePath);
		apiClient.setApiKey(apiKey);
		return apiClient;
	}
	
	@Bean
	public ConnectionApi connectionApi() {			
		ConnectionApi connectionApi = new ConnectionApi(apiClient());
		return connectionApi;
	}
	
	@Bean
	public ConfigurationApi configurationApi() {			
		ConfigurationApi configurationApi = new ConfigurationApi(apiClient());
		return configurationApi;
	}

	@Bean
	public VerificationsApi verificationsApi() {			
		VerificationsApi verificationsApi = new VerificationsApi(apiClient());
		return verificationsApi;
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
	}
}
