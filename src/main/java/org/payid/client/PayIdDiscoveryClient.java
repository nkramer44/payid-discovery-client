package org.payid.client;

import com.google.common.primitives.UnsignedLong;
import okhttp3.HttpUrl;
import org.payid.client.model.discovery.PayIdDiscoveryJrd;
import org.payid.client.model.payid.PayId;
import org.payid.client.model.problems.PayIdDiscoveryNotAvailableProblem;

import java.util.Optional;

/**
 * A client interface to perform PayID Discovery and PayID Easy Checkout Discovery.
 *
 * @see "https://github.com/payid-org/rfcs/blob/master/dist/spec/payid-discovery.txt"
 * TODO: update easy checkout rfc url
 * @see "https://github.com/payid-org/rfcs/blob/master/dist/spec/payid-easy-checkout.txt"
 */
public interface PayIdDiscoveryClient {

  /**
   * Translate a {@link PayId} to a PayID Discovery URL and query that URL to retrieve PayID Discovery metadata
   * in the form of a JRD (JSON Resource Descriptor).
   *
   * @param payId The {@link PayId} which PayID Discovery should be performed on.
   * @return A {@link PayIdDiscoveryJrd} containing metadata about the PayID, or {@link Optional#empty()} if
   *          the PayID server does not support PayID Discovery.
   */
  Optional<PayIdDiscoveryJrd> discoverPayId(PayId payId);

  /**
   * Use PayID Discovery to determine the PayID URL for the given {@link PayId}.
   *
   * @param payId The {@link PayId} which PayID Discovery should be performed on.
   * @return The {@link HttpUrl} representing a PayID URL.
   */
  HttpUrl getBasePayIdUrl(PayId payId);

  /**
   * Use PayID Discovery to retrieve the PayID Easy Checkout URI Template for the given PayID, and expand
   * that template with the given parameters, yielding a PayID Easy Checkout URL.
   *
   * @param payId The {@link PayId} which PayID Easy Checkout Discovery should be performed on.
   * @param amount The amount that should be sent.
   * @param receiverPayId The {@link PayId} of the receiver of the PayID Easy Checkout payment.
   * @param currency The currency that the Easy Checkout payment must be paid in.
   * @param network The network that the Easy Checkout payment must be paid over.
   * @param nextUrl The {@link HttpUrl} that should be used after an Easy Checkout payment has been sent.
   * @return An {@link HttpUrl} if the PayID Server supports PayID Easy Checkout.
   */
  Optional<HttpUrl> getEasyCheckoutUrl(
    PayId payId,
    UnsignedLong amount,
    PayId receiverPayId,
    String currency,
    String network,
    HttpUrl nextUrl
  );

}
