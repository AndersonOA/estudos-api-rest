package br.com.makersweb.beerstore.service;

import br.com.makersweb.beerstore.model.Beer;

import java.util.List;

/**
 * @author aaristides
 */
public interface IBeerService {

    List<Beer> list();

    Beer save(final Beer beer);

    Beer search(final Long id);

    Beer update(final Beer beer);

    void delete(final Long id);

}
