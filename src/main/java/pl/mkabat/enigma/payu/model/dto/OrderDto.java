package pl.mkabat.enigma.payu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    String notifyUrl;

    String customerIp;

    Integer merchantPosId;

    String description;

    String currencyCode;

    @Digits(integer=10, fraction=2)
    BigDecimal totalAmount;

    BuyerDto buyer;

    List<ProductDto> products;

}
