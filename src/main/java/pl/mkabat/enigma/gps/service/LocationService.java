package pl.mkabat.enigma.gps.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mkabat.enigma.gps.mapper.LocationMapper;
import pl.mkabat.enigma.gps.model.dto.LocationDto;
import pl.mkabat.enigma.gps.repository.LocationRepository;

@RequiredArgsConstructor
@Service
public class LocationService {

    private final LocationRepository locationRepository;

    private final LocationMapper locationMapper;

    @Transactional
    public void saveLocation(LocationDto locationDto) {
        //we dont have unique deviceId, we insert records each time locations is called,
        //this creates much more data, but make write operation super fast.
        //other scenario is making deviceId unique, then search and if found compare hashcodes (etags),
        //if anything has changed then save. The write scenario depends on how are we going to use this data
        locationRepository.save(locationMapper.toEntity(locationDto));
    }

}
