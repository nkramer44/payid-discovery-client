package org.payid.client;

import com.google.common.primitives.UnsignedLong;
import okhttp3.HttpUrl;
import org.payid.client.model.discovery.PayIdDiscoveryJrd;
import org.payid.client.model.payid.PayId;
import org.payid.client.model.problems.PayIdDiscoveryNotAvailableProblem;

import java.util.Optional;

public interface PayIdDiscoveryClient {

  Optional<PayIdDiscoveryJrd> discoverPayId(PayId payId) throws PayIdDiscoveryNotAvailableProblem;

  HttpUrl getBasePayIdUrl(PayId payId);

  Optional<HttpUrl> getEasyCheckoutUrl(PayId payId, UnsignedLong amount, PayId receiverPayId, HttpUrl nextUrl);

}
