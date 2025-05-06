package test.projeto.excecoes;

import org.hibernate.validator.constraints.EAN;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LivroNotFoundException.class)
    private ResponseEntity<RestErrorMessage> livroNotFoundHandler(LivroNotFoundException livroNotFound){
        RestErrorMessage threatedResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR ,livroNotFound.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(threatedResponse);
    }

    @ExceptionHandler(AutorNotFoundException.class)
    private ResponseEntity<RestErrorMessage> autorNotFoundHandler(AutorNotFoundException exception){
        RestErrorMessage threatedResponse = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(threatedResponse);
    }
}
