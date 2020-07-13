package org.payid.client;

import org.payid.client.model.discovery.PayIdDiscoveryJrd;
import org.payid.client.model.payid.PayId;

import java.net.URI;

public interface PayIdDiscoveryNetworkClient {

  PayIdDiscoveryJrd getPayIdJrd(URI baseUri, PayId payId);
}
