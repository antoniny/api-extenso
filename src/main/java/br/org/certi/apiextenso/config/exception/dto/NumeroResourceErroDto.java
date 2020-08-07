package br.org.certi.apiextenso.config.exception.dto;

public class NumeroResourceErroDto {
    private String message;
    private String error_message;

    public NumeroResourceErroDto(String message, String error_message) {
        this.message = message;
        this.error_message = error_message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }


}
