package br.com.makersweb.beerstore.resource.constants;

/**
 * @author aaristides
 */
public interface ResourceApiConstants {

    interface Api {

        interface Page {

            String _Version = "v1";
            String _Prefix = "/api/" + _Version;

            String BeerResource = _Prefix + "/beers";

        }

    }

}
