package academy.springboot.pratice.pratice.DTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CarPutDTO {
    @NotEmpty
    private  Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private double value;
}
