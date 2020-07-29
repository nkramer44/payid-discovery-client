package org.payid.client.model.problems;

import org.payid.client.model.discovery.PayIdDiscoveryLink;
import org.zalando.problem.Status;

import java.net.URI;

public class InvalidJrdLinkProblem extends AbstractPayIdClientProblem {
  public static final String DISCOVERY_PATH = "payid-discovery";

  public InvalidJrdLinkProblem(PayIdDiscoveryLink link) {
    this("", link);
  }

  public InvalidJrdLinkProblem(String detail, PayIdDiscoveryLink link) {
    super(
      URI.create(TYPE_PREFIX + DISCOVERY_PATH + "/invalid-discovery-link"),
      "The PayID Discovery Link is invalid. link = " + link.toString(),
      Status.PRECONDITION_FAILED,
      detail
    );
  }
}
