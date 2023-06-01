package es.erumo.poc.swagger.exception;

import java.time.Instant;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(AnimalValidationException.class)
  ResponseEntity<Object> handleAnimalNotFoundException(final AnimalValidationException e, final WebRequest request) {

    final ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());

    problemDetail.setTitle("Animal validation not pass");
    problemDetail.setProperty("errors", e.getErrors());
    problemDetail.setProperty("timestamp", Instant.now());

    return this.handleException(e, problemDetail, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
  }

  private ResponseEntity<Object> handleException(final Exception ex, final ProblemDetail response,
      final HttpHeaders headers, final HttpStatus httpStatus, final WebRequest webRequest) {

    return this.handleExceptionInternal(ex, response, headers, httpStatus, webRequest);
  }


}
