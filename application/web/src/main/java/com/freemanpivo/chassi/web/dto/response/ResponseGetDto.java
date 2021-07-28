package com.freemanpivo.chassi.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideoGetWithCategoryIdDto {
    private Long id;
    private Long categoryId;
    private String titulo;
    private String descricao;
    private String url;
}
