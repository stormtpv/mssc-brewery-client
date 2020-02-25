package md.teroschin.msscbreweryclient.web.client;

import md.teroschin.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient breweryClient;

    @Test
    void testGetBeerById() {
        final BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void testUpdateBeer() {
        final BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testSaveNewBeer() {
        final BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        final URI uri = breweryClient.saveNewBeer(beerDto);

        assertNotNull(uri);
    }

    @Test
    void testDeleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}