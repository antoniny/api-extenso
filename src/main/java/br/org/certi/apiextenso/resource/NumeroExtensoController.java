package br.org.certi.apiextenso.resource;

import br.org.certi.apiextenso.service.NumeroExtensoService;
import br.org.certi.apiextenso.service.dto.NumeroResourceDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Extenso", tags = {"Extenso"},description = "Números por Extenso")
@RestController("number-words")
@RequestMapping("extenso")
public class NumeroExtensoController {

    @Autowired
    NumeroExtensoService numeroExtensoService;

    @ApiOperation(value = "Retorna a representação do número por extenso.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna o número por extenso"),
            @ApiResponse(code = 400, message = "Ocorreu um problema com sua requisição"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping(value = "/v1/{number}" , produces = "application/json")
    public ResponseEntity<NumeroResourceDto> getNumberWords(@PathVariable Integer number){
        return new ResponseEntity(numeroExtensoService.getNumberWords(number), HttpStatus.OK);
    }

}
