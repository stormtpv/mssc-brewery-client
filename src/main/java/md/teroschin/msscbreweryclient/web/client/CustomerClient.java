package md.teroschin.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;
import md.teroschin.msscbreweryclient.web.model.CustomerDto;

@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/customer/api/v1/";

    private final RestTemplate restTemplate;

    public CustomerClient(final RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Setter
    private String apiHost;

    public CustomerDto getCustomerById(final UUID customerId) {
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + customerId, CustomerDto.class);
    }

    public URI createCustomer(final CustomerDto customerDto) {
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomerById(final UUID customerId, final CustomerDto customerDto) {
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + customerId, customerDto);
    }

    public void deleteCustomerById(final UUID customerId) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + customerId);
    }
}
