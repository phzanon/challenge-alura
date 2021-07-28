package com.freemanpivo.chassi.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseGetDto {
    private Long id;
    private Long categoryId;
    private String titulo;
    private String descricao;
    private String url;
}
