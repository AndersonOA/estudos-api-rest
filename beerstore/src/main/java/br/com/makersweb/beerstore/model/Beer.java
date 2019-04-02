package br.com.makersweb.beerstore.model;

import br.com.makersweb.beerstore.model.enums.BeerType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author aaristides
 */
@Entity
@Table(name = "beer")
public class Beer {

    @Id
    @SequenceGenerator(name = "beer_seq", sequenceName = "beer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beer_seq")
    private Long id;

    private String name;
    private BeerType type;
    private BigDecimal volume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BeerType getType() {
        return type;
    }

    public void setType(BeerType type) {
        this.type = type;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return Objects.equals(id, beer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
