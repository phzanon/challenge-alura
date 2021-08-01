package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.SaveCategoryCommand;
import com.freemanpivo.chassi.domain.port.command.SearchCategories;
import com.freemanpivo.chassi.domain.port.command.SearchVideoByCategory;
import com.freemanpivo.chassi.domain.util.IdValidator;
import com.freemanpivo.chassi.domain.util.VideoValidator;
import com.freemanpivo.chassi.web.dto.CategoryDto;
import com.freemanpivo.chassi.web.dto.CategoryPostDto;
import com.freemanpivo.chassi.web.mappers.CategoryDtoMapper;
import com.freemanpivo.chassi.web.mappers.CategoryPostDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

	private final SearchVideoByCategory searchVideoByCategory;
	private final SearchCategories searchCategories;

	private final SaveCategoryCommand command;
	private final CategoryDtoMapper mapper;
	private final CategoryPostDtoMapper categoryPostDtoMapper;

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		final var categories = searchCategories.getAllCategories();
		return ResponseEntity.ok(categories);
	}

    @GetMapping("/{id}/videos")
    public ResponseEntity<List<Video>> getAllVideosByCategory(@PathVariable("id") String id) {
        IdValidator.validate(id);
        final var videos = searchVideoByCategory.getVideos(Long.parseLong(id));
        return ResponseEntity.ok(videos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") String id) {
		IdValidator.validate(id);
		final var category = searchCategories.getCategoryById(Long.parseLong(id));
		return ResponseEntity.ok(category);
	}
}
