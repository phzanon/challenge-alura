package com.freemanpivo.chassi.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.freemanpivo.chassi.domain.port.operations.DeleteCategoryById;
import com.freemanpivo.chassi.domain.port.operations.DeleteVideoPort;
import com.freemanpivo.chassi.domain.port.operations.GetCategories;
import com.freemanpivo.chassi.domain.port.operations.GetVideos;
import com.freemanpivo.chassi.domain.port.operations.GetVideosByCategory;
import com.freemanpivo.chassi.domain.port.operations.GetVideosById;
import com.freemanpivo.chassi.domain.port.operations.GetVideosByTitle;
import com.freemanpivo.chassi.domain.port.operations.SaveCategoryModelPort;
import com.freemanpivo.chassi.domain.port.operations.SaveVideoModelPort;
import com.freemanpivo.chassi.domain.usecase.DeleteCategory;
import com.freemanpivo.chassi.domain.usecase.DeleteVideo;
import com.freemanpivo.chassi.domain.usecase.RetrieveCategories;
import com.freemanpivo.chassi.domain.usecase.RetrieveVideoByCategory;
import com.freemanpivo.chassi.domain.usecase.RetrieveVideos;
import com.freemanpivo.chassi.domain.usecase.RetrieveVideosById;
import com.freemanpivo.chassi.domain.usecase.RetrieveVideosByTitle;
import com.freemanpivo.chassi.domain.usecase.SaveCategoryInfo;
import com.freemanpivo.chassi.domain.usecase.SaveVideoInfo;
import com.freemanpivo.chassi.domain.usecase.UpdateCategory;
import com.freemanpivo.chassi.domain.usecase.UpdateVideo;

@Configuration
public class AluraChallengeAppConfiguration {

	@Bean
	RetrieveCategories retrieveCategories(GetCategories getCategories) {
		return new RetrieveCategories(getCategories);
	}

	@Bean
	RetrieveVideos retrieveVideos(GetVideos getVideos) {
		return new RetrieveVideos(getVideos);
	}

	@Bean
	SaveVideoInfo saveVideoInfo(SaveVideoModelPort saveVideoModelPort, RetrieveCategories retrieveCategories) {
		return new SaveVideoInfo(saveVideoModelPort, retrieveCategories);
	}

	@Bean
	RetrieveVideosById retrieveVideosById(GetVideosById getVideosById) {
		return new RetrieveVideosById(getVideosById);
	}

	@Bean
	RetrieveVideosByTitle retrieveVideosByTitle(GetVideosByTitle getVideosByTitle) {
		return new RetrieveVideosByTitle(getVideosByTitle);
	}

	@Bean
	DeleteVideo deleteVideo(DeleteVideoPort deleteVideoPort) {
		return new DeleteVideo(deleteVideoPort);
	}

	@Bean
	RetrieveVideoByCategory retrieveVideoByCategory(GetVideosByCategory getVideosByCategory) {
		return new RetrieveVideoByCategory(getVideosByCategory);
	}

	@Bean
	SaveCategoryInfo saveCategoryInfo(SaveCategoryModelPort saveCategoryModelPort) {
		return new SaveCategoryInfo(saveCategoryModelPort);
	}

	@Bean
	DeleteCategory deleteCategory(DeleteCategoryById deleteCategoryById, RetrieveCategories retrieveCategories) {
		return new DeleteCategory(deleteCategoryById, retrieveCategories);
	}

	@Bean
	UpdateVideo updateVideo(RetrieveVideosById retrieveVideosById, SaveVideoInfo saveVideoInfo) {
		return new UpdateVideo(retrieveVideosById, saveVideoInfo);
	}

	@Bean
	UpdateCategory updateCategory(RetrieveCategories retrieveCategories, SaveCategoryInfo saveCategoryInfo) {
		return new UpdateCategory(retrieveCategories, saveCategoryInfo);
	}
}
