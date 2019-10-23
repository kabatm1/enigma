package pl.mkabat.enigma.gps.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mkabat.enigma.gps.model.dto.LocationDto;
import pl.mkabat.enigma.gps.repository.LocationRepository;

@RequiredArgsConstructor
@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public void saveLocation(LocationDto locationDto) {
        //TODO implement
    }

}
