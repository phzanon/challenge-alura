package com.freemanpivo.chassi.web.api;

import com.freemanpivo.chassi.web.dto.CategorySaveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
@Slf4j
public class CategoryPostController {

    @PostMapping
    public ResponseEntity<String> save(@RequestBody CategorySaveDto dto) {

    }
}
