package br.org.certi.apiextenso.service.dto;

import br.org.certi.apiextenso.model.Unidade;

import java.time.LocalDateTime;

public class UnidadeDto {

    private Long id;
    private String name;
    private Double rangeMin;
    private Double rangeMax;
    private LocalDateTime createdDate;

    public UnidadeDto() {
    }

    public UnidadeDto(Unidade unidade) {
        this.id = unidade.getId();
        this.name = unidade.getName();
        this.rangeMin = unidade.getRangeMin();
        this.rangeMax = unidade.getRangeMax();
        this.createdDate = unidade.getCreatedDate();
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
