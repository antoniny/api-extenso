package br.org.certi.apiextenso.service.dto;

import br.org.certi.apiextenso.model.Dezena;

import java.time.LocalDateTime;

public class DezenaDto {

    private Long id;
    private String name;
    private Double rangeMin;
    private Double rangeMax;
    private LocalDateTime createdDate;

    public DezenaDto() {
    }

    public DezenaDto(Dezena dezena) {
        this.id = dezena.getId();
        this.name = dezena.getName();
        this.rangeMin = dezena.getRangeMin();
        this.rangeMax = dezena.getRangeMax();
        this.createdDate = dezena.getCreatedDate();
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
