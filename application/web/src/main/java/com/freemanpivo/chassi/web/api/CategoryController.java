package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.exception.BusinessException;
import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.DeleteCategoryCommand;
import com.freemanpivo.chassi.domain.port.command.SearchCategories;
import com.freemanpivo.chassi.domain.port.command.SearchVideoByCategory;
import com.freemanpivo.chassi.domain.util.IdValidator;
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
	private final DeleteCategoryCommand deleteCategoryCommand;

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

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") String id) {
		IdValidator.validate(id);
		return deleteCategoryCommand.deleteCategory(Long.parseLong(id)) ? ResponseEntity.ok("Removido") : ResponseEntity.ok("Não Removido");
	}
}
