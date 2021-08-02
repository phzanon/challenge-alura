package com.freemanpivo.chassi.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseSaveVideo {

    private String id;
    private String titulo;
    private String descricao;
    private String url;
    private String categoryId;
}
