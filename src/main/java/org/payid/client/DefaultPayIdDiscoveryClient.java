package org.payid.client;

import com.google.common.primitives.UnsignedLong;
import feign.FeignException;
import okhttp3.HttpUrl;
import org.payid.client.jackson.ObjectMapperFactory;
import org.payid.client.model.discovery.JrdLinkConstants;
import org.payid.client.model.discovery.PayIdDiscoveryJrd;
import org.payid.client.model.payid.PayId;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DefaultPayIdDiscoveryClient implements PayIdDiscoveryClient {

  private final PayIdDiscoveryNetworkClient payIdDiscoveryNetworkClient;

  public DefaultPayIdDiscoveryClient() {
    this.payIdDiscoveryNetworkClient = FeignPayIdDiscoveryNetworkClient.construct(
      ObjectMapperFactory.createObjectMapperForProblemsJson()
    );
  }

  public DefaultPayIdDiscoveryClient(PayIdDiscoveryNetworkClient payIdDiscoveryNetworkClient) {
    this.payIdDiscoveryNetworkClient = payIdDiscoveryNetworkClient;
  }

  @Override
  public Optional<PayIdDiscoveryJrd> discoverPayId(PayId payId) {
    try {
      return Optional.of(payIdDiscoveryNetworkClient.getPayIdJrd(payId.baseUrl().uri(), payId));
    } catch (FeignException e) {
      if (e.status() == 404) {
        return Optional.empty();
      }

      throw e;
    }
  }

  @Override
  public HttpUrl getBasePayIdUrl(PayId payId) {
    return this.discoverPayId(payId)
      .map(jrd ->
        jrd.links().stream()
          .filter(link -> link.rel().equals(JrdLinkConstants.PAYID_DISCOVERY_REL))
          .findFirst()
          .map(link -> {
            Map<String, String> templateParamMap = new HashMap();
            templateParamMap.put(JrdLinkConstants.ACCT_PART, payId.account());
            return link.href().orElse(resolveUrlTemplate(link.template().get(), templateParamMap));
          })
          .orElse(payId.baseUrl())
      )
      .orElse(payId.baseUrl());
  }

  @Override
  public Optional<HttpUrl> getEasyCheckoutUrl(PayId payId, UnsignedLong amount, PayId receiverPayId, HttpUrl nextUrl) {
    return this.discoverPayId(payId)
      .flatMap(jrd ->
        jrd.links().stream()
          .filter(link -> link.rel().equals(JrdLinkConstants.EASY_CHECKOUT_REL))
          .findFirst()
          .map(link -> {
            Map<String, String> templateParamMap = new HashMap();
            templateParamMap.put(JrdLinkConstants.AMOUNT, amount.toString());
            templateParamMap.put(JrdLinkConstants.RECEIVER_PAY_ID, receiverPayId.toString());
            templateParamMap.put(JrdLinkConstants.NEXT_URL, nextUrl.toString());
            return link.href().orElse(resolveUrlTemplate(link.template().get(), templateParamMap));
          })
      );
  }

  private HttpUrl resolveUrlTemplate(String template, Map<String, String> templateParamMap) {
    String resolvedTemplate = template;
    for (String paramName : templateParamMap.keySet()) {
      resolvedTemplate =  template.replace("{" + paramName + "}", templateParamMap.get(paramName));
    }
    return HttpUrl.get(resolvedTemplate);
  }
}
