package academy.springboot.pratice.pratice.repository;
import academy.springboot.pratice.pratice.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByName(String name);

}
