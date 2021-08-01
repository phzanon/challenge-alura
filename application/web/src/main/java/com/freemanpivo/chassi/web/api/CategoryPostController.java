package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.port.command.SaveCategoryCommand;
import com.freemanpivo.chassi.domain.util.CategoryValidator;
import com.freemanpivo.chassi.web.dto.CategoryPostDto;
import com.freemanpivo.chassi.web.mappers.CategoryPostDtoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class CategoryPostController {

    private final CategoryPostDtoMapper mapper;
    private final SaveCategoryCommand command;

    @PostMapping("/categorias")
    public ResponseEntity<Category> save(@RequestBody CategoryPostDto dto) {
        CategoryValidator.validate(mapper.toModel(dto));
        Category category = command.save(mapper.toModel(dto));
        return ResponseEntity.ok(category);
    }
}
