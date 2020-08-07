package br.org.certi.apiextenso.config.exception;

import br.org.certi.apiextenso.config.exception.dto.NumeroResourceErroDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroHandler  {

    @Autowired
    private MessageSource messageSource;


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<NumeroResourceErroDto> handle(MethodArgumentNotValidException exception){
        String mensagem = messageSource.getMessage(exception.getBindingResult().getFieldError(), LocaleContextHolder.getLocale());
        return new ResponseEntity(new NumeroResourceErroDto("Ocorreu uma falha no processamento.", mensagem),HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<NumeroResourceErroDto> handle(Exception exception){
        String mensagem = messageSource.getMessage(exception.getMessage(), null, LocaleContextHolder.getLocale());
        return new ResponseEntity(new NumeroResourceErroDto("Ocorreu uma falha no processamento.", mensagem),HttpStatus.BAD_REQUEST);
    }



}
