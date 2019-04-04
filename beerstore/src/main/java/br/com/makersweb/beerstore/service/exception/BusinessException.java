package br.com.makersweb.beerstore.service.exception;

import org.springframework.http.HttpStatus;

/**
 * @author aaristides
 */
public class BusinessException extends RuntimeException {

    private final String code;
    private final HttpStatus status;

    public BusinessException(String code, HttpStatus status) {
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
