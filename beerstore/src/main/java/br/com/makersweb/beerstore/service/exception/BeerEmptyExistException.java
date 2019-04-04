package br.com.makersweb.beerstore.service.exception;

import org.springframework.http.HttpStatus;

/**
 * @author aaristides
 */
public class BeerEmptyExistException extends BusinessException {

    public BeerEmptyExistException() {
        super("beers-6", HttpStatus.BAD_REQUEST);
    }
}
