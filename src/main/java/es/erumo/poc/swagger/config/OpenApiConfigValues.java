package es.erumo.poc.swagger.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ermoya
 *
 *         Variables obtenidas del archivo de propiedades para customizar la configuración por
 *         defecto de la interfaz de Swagger.
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "springdoc.custom-config")
public class OpenApiConfigValues {

  /** Agrupación de operaciones REST */
  private String group;
  /** Prefijo de las rutas que son tomadas en cuenta para la agrupación */
  private String pathMatch;
  /** Paquetes que contienen las clases incluidas en la documentación */
  private String packageScan;
  /** Titulo de la documentación */
  private String apiTitle;
  /** Descripción de la API */
  private String apiDescription;
  /** Correo electrónico de contacto */
  private String contactEmail;
  /** Versión de la API */
  private String version;
  /** Descripción/Titulo de la documentación externa */
  private String externalDocDesc;
  /** URL de la documentación externa */
  private String externalDocURL;

}
