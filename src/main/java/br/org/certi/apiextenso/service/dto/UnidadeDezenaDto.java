package br.org.certi.apiextenso.service.dto;

import br.org.certi.apiextenso.model.UnidadeDezena;

import java.time.LocalDateTime;

public class UnidadeDezenaDto {

    private Long id;
    private String name;
    private Double rangeMin;
    private Double rangeMax;
    private LocalDateTime createdDate;

    public UnidadeDezenaDto() {
    }

    public UnidadeDezenaDto(UnidadeDezena unidadeDezena) {
        this.id = unidadeDezena.getId();
        this.name = unidadeDezena.getName();
        this.rangeMin = unidadeDezena.getRangeMin();
        this.rangeMax = unidadeDezena.getRangeMax();
        this.createdDate = unidadeDezena.getCreatedDate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getRangeMin() {
        return rangeMin;
    }

    public Double getRangeMax() {
        return rangeMax;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
