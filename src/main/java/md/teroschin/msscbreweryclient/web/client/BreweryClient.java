package md.teroschin.msscbreweryclient.web.client;

import lombok.Setter;
import md.teroschin.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";

    private final RestTemplate restTemplate;

    @Setter
    private String apiHost;

    public BreweryClient(final RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(final UUID beerId) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
    }

    public void updateBeer(final UUID beerId, final BeerDto beerDto) {
        restTemplate.put(apiHost + BEER_PATH_V1 + beerId.toString(), beerDto);
    }

    public URI saveNewBeer(final BeerDto beerDto) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
    }
}
