package br.com.makersweb.beerstore.service.exception;

import org.springframework.http.HttpStatus;

/**
 * @author aaristides
 */
public class BeerAlreadyExistException extends BusinessException {

    public BeerAlreadyExistException() {
        super("beers-5", HttpStatus.BAD_REQUEST);
    }

}
