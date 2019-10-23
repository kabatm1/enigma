package pl.mkabat.enigma.payu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mkabat.enigma.payu.model.dto.BuyerDto;
import pl.mkabat.enigma.payu.model.dto.OrderDto;
import pl.mkabat.enigma.client.PayuOrderClient;
import pl.mkabat.enigma.payu.model.dto.ProductDto;

import java.math.BigDecimal;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final PayuOrderClient payuOrderClient;

    @GetMapping(path = "/order/demo")
    public String createOrder() {
        return payuOrderClient.createOrder(createSampleOrder());
    }

    private OrderDto createSampleOrder() {
        return OrderDto.builder()
                       .notifyUrl("https://shop/notify")
                       .customerIp("127.0.0.1")
                       .merchantPosId(145227)
                       .description("RTV market")
                       .currencyCode("PLN")
                       .totalAmount(new BigDecimal(21000))
                       .buyer(BuyerDto.builder()
                                      .email("mail@mail.pl")
                                      .firstName("John")
                                      .lastName("Doe")
                                      .language("pl")
                                      .build())
                       .products(asList(ProductDto.builder()
                                                  .name("HDMI cable")
                                                  .quantity(21)
                                                  .unitPrice(new BigDecimal(1000))
                                                  .build()))
                       .build();
    }

}
