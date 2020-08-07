package br.org.certi.apiextenso.service.dto;

import br.org.certi.apiextenso.model.Centena;

import java.time.LocalDateTime;

public class CentenaDto {

    private Long id;
    private String name;
    private Double rangeMin;
    private Double rangeMax;
    private LocalDateTime createdDate;

    public CentenaDto(){};

    public CentenaDto(Centena centena) {
        this.id = centena.getId();
        this.name = centena.getName();
        this.rangeMin = centena.getRangeMin();
        this.rangeMax = centena.getRangeMax();
        this.createdDate = centena.getCreatedDate();
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
