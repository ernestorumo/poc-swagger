package es.erumo.poc.swagger.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "Animal Respuesta", description = "Modelo de respuesta del recurso animal",
    example = "{\"id\":\"1\",\"name\":\"cebra\"}")
public class AnimalResponse {

  @Schema(name = "id", description = "identificador del animal", example = "1")
  private Long id;

  @Schema(name = "name", description = "nombre del animal", example = "cebra")
  private String name;
}
