package es.erumo.poc.swagger.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author ermoya
 *
 *         Variables obtenidas del archivo de propiedades para customizar la configuración por
 *         defecto de la interfaz de Swagger.
 */
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

  /**
   * @return the group
   */
  public String getGroup() {
    return this.group;
  }

  /**
   * @return the pathMatch
   */
  public String getPathMatch() {
    return this.pathMatch;
  }

  /**
   * @return the packageScan
   */
  public String getPackageScan() {
    return this.packageScan;
  }

  /**
   * @return the apiTitle
   */
  public String getApiTitle() {
    return this.apiTitle;
  }

  /**
   * @return the apiDescription
   */
  public String getApiDescription() {
    return this.apiDescription;
  }

  /**
   * @return the contactEmail
   */
  public String getContactEmail() {
    return this.contactEmail;
  }

  /**
   * @return the version
   */
  public String getVersion() {
    return this.version;
  }

  /**
   * @return the externalDocDesc
   */
  public String getExternalDocDesc() {
    return this.externalDocDesc;
  }

  /**
   * @return the externalDocURL
   */
  public String getExternalDocURL() {
    return this.externalDocURL;
  }

  /**
   * @param group the group to set
   */
  public void setGroup(final String group) {
    this.group = group;
  }

  /**
   * @param pathMatch the pathMatch to set
   */
  public void setPathMatch(final String pathMatch) {
    this.pathMatch = pathMatch;
  }

  /**
   * @param packageScan the packageScan to set
   */
  public void setPackageScan(final String packageScan) {
    this.packageScan = packageScan;
  }

  /**
   * @param apiTitle the apiTitle to set
   */
  public void setApiTitle(final String apiTitle) {
    this.apiTitle = apiTitle;
  }

  /**
   * @param apiDescription the apiDescription to set
   */
  public void setApiDescription(final String apiDescription) {
    this.apiDescription = apiDescription;
  }

  /**
   * @param contactEmail the contactEmail to set
   */
  public void setContactEmail(final String contactEmail) {
    this.contactEmail = contactEmail;
  }

  /**
   * @param version the version to set
   */
  public void setVersion(final String version) {
    this.version = version;
  }

  /**
   * @param externalDocDesc the externalDocDesc to set
   */
  public void setExternalDocDesc(final String externalDocDesc) {
    this.externalDocDesc = externalDocDesc;
  }

  /**
   * @param externalDocURL the externalDocURL to set
   */
  public void setExternalDocURL(final String externalDocURL) {
    this.externalDocURL = externalDocURL;
  }

}
