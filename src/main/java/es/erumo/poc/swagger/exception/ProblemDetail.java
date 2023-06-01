package es.erumo.poc.swagger.exception;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

public class ProblemDetail {

  private static final URI BLANK_TYPE = URI.create("about:blank");

  private URI type = BLANK_TYPE;

  @Nullable
  private String title;

  private int status;

  @Nullable
  private String detail;

  @Nullable
  private URI instance;

  @Nullable
  private Map<String, Object> properties;


  protected ProblemDetail(final int rawStatusCode) {
    this.status = rawStatusCode;
  }


  protected ProblemDetail(final ProblemDetail other) {
    this.type = other.type;
    this.title = other.title;
    this.status = other.status;
    this.detail = other.detail;
    this.instance = other.instance;
    this.properties = (other.properties != null ? new LinkedHashMap<>(other.properties) : null);
  }

  protected ProblemDetail() {}

  public void setType(final URI type) {
    Assert.notNull(type, "'type' is required");
    this.type = type;
  }

  public URI getType() {
    return this.type;
  }

  public void setTitle(@Nullable final String title) {
    this.title = title;
  }

  @Nullable
  public String getTitle() {
    if (this.title == null) {
      final HttpStatus httpStatus = HttpStatus.resolve(this.status);
      if (httpStatus != null) {
        return httpStatus.getReasonPhrase();
      }
    }
    return this.title;
  }

  public void setStatus(final HttpStatus httpStatus) {
    this.status = httpStatus.value();
  }

  public void setStatus(final int status) {
    this.status = status;
  }

  public int getStatus() {
    return this.status;
  }

  public void setDetail(@Nullable final String detail) {
    this.detail = detail;
  }

  @Nullable
  public String getDetail() {
    return this.detail;
  }

  public void setInstance(@Nullable final URI instance) {
    this.instance = instance;
  }

  @Nullable
  public URI getInstance() {
    return this.instance;
  }

  public void setProperty(final String name, final Object value) {
    this.properties = (this.properties != null ? this.properties : new LinkedHashMap<>());
    this.properties.put(name, value);
  }


  @Nullable
  public Map<String, Object> getProperties() {
    return this.properties;
  }

  @Override
  public boolean equals(@Nullable final Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof ProblemDetail)) {
      return false;
    }
    final ProblemDetail otherDetail = (ProblemDetail) other;
    return (this.type.equals(otherDetail.type) && ObjectUtils.nullSafeEquals(this.title, otherDetail.title)
        && (this.status == otherDetail.status) && ObjectUtils.nullSafeEquals(this.detail, otherDetail.detail)
        && ObjectUtils.nullSafeEquals(this.instance, otherDetail.instance)
        && ObjectUtils.nullSafeEquals(this.properties, otherDetail.properties));
  }

  @Override
  public int hashCode() {
    int result = this.type.hashCode();
    result = (31 * result) + ObjectUtils.nullSafeHashCode(this.title);
    result = (31 * result) + this.status;
    result = (31 * result) + ObjectUtils.nullSafeHashCode(this.detail);
    result = (31 * result) + ObjectUtils.nullSafeHashCode(this.instance);
    result = (31 * result) + ObjectUtils.nullSafeHashCode(this.properties);
    return result;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "[" + this.initToStringContent() + "]";
  }

  protected String initToStringContent() {
    return "type='" + this.getType() + "'" + ", title='" + this.getTitle() + "'" + ", status=" + this.getStatus()
        + ", detail='" + this.getDetail() + "'" + ", instance='" + this.getInstance() + "'" + ", properties='"
        + this.getProperties() + "'";
  }

  public static ProblemDetail forStatus(final HttpStatus status) {
    Assert.notNull(status, "HttpStatusCode is required");
    return forStatus(status.value());
  }

  public static ProblemDetail forStatus(final int status) {
    return new ProblemDetail(status);
  }

  public static ProblemDetail forStatusAndDetail(final HttpStatus status, final String detail) {
    Assert.notNull(status, "HttpStatusCode is required");
    final ProblemDetail problemDetail = forStatus(status.value());
    problemDetail.setDetail(detail);
    return problemDetail;
  }
}
