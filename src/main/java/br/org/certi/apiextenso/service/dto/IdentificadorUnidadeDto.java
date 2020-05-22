package br.org.certi.apiextenso.service.dto;

import br.org.certi.apiextenso.model.IdentificadorUnidade;

import java.time.LocalDateTime;

public class IdentificadorUnidadeDto {

    private Long id;
    private String name;
    private int rangeMin;
    private int rangeMax;
    private int separatorPoints;
    private LocalDateTime createdDate;

    public IdentificadorUnidadeDto() {
    }

    public IdentificadorUnidadeDto(IdentificadorUnidade identificadorUnidade) {
        this.id = identificadorUnidade.getId();
        this.name = identificadorUnidade.getName();
        this.rangeMin = identificadorUnidade.getRangeMin();
        this.rangeMax = identificadorUnidade.getRangeMax();
        this.separatorPoints = identificadorUnidade.getSeparatorPoints();
        this.createdDate = identificadorUnidade.getCreatedDate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRangeMin() {
        return rangeMin;
    }

    public int getRangeMax() {
        return rangeMax;
    }

    public int getSeparatorPoints() {
        return separatorPoints;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
