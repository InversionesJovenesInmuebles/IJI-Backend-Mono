package pe.edu.upao.InversionesJI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CorreoYaRegistradoException.class)
    public ResponseEntity<String> handleCorreoYaRegistradoException(CorreoYaRegistradoException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CorreoNoRegistradoException.class)
    public ResponseEntity<String> handleCorreoNoRegistradoException(CorreoNoRegistradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ContrasenaIncorrectaException.class)
    public ResponseEntity<String> handleContrasenaIncorrectaException(ContrasenaIncorrectaException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }
}