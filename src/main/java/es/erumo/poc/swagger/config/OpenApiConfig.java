package es.erumo.poc.swagger.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * @author ermoya
 *
 *         Configuración de la documentación de la API
 */
@Configuration
public class OpenApiConfig {

  /** Valores de las propieades de customización de la documentación */
  @Autowired
  OpenApiConfigValues config;

// @formatter:off
  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder()
        .group(this.config.getGroup())
        .pathsToMatch(this.config.getPathMatch())
        .packagesToScan(this.config.getPackageScan())
        .build();
  }

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title(this.config.getApiTitle())
            .description(this.config.getApiDescription())
            .version(this.config.getVersion())
            .contact(new Contact().email(this.config.getContactEmail()))
            .license(new License()
                .name("Apache 2.0")
                .url("http://www.apache.org/licenses/LICENSE-2.0.html")))
        .externalDocs(new ExternalDocumentation()
            .description(this.config.getExternalDocDesc())
            .url(this.config.getExternalDocURL()));
  }
//@formatter:on
}
