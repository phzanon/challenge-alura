package com.freemanpivo.chassi.web;

import com.freemanpivo.chassi.domain.port.operations.*;
import com.freemanpivo.chassi.domain.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

	@Bean
	DeleteVideo deleteVideo(DeleteVideoPort deleteVideoPort) { return new DeleteVideo(deleteVideoPort); }
}
