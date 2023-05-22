package es.erumo.poc.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Animal Respuesta", description = "Modelo de respuesta del recurso animal",
    example = "{\"id\":\"1\",\"name\":\"cebra\"}")
public class AnimalResponse {

  public AnimalResponse(final Long id, final String name) {
    super();
    this.id = id;
    this.name = name;
  }

  @Schema(name = "id", description = "identificador del animal", example = "1")
  private final Long id;

  @Schema(name = "name", description = "nombre del animal", example = "cebra")
  private final String name;

  /**
   * @return the id
   */
  public Long getId() {
    return this.id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return this.name;
  }

}
