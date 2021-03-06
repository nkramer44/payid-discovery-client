package org.payid.client.model.discovery;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.payid.client.model.payid.PayId;

import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutablePayIdDiscoveryJrd.class)
@JsonDeserialize(as = ImmutablePayIdDiscoveryJrd.class)
public interface PayIdDiscoveryJrd {

  static ImmutablePayIdDiscoveryJrd.Builder builder() {
    return ImmutablePayIdDiscoveryJrd.builder();
  }

  PayId subject();

  List<PayIdDiscoveryLink> links();
}
