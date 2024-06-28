package academy.springboot.pratice.pratice.mapper;

import academy.springboot.pratice.pratice.DTO.CarPostDTO;
import academy.springboot.pratice.pratice.DTO.CarPutDTO;
import academy.springboot.pratice.pratice.domain.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CarMapper {
    public final static CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    public abstract Car toCar(CarPostDTO carPostDTO);
    public abstract Car toCar(CarPutDTO carPutDTO);
}
