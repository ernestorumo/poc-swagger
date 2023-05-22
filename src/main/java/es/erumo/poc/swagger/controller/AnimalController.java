package es.erumo.poc.swagger.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.erumo.poc.swagger.model.AnimalRequest;
import es.erumo.poc.swagger.model.AnimalResponse;

/**
 * @author ermoya
 *
 *         Controlador, el cual debe de ir correctamente anotado para que springdoc pueda escanear
 *         los recursos.
 */
@RestController
// Importante definir un prefijo de "api" y "versionado" en las URLs de los recursos
@RequestMapping("/api/v1")
public class AnimalController implements AnimalOperation {

  @Override
  @GetMapping(value = "/animales/{id}", produces = "application/json")
  public ResponseEntity<AnimalResponse> getAnimalById(@PathVariable("id") final Long id) {

    return ResponseEntity.ok(new AnimalResponse(id, "tigreds"));

  }

  @Override
  // No olvidar incluir la cabecera "Content-Type:application/json" al consumir esta operación con un
  // cliente
  @PostMapping(value = "/animales", produces = {"application/json"}, consumes = {"application/json"})
  public ResponseEntity<AnimalResponse> createAnimal(@RequestBody final AnimalRequest animalRequest) {

    final AnimalResponse animalResponse = new AnimalResponse(animalRequest.getId(), animalRequest.getName());

    // Es una buena práctica añadir en la cabecera la localización del recurso creado
    final URI location = linkTo(methodOn(this.getClass()).getAnimalById(animalResponse.getId())).toUri();

    return ResponseEntity.created(location).body(animalResponse);
  }

}
