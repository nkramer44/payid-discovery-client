package org.payid.client.model.payid;

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

/**
 * Immutable implementation of {@link BasePayIdResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableBasePayIdResponse.builder()}.
 */
@Generated(from = "BasePayIdResponse", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutableBasePayIdResponse implements BasePayIdResponse {
  private final ImmutableList<PayIdAddress> addresses;
  private final String payId;

  private ImmutableBasePayIdResponse(
      ImmutableList<PayIdAddress> addresses,
      String payId) {
    this.addresses = addresses;
    this.payId = payId;
  }

  /**
   * @return The value of the {@code addresses} attribute
   */
  @JsonProperty("addresses")
  @Override
  public ImmutableList<PayIdAddress> addresses() {
    return addresses;
  }

  /**
   * @return The value of the {@code payId} attribute
   */
  @JsonProperty("payId")
  @Override
  public String payId() {
    return payId;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link BasePayIdResponse#addresses() addresses}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableBasePayIdResponse withAddresses(PayIdAddress... elements) {
    ImmutableList<PayIdAddress> newValue = ImmutableList.copyOf(elements);
    return new ImmutableBasePayIdResponse(newValue, this.payId);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link BasePayIdResponse#addresses() addresses}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of addresses elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableBasePayIdResponse withAddresses(Iterable<? extends PayIdAddress> elements) {
    if (this.addresses == elements) return this;
    ImmutableList<PayIdAddress> newValue = ImmutableList.copyOf(elements);
    return new ImmutableBasePayIdResponse(newValue, this.payId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link BasePayIdResponse#payId() payId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for payId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableBasePayIdResponse withPayId(String value) {
    String newValue = Objects.requireNonNull(value, "payId");
    if (this.payId.equals(newValue)) return this;
    return new ImmutableBasePayIdResponse(this.addresses, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableBasePayIdResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableBasePayIdResponse
        && equalTo((ImmutableBasePayIdResponse) another);
  }

  private boolean equalTo(ImmutableBasePayIdResponse another) {
    return addresses.equals(another.addresses)
        && payId.equals(another.payId);
  }

  /**
   * Computes a hash code from attributes: {@code addresses}, {@code payId}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + addresses.hashCode();
    h += (h << 5) + payId.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code BasePayIdResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("BasePayIdResponse")
        .omitNullValues()
        .add("addresses", addresses)
        .add("payId", payId)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "BasePayIdResponse", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements BasePayIdResponse {
    @Nullable List<PayIdAddress> addresses = ImmutableList.of();
    @Nullable String payId;
    @JsonProperty("addresses")
    public void setAddresses(List<PayIdAddress> addresses) {
      this.addresses = addresses;
    }
    @JsonProperty("payId")
    public void setPayId(String payId) {
      this.payId = payId;
    }
    @Override
    public List<PayIdAddress> addresses() { throw new UnsupportedOperationException(); }
    @Override
    public String payId() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableBasePayIdResponse fromJson(Json json) {
    ImmutableBasePayIdResponse.Builder builder = ImmutableBasePayIdResponse.builder();
    if (json.addresses != null) {
      builder.addAllAddresses(json.addresses);
    }
    if (json.payId != null) {
      builder.payId(json.payId);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link BasePayIdResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable BasePayIdResponse instance
   */
  public static ImmutableBasePayIdResponse copyOf(BasePayIdResponse instance) {
    if (instance instanceof ImmutableBasePayIdResponse) {
      return (ImmutableBasePayIdResponse) instance;
    }
    return ImmutableBasePayIdResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableBasePayIdResponse ImmutableBasePayIdResponse}.
   * <pre>
   * ImmutableBasePayIdResponse.builder()
   *    .addAddresses|addAllAddresses(org.payid.client.model.payid.PayIdAddress) // {@link BasePayIdResponse#addresses() addresses} elements
   *    .payId(String) // required {@link BasePayIdResponse#payId() payId}
   *    .build();
   * </pre>
   * @return A new ImmutableBasePayIdResponse builder
   */
  public static ImmutableBasePayIdResponse.Builder builder() {
    return new ImmutableBasePayIdResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableBasePayIdResponse ImmutableBasePayIdResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BasePayIdResponse", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_PAY_ID = 0x1L;
    private long initBits = 0x1L;

    private ImmutableList.Builder<PayIdAddress> addresses = ImmutableList.builder();
    private @Nullable String payId;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code BasePayIdResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(BasePayIdResponse instance) {
      Objects.requireNonNull(instance, "instance");
      addAllAddresses(instance.addresses());
      payId(instance.payId());
      return this;
    }

    /**
     * Adds one element to {@link BasePayIdResponse#addresses() addresses} list.
     * @param element A addresses element
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAddresses(PayIdAddress element) {
      this.addresses.add(element);
      return this;
    }

    /**
     * Adds elements to {@link BasePayIdResponse#addresses() addresses} list.
     * @param elements An array of addresses elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAddresses(PayIdAddress... elements) {
      this.addresses.add(elements);
      return this;
    }


    /**
     * Sets or replaces all elements for {@link BasePayIdResponse#addresses() addresses} list.
     * @param elements An iterable of addresses elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("addresses")
    public final Builder addresses(Iterable<? extends PayIdAddress> elements) {
      this.addresses = ImmutableList.builder();
      return addAllAddresses(elements);
    }

    /**
     * Adds elements to {@link BasePayIdResponse#addresses() addresses} list.
     * @param elements An iterable of addresses elements
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder addAllAddresses(Iterable<? extends PayIdAddress> elements) {
      this.addresses.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link BasePayIdResponse#payId() payId} attribute.
     * @param payId The value for payId 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("payId")
    public final Builder payId(String payId) {
      this.payId = Objects.requireNonNull(payId, "payId");
      initBits &= ~INIT_BIT_PAY_ID;
      return this;
    }

    /**
     * Builds a new {@link ImmutableBasePayIdResponse ImmutableBasePayIdResponse}.
     * @return An immutable instance of BasePayIdResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableBasePayIdResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableBasePayIdResponse(addresses.build(), payId);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_PAY_ID) != 0) attributes.add("payId");
      return "Cannot build BasePayIdResponse, some of required attributes are not set " + attributes;
    }
  }
}
