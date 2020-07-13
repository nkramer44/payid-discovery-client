package org.payid.client.model.problems;

import org.payid.client.model.payid.PayId;
import org.zalando.problem.Status;

import java.net.URI;

public class PayIdDiscoveryNotAvailableProblem extends AbstractPayIdClientProblem {
  public static final String DISCOVERY_PATH = "payid-discovery";

  public PayIdDiscoveryNotAvailableProblem(PayId payId) {
    this("", payId);
  }

  public PayIdDiscoveryNotAvailableProblem(String detail, PayId payId) {
    super(
      URI.create(TYPE_PREFIX + DISCOVERY_PATH + "/interactive-mode-unavailable"),
      "The given PayId (" + payId.toString() + ") does not support interactive discovery.",
      Status.NOT_IMPLEMENTED,
      detail
    );
  }
}
