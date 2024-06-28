package academy.springboot.pratice.pratice.controllers;

import academy.springboot.pratice.pratice.DTO.CarPostDTO;
import academy.springboot.pratice.pratice.DTO.CarPutDTO;
import academy.springboot.pratice.pratice.domain.Car;
import academy.springboot.pratice.pratice.services.CarServices;
import academy.springboot.pratice.pratice.util.DateUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("cars")
@Log4j2
@AllArgsConstructor
public class CarController {
    private DateUtil dateUtil;
    private final CarServices carServices;

    @GetMapping
    public List<Car> listAll() {
        return carServices.listAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> getById(@PathVariable Long id){
        return new ResponseEntity<>(carServices.getById(id), HttpStatus.OK);

    }
    @GetMapping(path = "/find")
    public ResponseEntity<List<Car>> findByName(@RequestParam String name){
        return new ResponseEntity<>(carServices.listByName(name), HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity save(@RequestBody @Valid CarPostDTO car){
        return new ResponseEntity<>(carServices.save(car), HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        carServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody CarPutDTO car){
        carServices.replace(car);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
