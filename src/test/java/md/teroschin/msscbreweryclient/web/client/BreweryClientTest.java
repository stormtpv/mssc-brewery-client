package md.teroschin.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import md.teroschin.msscbreweryclient.web.model.BeerDto;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient breweryClient;

    @Test
    void getBeerById() {
        final BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {
        final BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        final URI uri = breweryClient.saveNewBeer(beerDto);

        assertNotNull(uri);
    }
}