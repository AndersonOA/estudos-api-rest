package br.com.makersweb.beerstore.repository;

import br.com.makersweb.beerstore.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author aaristides
 */
public interface BeerRepository extends JpaRepository<Beer, Long> {

}
