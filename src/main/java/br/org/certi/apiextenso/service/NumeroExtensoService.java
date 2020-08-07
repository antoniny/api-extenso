package br.org.certi.apiextenso.service;

import br.org.certi.apiextenso.config.i18n.TranslateConfig;
import br.org.certi.apiextenso.exception.NumberValidationException;
import br.org.certi.apiextenso.model.*;
import br.org.certi.apiextenso.repository.*;
import br.org.certi.apiextenso.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NumeroExtensoService {

    private final int NUMBER_MIN = -99999;
    private final int NUMBER_MAX = 99999;
    private final int PLACES_LENGTH = 3;
    private final int DIV_TEN  = 100;
    private final int DIV_UNIT_TEN = 100;
    private final int DIV_UNIT = 10;
    private String strMenos;
    private String strZero;
    private String strAnd;

    @Autowired
    UnidadeRepository unidadeRepository;
    @Autowired
    UnidadeDezenaRepository unidadeDezenaRepository;
    @Autowired
    DezenaRepository dezenaRepository;
    @Autowired
    CentenaRepository centenaRepository;
    @Autowired
    IdentificadorUnidadeRepository identificadorUnidadeRepository;
    @Autowired
    TranslateConfig translateConfig;

    public NumeroResourceDto getNumberWords(Integer number) throws NumberValidationException {
        return new NumeroResourceDto(convertNumberWords(number));
    }

    private String convertNumberWords(Integer number) throws NumberValidationException {
        String returnNumberWords = "";
        validateNumber(number);

        boolean isNumberNegative = (number < 0);
        boolean isNumberZero = number.equals(0);
        number = Math.abs(number);

        IdentificadorUnidadeDto identificadorUnidadeDto = getIdentificadorUnidade(String.valueOf(number).length());
        for (int identified = 0 ; identified < identificadorUnidadeDto.getSeparatorPoints() ; identified++ ){
            String numberStr = String.valueOf(number);
            int pos_begin = (numberStr.length() < PLACES_LENGTH) ? 0 : numberStr.length() - ( PLACES_LENGTH *  (identified+1) );
            int pos_end   = (numberStr.length() < PLACES_LENGTH) ? numberStr.length() : numberStr.length() - ( PLACES_LENGTH * identified );

            numberStr = numberStr.substring(Math.max(pos_begin, 0), pos_end);

            CentenaDto centenaDto = getCentena( Double .parseDouble(numberStr) );
            DezenaDto dezenaDto   = getDezena(getCalcNumber(Double.parseDouble(numberStr), DIV_TEN));
            UnidadeDezenaDto unidadeDezenaDto = getUnidadeDezena(getCalcNumber(Double.parseDouble(numberStr), DIV_UNIT_TEN));
            UnidadeDto unidadeDto = getUnidade(getCalcNumber(Double.parseDouble(numberStr), DIV_UNIT));

            String strNumberToWords = getNumberToWords((identified==0)?"":identificadorUnidadeDto.getName(),
                                                centenaDto.getName() ,
                                                dezenaDto.getName() ,
                                                unidadeDezenaDto.getName(),
                                                unidadeDto.getName()
            );
            returnNumberWords = ( (returnNumberWords.isEmpty()) ? strNumberToWords : (strNumberToWords + strAnd) ) + returnNumberWords;
        }


        return (isNumberZero)?strZero:((isNumberNegative)?strMenos:"" ) + returnNumberWords.trim();
    }

    private Double getCalcNumber(Double number, int div_ref) {
        double x = ( number / div_ref );
        double y = Math.floor( number / div_ref ) ;
        double result = (x - y) * div_ref;

        result = Math.round(result * 100);
        result = result/100;

        return  result;
    }

    private UnidadeDto getUnidade(Double number) {
        Optional<Unidade> optionalUnidade = unidadeRepository.findByParameterBetweenRangeMinAndRangeMax(number);
        return optionalUnidade.map(UnidadeDto::new).orElseGet(UnidadeDto::new);
    }

    private UnidadeDezenaDto getUnidadeDezena(Double number) {
        Optional<UnidadeDezena> optionalUnidadeDezena = unidadeDezenaRepository.findByParameterBetweenRangeMinAndRangeMax(number);
        return optionalUnidadeDezena.map(UnidadeDezenaDto::new).orElseGet(UnidadeDezenaDto::new);
    }

    private DezenaDto getDezena(Double number) {
        Optional<Dezena> optionalDezena = dezenaRepository.findByParameterBetweenRangeMinAndRangeMax(number);
        return optionalDezena.map(DezenaDto::new).orElseGet(DezenaDto::new);
    }

    private CentenaDto getCentena(Double number) {
        Optional<Centena> optionalCentena = centenaRepository.findByParameterBetweenRangeMinAndRangeMax(number);
        return optionalCentena.map(CentenaDto::new).orElseGet(CentenaDto::new);
    }

    private IdentificadorUnidadeDto getIdentificadorUnidade(int numberDigits) {
        Optional<IdentificadorUnidade> optionalIdentificadorUnidade = identificadorUnidadeRepository.findByRangeMinIsGreaterThanEqualAndRangeMaxLessThanEqual(numberDigits,numberDigits);
        return optionalIdentificadorUnidade.map(IdentificadorUnidadeDto::new).orElseGet(IdentificadorUnidadeDto::new);
    }

    private void validateNumber(Integer number) throws NumberValidationException {
        if ((number == null)||(number < NUMBER_MIN)||(number > NUMBER_MAX)){
            throw new NumberValidationException("Argumento inválido! [-99999/99999] ");
        }
        strMenos = translateConfig.resolveCode("menos", LocaleContextHolder.getLocale()) + " ";
        strZero = translateConfig.resolveCode("zero", LocaleContextHolder.getLocale());
        strAnd  = " " + translateConfig.resolveCode("e", LocaleContextHolder.getLocale())+ " ";

    }

    private String getNumberToWords(String nameThousand,String nameHundred, String nameTen, String nameTenUnit, String nameUnit) {
        String valueReturn = "";
        nameThousand    = (nameThousand == null) ? "" : translateConfig.resolveCode(nameThousand, LocaleContextHolder.getLocale());
        nameHundred     = (nameHundred  == null) ? "" : translateConfig.resolveCode(nameHundred, LocaleContextHolder.getLocale());
        nameTen         = (nameTen      == null) ? "" : translateConfig.resolveCode(nameTen, LocaleContextHolder.getLocale());
        nameTenUnit     = (nameTenUnit  == null) ? "" : translateConfig.resolveCode(nameTenUnit, LocaleContextHolder.getLocale());
        nameUnit        = (nameUnit     == null) ? "" : translateConfig.resolveCode(nameUnit, LocaleContextHolder.getLocale());

        if ( nameTenUnit.isEmpty() && !nameUnit.isEmpty() ) {
            valueReturn = nameUnit;
        }

        if (!nameTenUnit.isEmpty()) {
            valueReturn = (valueReturn.isEmpty()) ?  nameTenUnit : nameTenUnit + strAnd + valueReturn;
        }

        if (!nameTen.isEmpty()){
            valueReturn = (valueReturn.isEmpty()) ?  nameTen : nameTen + strAnd + valueReturn;
        }

        if (!nameHundred.isEmpty()){
            valueReturn = (valueReturn.isEmpty()) ?  nameHundred : nameHundred + strAnd + valueReturn;
        }

        if (!nameThousand.isEmpty() && valueReturn.equals("um")) {
            valueReturn = "";
        }

        if (!nameThousand.isEmpty()) {
            valueReturn = (valueReturn.isEmpty()) ?  nameThousand : valueReturn + " " + nameThousand;
        }

        return  valueReturn;
    }
}
