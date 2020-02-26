package md.teroschin.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import md.teroschin.msscbreweryclient.web.model.CustomerDto;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;

    @Test
    void getCustomerById() {
        final CustomerDto customer = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customer);
    }

    @Test
    void createCustomer() {
        final CustomerDto customer = CustomerDto.builder().name("New Customer").build();

        final URI result = customerClient.createCustomer(customer);

        assertNotNull(result);
    }

    @Test
    void updateCustomerById() {
        final CustomerDto customer = CustomerDto.builder().name("New Customer").build();

        customerClient.updateCustomerById(UUID.randomUUID(), customer);
    }

    @Test
    void deleteCustomerById() {
        customerClient.deleteCustomerById(UUID.randomUUID());
    }
}