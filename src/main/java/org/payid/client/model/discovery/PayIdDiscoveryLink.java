package org.payid.client.model.discovery;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import okhttp3.HttpUrl;
import org.immutables.value.Value;

import java.util.Optional;

public interface PayIdDiscoveryLink {

  static ImmutablePayIdDiscoveryLink.Builder builder() {
    return ImmutablePayIdDiscoveryLink.builder();
  }

  HttpUrl rel();

  Optional<HttpUrl> href();

  Optional<String> template();

  @Value.Immutable
  @JsonSerialize(as = ImmutablePayIdDiscoveryLink.class)
  @JsonDeserialize(as = ImmutablePayIdDiscoveryLink.class)
  abstract class AbstractPayIdDiscoveryLink implements PayIdDiscoveryLink {

    @Value.Check
    public AbstractPayIdDiscoveryLink verifyHrefOrTemplatePopulated() {
      Preconditions.checkArgument(href().isPresent() || template().isPresent(), "One of href or template must be populated.");
      return this;
    }

  }
}
