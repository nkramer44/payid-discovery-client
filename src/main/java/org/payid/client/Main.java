package org.payid.client;

import com.google.common.primitives.UnsignedLong;
import okhttp3.HttpUrl;
import org.payid.client.model.payid.PayId;

import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    PayIdDiscoveryClient payIdDiscoveryClient = new DefaultPayIdDiscoveryClient();
    PayId payId = PayId.builder()
      .host("kramer.money")
      .account("pay")
      .build();

    PayId receiverPayId = PayId.builder()
      .host("xpring.money")
      .account("nkramer44")
      .build();

    Optional<HttpUrl> easyCheckoutUrl = payIdDiscoveryClient.getEasyCheckoutUrl(
      payId,
      UnsignedLong.ONE,
      receiverPayId,
      "XRP",
      (short) 6,
      "XRPL",
      HttpUrl.get("https://example.com/redirecturl")
    );
    easyCheckoutUrl.ifPresent(System.out::println);
  }
}
