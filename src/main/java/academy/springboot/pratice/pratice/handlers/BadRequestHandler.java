package academy.springboot.pratice.pratice.handlers;

import academy.springboot.pratice.pratice.exceptions.BadRequestException;
import academy.springboot.pratice.pratice.exceptions.BadRequestExceptionDetails;
import academy.springboot.pratice.pratice.exceptions.ValidateExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class BadRequestHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> badRequestExceptionDetailsResponseEntity(BadRequestException bre){
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .title("Anime not found")
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .description(bre.getMessage())
                        .timeStamp(LocalDateTime.now())
                        .developerMessage(bre.getClass().getName()).build(), HttpStatus.BAD_REQUEST);
    }
    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidateExceptionDetails> handlerMethodArgumentNotValidException
            (MethodArgumentNotValidException exception){
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .title("Anime not found")
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .description(bre.getMessage())
                        .timeStamp(LocalDateTime.now())
                        .developerMessage(bre.getClass().getName()).build(), HttpStatus.BAD_REQUEST);
    }*/
}
