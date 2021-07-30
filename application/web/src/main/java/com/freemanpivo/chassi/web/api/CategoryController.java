package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.domain.model.Category;
import com.freemanpivo.chassi.domain.model.Video;
import com.freemanpivo.chassi.domain.port.command.SearchAllCategories;
import com.freemanpivo.chassi.domain.port.command.SearchVideoByCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final SearchVideoByCategory searchVideoByCategory;
    private final SearchAllCategories searchAllCategories;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        final var categories = searchAllCategories.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}/videos")
    public ResponseEntity<List<Video>> getAllVideosByCategory(@PathVariable("id") String id) {
        final var videos = searchVideoByCategory.getVideos(Long.parseLong(id));
        return ResponseEntity.ok(videos);
    }
}
