package br.org.certi.apiextenso.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("")
public class NumeroResourceDto {

    @ApiModelProperty(value = "Representação do número por extenso.",required = true)
    private String extenso;

    public NumeroResourceDto(String extenso) {
        this.extenso = extenso;
    }

    public String getExtenso() {
        return extenso;
    }
}
