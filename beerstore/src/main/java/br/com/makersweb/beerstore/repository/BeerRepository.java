package br.com.makersweb.beerstore.repository;

import br.com.makersweb.beerstore.model.Beer;
import br.com.makersweb.beerstore.model.enums.BeerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author aaristides
 */
public interface BeerRepository extends JpaRepository<Beer, Long> {

    Optional<Beer> findByNameAndType(String name, BeerType type);

}
