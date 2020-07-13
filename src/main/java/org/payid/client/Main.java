package org.payid.client;

import com.google.common.primitives.UnsignedLong;
import okhttp3.HttpUrl;
import org.payid.client.model.payid.PayId;

public class Main {

  public static void main(String[] args) {
    PayIdDiscoveryClient payIdDiscoveryClient = new DefaultPayIdDiscoveryClient();
    PayId payId = PayId.builder()
      .host("")
      .account("")
      .build();

    PayId receiverPayId = PayId.builder()
      .host("")
      .account("")
      .build();

//    payIdDiscoveryClient.getEasyCheckoutUrl(payId, UnsignedLong.ONE, receiverPayId, HttpUrl.get("https://example.com/redirecturl"));
  }
}
