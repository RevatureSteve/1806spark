package com.revature.flashcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.flashcard.models.StudySet;

@Service
public class ApiService {

	//need to make this a new spring bean
	@Autowired
	private RestTemplate restTemplate; 
	
	@Bean //the object that is returned from this method is now  Spring Bean!
	public RestTemplate restTemplateBuilder(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}
	
	public StudySet[] setStudySetApi() {
		System.out.println("retrieving studysets");
		String URL = "http://localhost:9002/studyset";
		StudySet[] studySetArray = restTemplate.getForObject(URL, StudySet[].class);
		return studySetArray;
	}
	
}
