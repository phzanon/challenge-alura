package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.command.DeleteCategoryCommand;
import com.freemanpivo.chassi.domain.port.command.SearchCategoriesCommand;
import com.freemanpivo.chassi.domain.port.command.SearchVideoByCategory;
import com.freemanpivo.chassi.domain.port.command.UpdateCategoryCommand;
import com.freemanpivo.chassi.domain.util.CategoryValidator;
import com.freemanpivo.chassi.domain.util.IdValidator;
import com.freemanpivo.chassi.web.dto.CategoryPostDto;
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

	private final SearchCategoriesCommand searchCategoriesCommand;
	private final DeleteCategoryCommand deleteCategoryCommand;
	private final CategoryPostDtoMapper categoryPostDtoMapper;
	private final UpdateCategoryCommand updateCategoryCommand;

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		final var categories = searchCategoriesCommand.getAllCategories();
		return ResponseEntity.ok(categories);
	}



    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") String id) {
		IdValidator.validate(id);
		final var category = searchCategoriesCommand.getCategoryById(Long.parseLong(id));
		return ResponseEntity.ok(category.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") String id) {
		IdValidator.validate(id);
		return deleteCategoryCommand.deleteCategory(Long.parseLong(id)) ? ResponseEntity.ok("Removido") : ResponseEntity.ok("Não Removido");
	}

	@PutMapping
	public ResponseEntity<Category> updateCategory(@RequestBody CategoryPostDto dto) {
		final var category = categoryPostDtoMapper.toModel(dto);
		CategoryValidator.validate(category);
		return ResponseEntity.ok(updateCategoryCommand.updateCategory(category));
	}
}
