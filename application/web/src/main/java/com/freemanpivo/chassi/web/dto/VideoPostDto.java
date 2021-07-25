package com.freemanpivo.chassi.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideoPostDto {
    private String titulo;
    private String descricao;
    private String url;
}
