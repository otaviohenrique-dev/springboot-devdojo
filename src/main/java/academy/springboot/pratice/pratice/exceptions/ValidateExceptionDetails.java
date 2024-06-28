package academy.springboot.pratice.pratice.exceptions;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ValidateExceptionDetails extends ExceptionDetails {
    private final String fields;
    private final String filedsMessage;

}
