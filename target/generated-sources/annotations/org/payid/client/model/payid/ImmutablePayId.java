package org.payid.client.model.payid;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import okhttp3.HttpUrl;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link AbstractPayId}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePayId.builder()}.
 */
@Generated(from = "AbstractPayId", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@CheckReturnValue
final class ImmutablePayId extends AbstractPayId {
  private final String account;
  private final String host;
  private transient final HttpUrl baseUrl;

  private ImmutablePayId(String account, String host) {
    this.account = account;
    this.host = host;
    this.baseUrl = Objects.requireNonNull(super.baseUrl(), "baseUrl");
  }

  /**
   * @return The value of the {@code account} attribute
   */
  @JsonProperty("account")
  @Override
  public String account() {
    return account;
  }

  /**
   * @return The value of the {@code host} attribute
   */
  @JsonProperty("host")
  @Override
  public String host() {
    return host;
  }

  /**
   * @return The computed-at-construction value of the {@code baseUrl} attribute
   */
  @JsonProperty("baseUrl")
  @Override
  public HttpUrl baseUrl() {
    return baseUrl;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractPayId#account() account} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for account
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePayId withAccount(String value) {
    String newValue = Objects.requireNonNull(value, "account");
    if (this.account.equals(newValue)) return this;
    return validate(new ImmutablePayId(newValue, this.host));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link AbstractPayId#host() host} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for host
   * @return A modified copy of the {@code this} object
   */
  public final ImmutablePayId withHost(String value) {
    String newValue = Objects.requireNonNull(value, "host");
    if (this.host.equals(newValue)) return this;
    return validate(new ImmutablePayId(this.account, newValue));
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePayId} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePayId
        && equalTo((ImmutablePayId) another);
  }

  private boolean equalTo(ImmutablePayId another) {
    return account.equals(another.account)
        && host.equals(another.host)
        && baseUrl.equals(another.baseUrl);
  }

  /**
   * Computes a hash code from attributes: {@code account}, {@code host}, {@code baseUrl}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + account.hashCode();
    h += (h << 5) + host.hashCode();
    h += (h << 5) + baseUrl.hashCode();
    return h;
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "AbstractPayId", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends AbstractPayId {
    @Nullable String account;
    @Nullable String host;
    @JsonProperty("account")
    public void setAccount(String account) {
      this.account = account;
    }
    @JsonProperty("host")
    public void setHost(String host) {
      this.host = host;
    }
    @Override
    public String account() { throw new UnsupportedOperationException(); }
    @Override
    public String host() { throw new UnsupportedOperationException(); }
    @JsonIgnore
    @Override
    public HttpUrl baseUrl() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePayId fromJson(Json json) {
    ImmutablePayId.Builder builder = ImmutablePayId.builder();
    if (json.account != null) {
      builder.account(json.account);
    }
    if (json.host != null) {
      builder.host(json.host);
    }
    return builder.build();
  }

  private static ImmutablePayId validate(ImmutablePayId instance) {
    instance = (ImmutablePayId) instance.validate();
    return instance;
  }

  /**
   * Creates an immutable copy of a {@link AbstractPayId} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable PayId instance
   */
  public static ImmutablePayId copyOf(AbstractPayId instance) {
    if (instance instanceof ImmutablePayId) {
      return (ImmutablePayId) instance;
    }
    return ImmutablePayId.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutablePayId ImmutablePayId}.
   * <pre>
   * ImmutablePayId.builder()
   *    .account(String) // required {@link AbstractPayId#account() account}
   *    .host(String) // required {@link AbstractPayId#host() host}
   *    .build();
   * </pre>
   * @return A new ImmutablePayId builder
   */
  public static ImmutablePayId.Builder builder() {
    return new ImmutablePayId.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePayId ImmutablePayId}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "AbstractPayId", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ACCOUNT = 0x1L;
    private static final long INIT_BIT_HOST = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String account;
    private @Nullable String host;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code org.payid.client.model.payid.PayId} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(PayId instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code org.payid.client.model.payid.AbstractPayId} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(AbstractPayId instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof PayId) {
        PayId instance = (PayId) object;
        host(instance.host());
        account(instance.account());
      }
    }

    /**
     * Initializes the value for the {@link AbstractPayId#account() account} attribute.
     * @param account The value for account 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("account")
    public final Builder account(String account) {
      this.account = Objects.requireNonNull(account, "account");
      initBits &= ~INIT_BIT_ACCOUNT;
      return this;
    }

    /**
     * Initializes the value for the {@link AbstractPayId#host() host} attribute.
     * @param host The value for host 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty("host")
    public final Builder host(String host) {
      this.host = Objects.requireNonNull(host, "host");
      initBits &= ~INIT_BIT_HOST;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePayId ImmutablePayId}.
     * @return An immutable instance of PayId
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePayId build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return ImmutablePayId.validate(new ImmutablePayId(account, host));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ACCOUNT) != 0) attributes.add("account");
      if ((initBits & INIT_BIT_HOST) != 0) attributes.add("host");
      return "Cannot build PayId, some of required attributes are not set " + attributes;
    }
  }
}
