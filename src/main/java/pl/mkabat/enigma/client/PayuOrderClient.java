package pl.mkabat.enigma.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.mkabat.enigma.payu.model.dto.OrderDto;

@RequiredArgsConstructor
@Component
public class PayuOrderClient {

    private static final String PAYU_ORDER_URL = "https://secure.payu.com/api/v2_1/orders";

    private final RestTemplate restTemplate;

    public String createOrder(OrderDto orderDto) {
        RestClient<OrderDto> restClient = new RestClient<>(restTemplate);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrderDto> httpEntity = new HttpEntity<>(orderDto, httpHeaders);
        return restClient.callPost(PAYU_ORDER_URL, httpEntity, new ParameterizedTypeReference<String>() {});
    }

}
