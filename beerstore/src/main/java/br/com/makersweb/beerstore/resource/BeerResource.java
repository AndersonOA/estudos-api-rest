package br.com.makersweb.beerstore.resource;

import br.com.makersweb.beerstore.model.Beer;
import br.com.makersweb.beerstore.resource.constants.ResourceApiConstants;
import br.com.makersweb.beerstore.service.IBeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author aaristides
 */
@RestController
@RequestMapping(value = ResourceApiConstants.Api.Page.BeerResource)
public class BeerResource {

    @Autowired
    private IBeerService beerService;

    @GetMapping
    public ResponseEntity<List<Beer>> list() {
        return ResponseEntity.ok(beerService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beer> get(@PathVariable Long id) {
        return ResponseEntity.ok(beerService.search(id));
    }

}
