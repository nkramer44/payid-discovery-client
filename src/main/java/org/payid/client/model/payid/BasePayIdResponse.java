package org.payid.client.model.payid;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableBasePayIdResponse.class)
@JsonDeserialize(as = ImmutableBasePayIdResponse.class)
public interface BasePayIdResponse {

  static ImmutableBasePayIdResponse.Builder builder() {
    return ImmutableBasePayIdResponse.builder();
  }

  List<PayIdAddress> addresses();

  String payId();

}
