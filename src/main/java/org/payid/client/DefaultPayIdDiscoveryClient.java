package org.payid.client;

import com.google.common.primitives.UnsignedLong;
import feign.FeignException;
import okhttp3.HttpUrl;
import org.payid.client.jackson.ObjectMapperFactory;
import org.payid.client.model.discovery.JrdLinkConstants;
import org.payid.client.model.discovery.PayIdDiscoveryJrd;
import org.payid.client.model.payid.PayId;
import org.payid.client.model.problems.InvalidJrdLinkProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DefaultPayIdDiscoveryClient implements PayIdDiscoveryClient {

  private final PayIdDiscoveryNetworkClient payIdDiscoveryNetworkClient;

  public DefaultPayIdDiscoveryClient() {
    this.payIdDiscoveryNetworkClient = FeignPayIdDiscoveryNetworkClient.construct(
      ObjectMapperFactory.create()
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
            return link.href().orElseGet(() -> resolveUrlTemplate(link.template().get(), templateParamMap));
          })
          .orElse(payId.baseUrl())
      )
      .orElse(payId.baseUrl());
  }

  @Override
  public Optional<HttpUrl> getEasyCheckoutUrl(
    PayId payId,
    UnsignedLong amount,
    PayId receiverPayId,
    String assetCode,
    short assetScale,
    String paymentNetwork,
    HttpUrl nextUrl
  ) {
    return this.discoverPayId(payId)
      .flatMap(jrd ->
        jrd.links().stream()
          .filter(link -> link.rel().equals(JrdLinkConstants.EASY_CHECKOUT_REL))
          .findFirst()
          .map(link -> {
            Map<String, String> queryParamMap = new HashMap();
            queryParamMap.put(JrdLinkConstants.AMOUNT, amount.toString());
            queryParamMap.put(JrdLinkConstants.RECEIVER_PAY_ID, receiverPayId.toString());
            queryParamMap.put(JrdLinkConstants.ASSET_CODE, assetCode);
            queryParamMap.put(JrdLinkConstants.ASSET_SCALE, String.valueOf(assetScale));
            queryParamMap.put(JrdLinkConstants.PAYMENT_NETWORK, paymentNetwork);
            queryParamMap.put(JrdLinkConstants.NEXT_URL, nextUrl.toString());
            return link.href()
              .map(href -> assembleEasyCheckoutUrl(href, queryParamMap))
              .orElseThrow(() -> new InvalidJrdLinkProblem("Easy Checkout Links must have an `href` field", link));
          })
      );
  }

  private HttpUrl assembleEasyCheckoutUrl(HttpUrl href, Map<String, String> queryParamMap) {
    HttpUrl.Builder builder = href.newBuilder();
    queryParamMap.forEach(builder::addQueryParameter);
    return builder.build();
  }

  private HttpUrl resolveUrlTemplate(String template, Map<String, String> templateParamMap) {
    for (String paramName : templateParamMap.keySet()) {
      template = template.replace("{" + paramName + "}", templateParamMap.get(paramName));

    }
    return HttpUrl.get(template);
  }
}
