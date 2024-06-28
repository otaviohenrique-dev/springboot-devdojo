package academy.springboot.pratice.pratice.exceptions;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {
    protected String title;
    protected int statusCode;
    protected String developerMessage;
    protected LocalDateTime timeStamp;
    protected String description;
}
