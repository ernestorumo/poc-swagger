package es.erumo.poc.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "Animal Petición", description = "Modelo de petición del recurso animal",
    example = "{\"id\":\"1\",\"name\":\"cebra\"}")
public class AnimalRequest {

  public AnimalRequest(final Long id, final String name) {
    super();
    this.id = id;
    this.name = name;
  }

  @Schema(name = "id", description = "identificador del animal", example = "1")
  private Long id;

  @Schema(name = "name", description = "nombre del animal", example = "cebra")
  private String name;

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

  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * @param name the name to set
   */
  public void setName(final String name) {
    this.name = name;
  }
}
