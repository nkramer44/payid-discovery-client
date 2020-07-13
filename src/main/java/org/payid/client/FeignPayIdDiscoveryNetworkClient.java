package org.payid.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Target;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.optionals.OptionalDecoder;
import org.payid.client.model.discovery.PayIdDiscoveryJrd;
import org.payid.client.model.payid.PayId;

import java.net.URI;

public interface FeignPayIdDiscoveryNetworkClient extends PayIdDiscoveryNetworkClient {

  static FeignPayIdDiscoveryNetworkClient construct(ObjectMapper objectMapper) {
    return Feign.builder()
      .encoder(new JacksonEncoder(objectMapper))
      .decode404()
      .decoder(new OptionalDecoder(new JacksonDecoder(objectMapper)))
      .target(Target.EmptyTarget.create(FeignPayIdDiscoveryNetworkClient.class));
  }

  @RequestLine("GET /.well-known/webfinger?resource={payId}")
  PayIdDiscoveryJrd getPayIdJrd(URI baseUri, @Param("payId") PayId payId);
}

