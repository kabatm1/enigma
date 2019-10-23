package pl.mkabat.enigma.gps.mapper;

import org.mapstruct.Mapper;
import pl.mkabat.enigma.gps.model.Location;
import pl.mkabat.enigma.gps.model.dto.LocationDto;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    Location toEntity(LocationDto locationDto);

}
