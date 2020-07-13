package org.payid.client.model.problems;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.StatusType;
import org.zalando.problem.ThrowableProblem;

import java.net.URI;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

public abstract class AbstractPayIdClientProblem extends AbstractThrowableProblem {

  // Use a sub-domain to avoid accidentally DOSing the root domain.
  public static final String TYPE_PREFIX = "https://errors.payid.org";

  protected AbstractPayIdClientProblem() {
    super();
  }

  protected AbstractPayIdClientProblem(@Nullable URI type) {
    super(type);
  }

  protected AbstractPayIdClientProblem(@Nullable URI type, @Nullable String title) {
    super(type, title);
  }

  protected AbstractPayIdClientProblem(@Nullable URI type, @Nullable String title, @Nullable StatusType status) {
    super(type, title, status);
  }

  protected AbstractPayIdClientProblem(
    @Nullable URI type, @Nullable String title, @Nullable StatusType status, @Nullable String detail) {
    super(type, title, status, detail);
  }

  protected AbstractPayIdClientProblem(
    @Nullable URI type,
    @Nullable String title, @Nullable StatusType status, @Nullable String detail, @Nullable URI instance) {
    super(type, title, status, detail, instance);
  }

  protected AbstractPayIdClientProblem(
    @Nullable URI type,
    @Nullable String title,
    @Nullable StatusType status, @Nullable String detail, @Nullable URI instance, @Nullable ThrowableProblem cause) {
    super(type, title, status, detail, instance, cause);
  }

  protected AbstractPayIdClientProblem(
    @Nullable URI type,
    @Nullable String title,
    @Nullable StatusType status,
    @Nullable String detail,
    @Nullable URI instance, @Nullable ThrowableProblem cause, @Nullable Map<String, Object> parameters) {
    super(type, title, status, detail, instance, cause, parameters);
  }

  /**
   * For jackson serialization. Overrides how the "status" property is written. Should be a raw number, and not a quoted
   * number. Visibility is protected because it's only for jackson and other clients should not need to see this
   * method.
   *
   * @return http status or null if not set
   */
  @JsonProperty("status")
  @JsonRawValue
  protected Integer getStatusCode() {
    return Optional.ofNullable(super.getStatus()).map(StatusType::getStatusCode).orElse(null);
  }

}
