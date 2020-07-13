package org.payid.client.model.payid;

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
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PayIdAddressDetails}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePayIdAddressDetails.builder()}.
 */
@Generated(from = "PayIdAddressDetails", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutablePayIdAddressDetails implements PayIdAddressDetails {
  private final String address;

  private ImmutablePayIdAddressDetails(String address) {
    this.address = address;
  }

  /**
   * @return The value of the {@code address} attribute
   */
  @JsonProperty("address")
  @Override
  public String address() {
    return address;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PayIdAddressDetails#address() address} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for address
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePayIdAddressDetails withAddress(String value) {
    String newValue = Objects.requireNonNull(value, "address");
    if (this.address.equals(newValue)) return this;
    return new ImmutablePayIdAddressDetails(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePayIdAddressDetails} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePayIdAddressDetails
        && equalTo((ImmutablePayIdAddressDetails) another);
  }

  private boolean equalTo(ImmutablePayIdAddressDetails another) {
    return address.equals(another.address);
  }

  /**
   * Computes a hash code from attributes: {@code address}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + address.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code PayIdAddressDetails} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("PayIdAddressDetails")
        .omitNullValues()
        .add("address", address)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PayIdAddressDetails", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements PayIdAddressDetails {
    @Nullable String address;
    @JsonProperty("address")
    public void setAddress(String address) {
      this.address = address;
    }
    @Override
    public String address() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePayIdAddressDetails fromJson(Json json) {
    ImmutablePayIdAddressDetails.Builder builder = ImmutablePayIdAddressDetails.builder();
    if (json.address != null) {
      builder.address(json.address);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link PayIdAddressDetails} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PayIdAddressDetails instance
   */
  public static ImmutablePayIdAddressDetails copyOf(PayIdAddressDetails instance) {
    if (instance instanceof ImmutablePayIdAddressDetails) {
      return (ImmutablePayIdAddressDetails) instance;
    }
    return ImmutablePayIdAddressDetails.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePayIdAddressDetails ImmutablePayIdAddressDetails}.
   * <pre>
   * ImmutablePayIdAddressDetails.builder()
   *    .address(String) // required {@link PayIdAddressDetails#address() address}
   *    .build();
   * </pre>
   * @return A new ImmutablePayIdAddressDetails builder
   */
  public static ImmutablePayIdAddressDetails.Builder builder() {
    return new ImmutablePayIdAddressDetails.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePayIdAddressDetails ImmutablePayIdAddressDetails}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PayIdAddressDetails", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ADDRESS = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String address;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PayIdAddressDetails} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(PayIdAddressDetails instance) {
      Objects.requireNonNull(instance, "instance");
      address(instance.address());
      return this;
    }

    /**
     * Initializes the value for the {@link PayIdAddressDetails#address() address} attribute.
     * @param address The value for address 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("address")
    public final Builder address(String address) {
      this.address = Objects.requireNonNull(address, "address");
      initBits &= ~INIT_BIT_ADDRESS;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePayIdAddressDetails ImmutablePayIdAddressDetails}.
     * @return An immutable instance of PayIdAddressDetails
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePayIdAddressDetails build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePayIdAddressDetails(address);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ADDRESS) != 0) attributes.add("address");
      return "Cannot build PayIdAddressDetails, some of required attributes are not set " + attributes;
    }
  }
}
