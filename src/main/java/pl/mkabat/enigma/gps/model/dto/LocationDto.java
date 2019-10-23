package pl.mkabat.enigma.gps.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDto {

    @NotNull
    Long deviceId;

    @NotNull
    Long latitude;

    @NotNull
    Long longitude;

}
