package es.erumo.poc.swagger.exception;

import java.util.HashMap;
import java.util.Map;

public class AnimalValidationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final Map<String, String> validationErrors = new HashMap<>();

  public AnimalValidationException(final String message) {
    super(message);
  }

  public Map<String, String> getErrors() {
    return this.validationErrors;
  }

  public AnimalValidationException error(final String title, final String error) {
    this.validationErrors.put(title, error);
    return this;
  }

}
