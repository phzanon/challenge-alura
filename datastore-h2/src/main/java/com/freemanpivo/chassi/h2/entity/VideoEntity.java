package com.freemanpivo.chassi.h2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "VIDEO")
public class VideoEntity {
    @Id
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private String id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "url", nullable = false)
    private String url;
}
