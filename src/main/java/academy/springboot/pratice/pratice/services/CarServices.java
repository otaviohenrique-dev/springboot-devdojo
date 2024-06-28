package academy.springboot.pratice.pratice.services;

import academy.springboot.pratice.pratice.DTO.CarPostDTO;
import academy.springboot.pratice.pratice.DTO.CarPutDTO;
import academy.springboot.pratice.pratice.domain.Car;
import academy.springboot.pratice.pratice.exceptions.BadRequestException;
import academy.springboot.pratice.pratice.mapper.CarMapper;
import academy.springboot.pratice.pratice.repository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServices {
    private CarRepository carRepository;

    public List<Car> listAll() {
        return carRepository.findAll();
    }

    public List<Car> listByName(String name) {

        return carRepository.findByName(name);
    }

    public Car getById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Car not found!"));
    }
    @Transactional
    public Car save(CarPostDTO car) {
        return carRepository.save(CarMapper.INSTANCE.toCar(car));
    }

    public void delete(Long id) {
        carRepository.delete(getById(id));
    }

    public void replace(CarPutDTO car) {
        delete(car.getId());
        Car carSaved = CarMapper.INSTANCE.toCar(car);
        carRepository.save(carSaved);
    }
}
