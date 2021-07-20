package com.freemanpivo.chassi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Video {

    private String id;
    private String titulo;
    private String descricao;
    private String url;

}
