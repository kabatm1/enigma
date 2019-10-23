package pl.mkabat.enigma.gps.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mkabat.enigma.gps.model.dto.LocationDto;
import pl.mkabat.enigma.gps.service.LocationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping(path = "/location")
    public void saveDeviceLocation(@RequestBody @Valid LocationDto locationDto) {
        locationService.saveLocation(locationDto);
    }

}
