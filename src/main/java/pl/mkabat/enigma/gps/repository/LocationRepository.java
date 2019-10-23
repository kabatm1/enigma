package pl.mkabat.enigma.gps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mkabat.enigma.gps.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
