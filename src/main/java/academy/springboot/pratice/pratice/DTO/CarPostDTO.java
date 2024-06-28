package academy.springboot.pratice.pratice.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CarPostDTO {
    @NotEmpty(message = "The atribute cannot be empty.")
    private String name;
    @NotEmpty
    private double value;
}
