package com.freemanpivo.chassi.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.freemanpivo.chassi.domain.port.GetVideos;
import com.freemanpivo.chassi.domain.port.GetVideosById;
import com.freemanpivo.chassi.domain.port.RetrieveUserStored;
import com.freemanpivo.chassi.domain.port.SaveVideoModelPort;
import com.freemanpivo.chassi.domain.usecase.GetUserDetails;
import com.freemanpivo.chassi.domain.usecase.RetrieveVideos;
import com.freemanpivo.chassi.domain.usecase.RetrieveVideosById;
import com.freemanpivo.chassi.domain.usecase.SaveVideoInfo;

@Configuration
public class AluraChallengeAppConfiguration {

	@Bean
	GetUserDetails getUserDetails(RetrieveUserStored retrieveUserStored) {
		return new GetUserDetails(retrieveUserStored);
	}

	@Bean
	SaveVideoInfo saveVideoInfo(SaveVideoModelPort saveVideoModelPort) {
		return new SaveVideoInfo(saveVideoModelPort);
	}

	@Bean
	RetrieveVideos retrieveVideos(GetVideos getVideos) {
		return new RetrieveVideos(getVideos);
	}
	
	@Bean
	RetrieveVideosById retrieveVideosById(GetVideosById getVideosById) {
		return new RetrieveVideosById(getVideosById);
	}
}
