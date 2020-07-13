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
 * Immutable implementation of {@link PayIdAddress}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePayIdAddress.builder()}.
 */
@Generated(from = "PayIdAddress", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
public final class ImmutablePayIdAddress implements PayIdAddress {
  private final String paymentNetwork;
  private final String environment;
  private final String addressDetailsType;
  private final PayIdAddressDetails addressDetails;

  private ImmutablePayIdAddress(
      String paymentNetwork,
      String environment,
      String addressDetailsType,
      PayIdAddressDetails addressDetails) {
    this.paymentNetwork = paymentNetwork;
    this.environment = environment;
    this.addressDetailsType = addressDetailsType;
    this.addressDetails = addressDetails;
  }

  /**
   * @return The value of the {@code paymentNetwork} attribute
   */
  @JsonProperty("paymentNetwork")
  @Override
  public String paymentNetwork() {
    return paymentNetwork;
  }

  /**
   * @return The value of the {@code environment} attribute
   */
  @JsonProperty("environment")
  @Override
  public String environment() {
    return environment;
  }

  /**
   * @return The value of the {@code addressDetailsType} attribute
   */
  @JsonProperty("addressDetailsType")
  @Override
  public String addressDetailsType() {
    return addressDetailsType;
  }

  /**
   * @return The value of the {@code addressDetails} attribute
   */
  @JsonProperty("addressDetails")
  @Override
  public PayIdAddressDetails addressDetails() {
    return addressDetails;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PayIdAddress#paymentNetwork() paymentNetwork} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for paymentNetwork
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePayIdAddress withPaymentNetwork(String value) {
    String newValue = Objects.requireNonNull(value, "paymentNetwork");
    if (this.paymentNetwork.equals(newValue)) return this;
    return new ImmutablePayIdAddress(newValue, this.environment, this.addressDetailsType, this.addressDetails);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PayIdAddress#environment() environment} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for environment
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePayIdAddress withEnvironment(String value) {
    String newValue = Objects.requireNonNull(value, "environment");
    if (this.environment.equals(newValue)) return this;
    return new ImmutablePayIdAddress(this.paymentNetwork, newValue, this.addressDetailsType, this.addressDetails);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PayIdAddress#addressDetailsType() addressDetailsType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for addressDetailsType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePayIdAddress withAddressDetailsType(String value) {
    String newValue = Objects.requireNonNull(value, "addressDetailsType");
    if (this.addressDetailsType.equals(newValue)) return this;
    return new ImmutablePayIdAddress(this.paymentNetwork, this.environment, newValue, this.addressDetails);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link PayIdAddress#addressDetails() addressDetails} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for addressDetails
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePayIdAddress withAddressDetails(PayIdAddressDetails value) {
    if (this.addressDetails == value) return this;
    PayIdAddressDetails newValue = Objects.requireNonNull(value, "addressDetails");
    return new ImmutablePayIdAddress(this.paymentNetwork, this.environment, this.addressDetailsType, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePayIdAddress} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePayIdAddress
        && equalTo((ImmutablePayIdAddress) another);
  }

  private boolean equalTo(ImmutablePayIdAddress another) {
    return paymentNetwork.equals(another.paymentNetwork)
        && environment.equals(another.environment)
        && addressDetailsType.equals(another.addressDetailsType)
        && addressDetails.equals(another.addressDetails);
  }

  /**
   * Computes a hash code from attributes: {@code paymentNetwork}, {@code environment}, {@code addressDetailsType}, {@code addressDetails}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + paymentNetwork.hashCode();
    h += (h << 5) + environment.hashCode();
    h += (h << 5) + addressDetailsType.hashCode();
    h += (h << 5) + addressDetails.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code PayIdAddress} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("PayIdAddress")
        .omitNullValues()
        .add("paymentNetwork", paymentNetwork)
        .add("environment", environment)
        .add("addressDetailsType", addressDetailsType)
        .add("addressDetails", addressDetails)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PayIdAddress", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements PayIdAddress {
    @Nullable String paymentNetwork;
    @Nullable String environment;
    @Nullable String addressDetailsType;
    @Nullable PayIdAddressDetails addressDetails;
    @JsonProperty("paymentNetwork")
    public void setPaymentNetwork(String paymentNetwork) {
      this.paymentNetwork = paymentNetwork;
    }
    @JsonProperty("environment")
    public void setEnvironment(String environment) {
      this.environment = environment;
    }
    @JsonProperty("addressDetailsType")
    public void setAddressDetailsType(String addressDetailsType) {
      this.addressDetailsType = addressDetailsType;
    }
    @JsonProperty("addressDetails")
    public void setAddressDetails(PayIdAddressDetails addressDetails) {
      this.addressDetails = addressDetails;
    }
    @Override
    public String paymentNetwork() { throw new UnsupportedOperationException(); }
    @Override
    public String environment() { throw new UnsupportedOperationException(); }
    @Override
    public String addressDetailsType() { throw new UnsupportedOperationException(); }
    @Override
    public PayIdAddressDetails addressDetails() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePayIdAddress fromJson(Json json) {
    ImmutablePayIdAddress.Builder builder = ImmutablePayIdAddress.builder();
    if (json.paymentNetwork != null) {
      builder.paymentNetwork(json.paymentNetwork);
    }
    if (json.environment != null) {
      builder.environment(json.environment);
    }
    if (json.addressDetailsType != null) {
      builder.addressDetailsType(json.addressDetailsType);
    }
    if (json.addressDetails != null) {
      builder.addressDetails(json.addressDetails);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link PayIdAddress} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PayIdAddress instance
   */
  public static ImmutablePayIdAddress copyOf(PayIdAddress instance) {
    if (instance instanceof ImmutablePayIdAddress) {
      return (ImmutablePayIdAddress) instance;
    }
    return ImmutablePayIdAddress.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePayIdAddress ImmutablePayIdAddress}.
   * <pre>
   * ImmutablePayIdAddress.builder()
   *    .paymentNetwork(String) // required {@link PayIdAddress#paymentNetwork() paymentNetwork}
   *    .environment(String) // required {@link PayIdAddress#environment() environment}
   *    .addressDetailsType(String) // required {@link PayIdAddress#addressDetailsType() addressDetailsType}
   *    .addressDetails(org.payid.client.model.payid.PayIdAddressDetails) // required {@link PayIdAddress#addressDetails() addressDetails}
   *    .build();
   * </pre>
   * @return A new ImmutablePayIdAddress builder
   */
  public static ImmutablePayIdAddress.Builder builder() {
    return new ImmutablePayIdAddress.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePayIdAddress ImmutablePayIdAddress}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PayIdAddress", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_PAYMENT_NETWORK = 0x1L;
    private static final long INIT_BIT_ENVIRONMENT = 0x2L;
    private static final long INIT_BIT_ADDRESS_DETAILS_TYPE = 0x4L;
    private static final long INIT_BIT_ADDRESS_DETAILS = 0x8L;
    private long initBits = 0xfL;

    private @Nullable String paymentNetwork;
    private @Nullable String environment;
    private @Nullable String addressDetailsType;
    private @Nullable PayIdAddressDetails addressDetails;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PayIdAddress} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(PayIdAddress instance) {
      Objects.requireNonNull(instance, "instance");
      paymentNetwork(instance.paymentNetwork());
      environment(instance.environment());
      addressDetailsType(instance.addressDetailsType());
      addressDetails(instance.addressDetails());
      return this;
    }

    /**
     * Initializes the value for the {@link PayIdAddress#paymentNetwork() paymentNetwork} attribute.
     * @param paymentNetwork The value for paymentNetwork 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("paymentNetwork")
    public final Builder paymentNetwork(String paymentNetwork) {
      this.paymentNetwork = Objects.requireNonNull(paymentNetwork, "paymentNetwork");
      initBits &= ~INIT_BIT_PAYMENT_NETWORK;
      return this;
    }

    /**
     * Initializes the value for the {@link PayIdAddress#environment() environment} attribute.
     * @param environment The value for environment 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("environment")
    public final Builder environment(String environment) {
      this.environment = Objects.requireNonNull(environment, "environment");
      initBits &= ~INIT_BIT_ENVIRONMENT;
      return this;
    }

    /**
     * Initializes the value for the {@link PayIdAddress#addressDetailsType() addressDetailsType} attribute.
     * @param addressDetailsType The value for addressDetailsType 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("addressDetailsType")
    public final Builder addressDetailsType(String addressDetailsType) {
      this.addressDetailsType = Objects.requireNonNull(addressDetailsType, "addressDetailsType");
      initBits &= ~INIT_BIT_ADDRESS_DETAILS_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link PayIdAddress#addressDetails() addressDetails} attribute.
     * @param addressDetails The value for addressDetails 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("addressDetails")
    public final Builder addressDetails(PayIdAddressDetails addressDetails) {
      this.addressDetails = Objects.requireNonNull(addressDetails, "addressDetails");
      initBits &= ~INIT_BIT_ADDRESS_DETAILS;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePayIdAddress ImmutablePayIdAddress}.
     * @return An immutable instance of PayIdAddress
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePayIdAddress build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePayIdAddress(paymentNetwork, environment, addressDetailsType, addressDetails);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_PAYMENT_NETWORK) != 0) attributes.add("paymentNetwork");
      if ((initBits & INIT_BIT_ENVIRONMENT) != 0) attributes.add("environment");
      if ((initBits & INIT_BIT_ADDRESS_DETAILS_TYPE) != 0) attributes.add("addressDetailsType");
      if ((initBits & INIT_BIT_ADDRESS_DETAILS) != 0) attributes.add("addressDetails");
      return "Cannot build PayIdAddress, some of required attributes are not set " + attributes;
    }
  }
}
