package com.DeviceAtlas.TabletTracker.TabletTracker.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.DeviceAtlas.TabletTracker.TabletTracker.model.UserAgentEntity;
import com.DeviceAtlas.TabletTracker.TabletTracker.repository.UserAgentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAgentService {
	
    private final UserAgentRepository repository;
    private final RestTemplate restTemplate;
    
    @Value("${api.license.key}")
    private String licenseKey;

    public UserAgentService(UserAgentRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }


    public void fetchAndStoreUserAgentData(String userAgent) throws JsonMappingException, JsonProcessingException {
    	String url = "https://region0.deviceatlascloud.com/v1/detect/properties"
    	           + "?licencekey=" + licenseKey + "&useragent=" + userAgent;

    	
    	String response = restTemplate.getForObject(url, String.class);
    	ObjectMapper objectMapper = new ObjectMapper();
    	// Parse the response into a JsonNode
    	JsonNode rootNode = objectMapper.readTree(response);
    	// Extract the "properties" node
    	JsonNode propertiesNode = rootNode.path("properties");
    	UserAgentEntity convertedResponse = objectMapper.treeToValue(propertiesNode, UserAgentEntity.class);
        
    	
    	if (convertedResponse != null) {
            repository.save(convertedResponse);
            System.out.println("Saved User-Agent: " + convertedResponse);
        }
    }
    
    public List<UserAgentEntity> getTabletsSortedByOsVersion() {
        return repository.findByPrimaryHardwareTypeOrderByOsVersionDesc("Tablet");
    }
    
    public void deleteAllDevices() {
    	repository.deleteAll();
    }

}


    
