package es.erumo.poc.swagger.controller;

import org.springframework.http.ResponseEntity;
import es.erumo.poc.swagger.model.AnimalRequest;
import es.erumo.poc.swagger.model.AnimalResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


/**
 * @author ermoya
 *
 *         Toda la parte de documentación de la API debe de ir en esta interfaz y no mezclase en el
 *         controlador
 */
@Tag(name = "Animales", description = "Recurso animales")
public interface AnimalOperation {

  @Operation(tags = {"Animales"}, summary = "Obtiene un animal", operationId = "getAnimalById",
      description = "Devuelve toda la información de una animal proporcionando su identificador",
      responses = {
          @ApiResponse(responseCode = "200", description = "ok",
              content = @Content(schema = @Schema(implementation = AnimalResponse.class))),
          @ApiResponse(responseCode = "400", description = "Bad Request",
              content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
          @ApiResponse(responseCode = "401", description = "Unauthorized",
              content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
          @ApiResponse(responseCode = "403", description = "Forbidden",
              content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
          @ApiResponse(responseCode = "404", description = "Entry not found",
              content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
  ResponseEntity<AnimalResponse> getAnimalById(
      @Parameter(name = "id", required = true, description = "Identificador el animal",
          schema = @Schema(implementation = Long.class), in = ParameterIn.PATH) Long id);

  @Operation(tags = {"Animales"}, summary = "Crea un animal", operationId = "createAnimal",
      description = "Crea un animal a partir de la información proporcionada en la petición",
      responses = {
          @ApiResponse(responseCode = "201", description = "created",
              content = @Content(schema = @Schema(implementation = AnimalResponse.class))),
          @ApiResponse(responseCode = "400", description = "Bad Request",
              content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
          @ApiResponse(responseCode = "403", description = "Forbidden",
              content = @Content(schema = @Schema(implementation = ResponseEntity.class)))})
  ResponseEntity<AnimalResponse> createAnimal(@RequestBody(description = "Datos de la aplicación a crear",
      required = true, content = @Content(schema = @Schema(implementation = AnimalRequest.class,
          example = "{\"id\": \"1\", \"nombre\":\"tigre\"}"))) AnimalRequest animal);

}
