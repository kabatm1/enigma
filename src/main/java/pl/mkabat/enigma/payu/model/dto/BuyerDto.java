package pl.mkabat.enigma.payu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyerDto {

    @Email
    private String email;

    private String phone;

    private String firstName;

    private String lastName;

    private String language;

}
