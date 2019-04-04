package br.com.makersweb.beerstore.service.impl;

import br.com.makersweb.beerstore.model.Beer;
import br.com.makersweb.beerstore.repository.BeerRepository;
import br.com.makersweb.beerstore.service.IBeerService;
import br.com.makersweb.beerstore.service.exception.BeerAlreadyExistException;
import br.com.makersweb.beerstore.service.exception.BeerEmptyExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author aaristides
 */
@Service
public class BeerService implements IBeerService {

    private static final Logger LOG = LoggerFactory.getLogger(BeerService.class);

    private BeerRepository beerRepository;

    public BeerService(@Autowired BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public List<Beer> list() {
        LOG.info("Iniciou método list.");

        return beerRepository.findAll();
    }

    @Override
    public Beer save(final Beer beer) {
        LOG.info("Iniciou método save.");

        Optional<Beer> beerByNameAndType = beerRepository.findByNameAndType(beer.getName(), beer.getType());

        if (beerByNameAndType.isPresent()) {
            throw new BeerAlreadyExistException();
        }

        return beerRepository.save(beer);
    }

    @Override
    public Beer search(final Long id) {
        LOG.info("Iniciou método search.");

        Optional<Beer> beer = beerRepository.findById(id);

        if (!beer.isPresent()) {
            throw new BeerEmptyExistException();
        }

        return beer.get();
    }

    @Override
    public Beer update(final Beer beer) {
        LOG.info("Iniciou método update.");

        Beer beerSave = search(beer.getId());
        BeanUtils.copyProperties(beer, beerSave, "id");

        return beerRepository.save(beerSave);
    }

    @Override
    public void delete(final Long id) {
        LOG.info("Iniciou método delete.");

        try {
            beerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new BeerEmptyExistException();
        }
    }

}
