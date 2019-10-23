package pl.mkabat.enigma.payu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    @Size(max = 256)
    String name;

    @Digits(integer=10, fraction=2)
    BigDecimal unitPrice;

    @Positive
    Integer quantity;
}
