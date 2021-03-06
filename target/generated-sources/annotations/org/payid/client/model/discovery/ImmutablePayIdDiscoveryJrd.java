package org.payid.client.model.discovery;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;
import org.payid.client.model.payid.PayId;

/**
 * Immutable implementation of {@link PayIdDiscoveryJrd}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePayIdDiscoveryJrd.builder()}.
 */
@Generated(from = "PayIdDiscoveryJrd", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutablePayIdDiscoveryJrd implements PayIdDiscoveryJrd {
  private final PayId subject;
  private final ImmutableList<PayIdDiscoveryLink> links;

  private ImmutablePayIdDiscoveryJrd(
      PayId subject,
      ImmutableList<PayIdDiscoveryLink> links) {
    this.subject = subject;
    this.links = links;
  }

  /**
   * @return The value of the {@code subject} attribute
   */
  @JsonProperty("subject")
  @Override
  public PayId subject() {
    return subject;
  }

  /**
   * @return The value of the {@code links} attribute
   */
  @JsonProperty("links")
  @Override
  public ImmutableList<PayIdDiscoveryLink> links() {
    return links;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PayIdDiscoveryJrd#subject() subject} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for subject
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePayIdDiscoveryJrd withSubject(PayId value) {
    if (this.subject == value) return this;
    PayId newValue = Objects.requireNonNull(value, "subject");
    return new ImmutablePayIdDiscoveryJrd(newValue, this.links);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PayIdDiscoveryJrd#links() links}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePayIdDiscoveryJrd withLinks(PayIdDiscoveryLink... elements) {
    ImmutableList<PayIdDiscoveryLink> newValue = ImmutableList.copyOf(elements);
    return new ImmutablePayIdDiscoveryJrd(this.subject, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link PayIdDiscoveryJrd#links() links}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of links elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutablePayIdDiscoveryJrd withLinks(Iterable<? extends PayIdDiscoveryLink> elements) {
    if (this.links == elements) return this;
    ImmutableList<PayIdDiscoveryLink> newValue = ImmutableList.copyOf(elements);
    return new ImmutablePayIdDiscoveryJrd(this.subject, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePayIdDiscoveryJrd} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePayIdDiscoveryJrd
        && equalTo((ImmutablePayIdDiscoveryJrd) another);
  }

  private boolean equalTo(ImmutablePayIdDiscoveryJrd another) {
    return subject.equals(another.subject)
        && links.equals(another.links);
  }

  /**
   * Computes a hash code from attributes: {@code subject}, {@code links}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + subject.hashCode();
    h += (h << 5) + links.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code PayIdDiscoveryJrd} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("PayIdDiscoveryJrd")
        .omitNullValues()
        .add("subject", subject)
        .add("links", links)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PayIdDiscoveryJrd", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements PayIdDiscoveryJrd {
    @Nullable PayId subject;
    @Nullable List<PayIdDiscoveryLink> links = ImmutableList.of();
    @JsonProperty("subject")
    public void setSubject(PayId subject) {
      this.subject = subject;
    }
    @JsonProperty("links")
    public void setLinks(List<PayIdDiscoveryLink> links) {
      this.links = links;
    }
    @Override
    public PayId subject() { throw new UnsupportedOperationException(); }
    @Override
    public List<PayIdDiscoveryLink> links() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePayIdDiscoveryJrd fromJson(Json json) {
    ImmutablePayIdDiscoveryJrd.Builder builder = ImmutablePayIdDiscoveryJrd.builder();
    if (json.subject != null) {
      builder.subject(json.subject);
    }
    if (json.links != null) {
      builder.addAllLinks(json.links);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link PayIdDiscoveryJrd} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PayIdDiscoveryJrd instance
   */
  public static ImmutablePayIdDiscoveryJrd copyOf(PayIdDiscoveryJrd instance) {
    if (instance instanceof ImmutablePayIdDiscoveryJrd) {
      return (ImmutablePayIdDiscoveryJrd) instance;
    }
    return ImmutablePayIdDiscoveryJrd.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePayIdDiscoveryJrd ImmutablePayIdDiscoveryJrd}.
   * <pre>
   * ImmutablePayIdDiscoveryJrd.builder()
   *    .subject(org.payid.client.model.payid.PayId) // required {@link PayIdDiscoveryJrd#subject() subject}
   *    .addLinks|addAllLinks(org.payid.client.model.discovery.PayIdDiscoveryLink) // {@link PayIdDiscoveryJrd#links() links} elements
   *    .build();
   * </pre>
   * @return A new ImmutablePayIdDiscoveryJrd builder
   */
  public static ImmutablePayIdDiscoveryJrd.Builder builder() {
    return new ImmutablePayIdDiscoveryJrd.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePayIdDiscoveryJrd ImmutablePayIdDiscoveryJrd}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PayIdDiscoveryJrd", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_SUBJECT = 0x1L;
    private long initBits = 0x1L;

    private @Nullable PayId subject;
    private ImmutableList.Builder<PayIdDiscoveryLink> links = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PayIdDiscoveryJrd} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(PayIdDiscoveryJrd instance) {
      Objects.requireNonNull(instance, "instance");
      subject(instance.subject());
      addAllLinks(instance.links());
      return this;
    }

    /**
     * Initializes the value for the {@link PayIdDiscoveryJrd#subject() subject} attribute.
     * @param subject The value for subject 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("subject")
    public final Builder subject(PayId subject) {
      this.subject = Objects.requireNonNull(subject, "subject");
      initBits &= ~INIT_BIT_SUBJECT;
      return this;
    }

    /**
     * Adds one element to {@link PayIdDiscoveryJrd#links() links} list.
     * @param element A links element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addLinks(PayIdDiscoveryLink element) {
      this.links.add(element);
      return this;
    }

    /**
     * Adds elements to {@link PayIdDiscoveryJrd#links() links} list.
     * @param elements An array of links elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addLinks(PayIdDiscoveryLink... elements) {
      this.links.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link PayIdDiscoveryJrd#links() links} list.
     * @param elements An iterable of links elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("links")
    public final Builder links(Iterable<? extends PayIdDiscoveryLink> elements) {
      this.links = ImmutableList.builder();
      return addAllLinks(elements);
    }

    /**
     * Adds elements to {@link PayIdDiscoveryJrd#links() links} list.
     * @param elements An iterable of links elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllLinks(Iterable<? extends PayIdDiscoveryLink> elements) {
      this.links.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ImmutablePayIdDiscoveryJrd ImmutablePayIdDiscoveryJrd}.
     * @return An immutable instance of PayIdDiscoveryJrd
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePayIdDiscoveryJrd build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePayIdDiscoveryJrd(subject, links.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_SUBJECT) != 0) attributes.add("subject");
      return "Cannot build PayIdDiscoveryJrd, some of required attributes are not set " + attributes;
    }
  }
}
