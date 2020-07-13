package org.payid.client.model.discovery;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import okhttp3.HttpUrl;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePayIdDiscoveryLink.builder()}.
 */
@Generated(from = "PayIdDiscoveryLink.AbstractPayIdDiscoveryLink", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutablePayIdDiscoveryLink
    extends PayIdDiscoveryLink.AbstractPayIdDiscoveryLink {
  private final HttpUrl rel;
  private final @Nullable HttpUrl href;
  private final @Nullable String template;

  private ImmutablePayIdDiscoveryLink(
      HttpUrl rel,
      @Nullable HttpUrl href,
      @Nullable String template) {
    this.rel = rel;
    this.href = href;
    this.template = template;
  }

  /**
   * @return The value of the {@code rel} attribute
   */
  @JsonProperty("rel")
  @Override
  public HttpUrl rel() {
    return rel;
  }

  /**
   * @return The value of the {@code href} attribute
   */
  @JsonProperty("href")
  @Override
  public Optional<HttpUrl> href() {
    return Optional.ofNullable(href);
  }

  /**
   * @return The value of the {@code template} attribute
   */
  @JsonProperty("template")
  @Override
  public Optional<String> template() {
    return Optional.ofNullable(template);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#rel() rel} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for rel
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePayIdDiscoveryLink withRel(HttpUrl value) {
    if (this.rel == value) return this;
    HttpUrl newValue = Objects.requireNonNull(value, "rel");
    return validate(new ImmutablePayIdDiscoveryLink(newValue, this.href, this.template));
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#href() href} attribute.
   * @param value The value for href
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePayIdDiscoveryLink withHref(HttpUrl value) {
    @Nullable HttpUrl newValue = Objects.requireNonNull(value, "href");
    if (this.href == newValue) return this;
    return validate(new ImmutablePayIdDiscoveryLink(this.rel, newValue, this.template));
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#href() href} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for href
   * @return A modified copy of {@code this} object
   */
  @SuppressWarnings("unchecked") // safe covariant cast
  public final ImmutablePayIdDiscoveryLink withHref(Optional<? extends HttpUrl> optional) {
    @Nullable HttpUrl value = optional.orElse(null);
    if (this.href == value) return this;
    return validate(new ImmutablePayIdDiscoveryLink(this.rel, value, this.template));
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#template() template} attribute.
   * @param value The value for template
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePayIdDiscoveryLink withTemplate(String value) {
    @Nullable String newValue = Objects.requireNonNull(value, "template");
    if (Objects.equals(this.template, newValue)) return this;
    return validate(new ImmutablePayIdDiscoveryLink(this.rel, this.href, newValue));
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#template() template} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for template
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePayIdDiscoveryLink withTemplate(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equals(this.template, value)) return this;
    return validate(new ImmutablePayIdDiscoveryLink(this.rel, this.href, value));
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePayIdDiscoveryLink} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePayIdDiscoveryLink
        && equalTo((ImmutablePayIdDiscoveryLink) another);
  }

  private boolean equalTo(ImmutablePayIdDiscoveryLink another) {
    return rel.equals(another.rel)
        && Objects.equals(href, another.href)
        && Objects.equals(template, another.template);
  }

  /**
   * Computes a hash code from attributes: {@code rel}, {@code href}, {@code template}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + rel.hashCode();
    h += (h << 5) + Objects.hashCode(href);
    h += (h << 5) + Objects.hashCode(template);
    return h;
  }

  /**
   * Prints the immutable value {@code PayIdDiscoveryLink} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("PayIdDiscoveryLink")
        .omitNullValues()
        .add("rel", rel)
        .add("href", href)
        .add("template", template)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PayIdDiscoveryLink.AbstractPayIdDiscoveryLink", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      extends PayIdDiscoveryLink.AbstractPayIdDiscoveryLink {
    @Nullable HttpUrl rel;
    @Nullable Optional<HttpUrl> href = Optional.empty();
    @Nullable Optional<String> template = Optional.empty();
    @JsonProperty("rel")
    public void setRel(HttpUrl rel) {
      this.rel = rel;
    }
    @JsonProperty("href")
    public void setHref(Optional<HttpUrl> href) {
      this.href = href;
    }
    @JsonProperty("template")
    public void setTemplate(Optional<String> template) {
      this.template = template;
    }
    @Override
    public HttpUrl rel() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<HttpUrl> href() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> template() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePayIdDiscoveryLink fromJson(Json json) {
    ImmutablePayIdDiscoveryLink.Builder builder = ImmutablePayIdDiscoveryLink.builder();
    if (json.rel != null) {
      builder.rel(json.rel);
    }
    if (json.href != null) {
      builder.href(json.href);
    }
    if (json.template != null) {
      builder.template(json.template);
    }
    return builder.build();
  }

  private static ImmutablePayIdDiscoveryLink validate(ImmutablePayIdDiscoveryLink instance) {
    instance = (ImmutablePayIdDiscoveryLink) instance.verifyHrefOrTemplatePopulated();
    return instance;
  }

  /**
   * Creates an immutable copy of a {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PayIdDiscoveryLink instance
   */
  public static ImmutablePayIdDiscoveryLink copyOf(PayIdDiscoveryLink.AbstractPayIdDiscoveryLink instance) {
    if (instance instanceof ImmutablePayIdDiscoveryLink) {
      return (ImmutablePayIdDiscoveryLink) instance;
    }
    return ImmutablePayIdDiscoveryLink.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePayIdDiscoveryLink ImmutablePayIdDiscoveryLink}.
   * <pre>
   * ImmutablePayIdDiscoveryLink.builder()
   *    .rel(okhttp3.HttpUrl) // required {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#rel() rel}
   *    .href(okhttp3.HttpUrl) // optional {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#href() href}
   *    .template(String) // optional {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#template() template}
   *    .build();
   * </pre>
   * @return A new ImmutablePayIdDiscoveryLink builder
   */
  public static ImmutablePayIdDiscoveryLink.Builder builder() {
    return new ImmutablePayIdDiscoveryLink.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePayIdDiscoveryLink ImmutablePayIdDiscoveryLink}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PayIdDiscoveryLink.AbstractPayIdDiscoveryLink", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_REL = 0x1L;
    private long initBits = 0x1L;

    private @Nullable HttpUrl rel;
    private @Nullable HttpUrl href;
    private @Nullable String template;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code org.payid.client.model.discovery.PayIdDiscoveryLink} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(PayIdDiscoveryLink instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code org.payid.client.model.discovery.PayIdDiscoveryLink.AbstractPayIdDiscoveryLink} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(PayIdDiscoveryLink.AbstractPayIdDiscoveryLink instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof PayIdDiscoveryLink) {
        PayIdDiscoveryLink instance = (PayIdDiscoveryLink) object;
        Optional<String> templateOptional = instance.template();
        if (templateOptional.isPresent()) {
          template(templateOptional);
        }
        rel(instance.rel());
        Optional<HttpUrl> hrefOptional = instance.href();
        if (hrefOptional.isPresent()) {
          href(hrefOptional);
        }
      }
    }

    /**
     * Initializes the value for the {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#rel() rel} attribute.
     * @param rel The value for rel 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("rel")
    public final Builder rel(HttpUrl rel) {
      this.rel = Objects.requireNonNull(rel, "rel");
      initBits &= ~INIT_BIT_REL;
      return this;
    }

    /**
     * Initializes the optional value {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#href() href} to href.
     * @param href The value for href
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder href(HttpUrl href) {
      this.href = Objects.requireNonNull(href, "href");
      return this;
    }

    /**
     * Initializes the optional value {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#href() href} to href.
     * @param href The value for href
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("href")
    public final Builder href(Optional<? extends HttpUrl> href) {
      this.href = href.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#template() template} to template.
     * @param template The value for template
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder template(String template) {
      this.template = Objects.requireNonNull(template, "template");
      return this;
    }

    /**
     * Initializes the optional value {@link PayIdDiscoveryLink.AbstractPayIdDiscoveryLink#template() template} to template.
     * @param template The value for template
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("template")
    public final Builder template(Optional<String> template) {
      this.template = template.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutablePayIdDiscoveryLink ImmutablePayIdDiscoveryLink}.
     * @return An immutable instance of PayIdDiscoveryLink
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePayIdDiscoveryLink build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return ImmutablePayIdDiscoveryLink.validate(new ImmutablePayIdDiscoveryLink(rel, href, template));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_REL) != 0) attributes.add("rel");
      return "Cannot build PayIdDiscoveryLink, some of required attributes are not set " + attributes;
    }
  }
}
