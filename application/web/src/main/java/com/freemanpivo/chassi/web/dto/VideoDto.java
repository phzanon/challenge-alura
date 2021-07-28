package com.freemanpivo.chassi.web.dto;

import com.freemanpivo.chassi.domain.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideoDto {
	private String id;
	private String titulo;
	private String descricao;
	private String url;
	private Category category;
}
