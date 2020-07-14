package org.payid.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.common.primitives.UnsignedLong;
import okhttp3.HttpUrl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.payid.client.model.discovery.JrdLinkConstants;
import org.payid.client.model.discovery.PayIdDiscoveryJrd;
import org.payid.client.model.discovery.PayIdDiscoveryLink;
import org.payid.client.model.payid.PayId;

import java.util.Optional;

public class DefaultPayIdDiscoveryClientTest {

  private PayIdDiscoveryClient payIdDiscoveryClient;

  private PayId examplePayId;
  @Mock
  private PayIdDiscoveryNetworkClient mockPayIdDiscoveryNetworkClient;
  private PayIdDiscoveryJrd mockJrd;
  private HttpUrl payIdUrl;
  private String easyCheckoutTemplate;
  private HttpUrl easyCheckoutUrl;

  @Before
  public void setUp() {
    initMocks(this);
    payIdDiscoveryClient = new DefaultPayIdDiscoveryClient(mockPayIdDiscoveryNetworkClient);

    examplePayId = PayId.builder()
      .host("test.example.com")
      .account("alice")
      .build();
    payIdUrl = HttpUrl.get("https://payid.example.com/alice");
    easyCheckoutTemplate = "https://wallet.example.com/wallet?amount={amount}&receiverPayId={receiverPayId}&currency={currency}&network={network}&nextUrl={nextUrl}";

    mockJrd = PayIdDiscoveryJrd.builder()
      .subject(examplePayId)
      .addLinks(
        PayIdDiscoveryLink.builder()
          .rel(JrdLinkConstants.PAYID_DISCOVERY_REL)
          .href(payIdUrl)
          .build(),
        PayIdDiscoveryLink.builder()
          .rel(JrdLinkConstants.EASY_CHECKOUT_REL)
          .template(easyCheckoutTemplate)
          .build())
      .build();
  }

  @Test
  public void testDiscoverPayId() {
    when(mockPayIdDiscoveryNetworkClient.getPayIdJrd(eq(examplePayId.baseUrl().uri()), eq(examplePayId)))
      .thenReturn(mockJrd);
    Optional<PayIdDiscoveryJrd> jrd = payIdDiscoveryClient.discoverPayId(examplePayId);
    assertThat(jrd).isNotEmpty().get().isEqualTo(mockJrd);
  }

  @Test
  public void testDiscoverBasePayIdUrl() {
    when(mockPayIdDiscoveryNetworkClient.getPayIdJrd(eq(examplePayId.baseUrl().uri()), eq(examplePayId)))
      .thenReturn(mockJrd);
    HttpUrl basePayIdUrl = payIdDiscoveryClient.getBasePayIdUrl(examplePayId);
    assertThat(basePayIdUrl).isEqualTo(payIdUrl);
  }

  @Test
  public void testGetEasyCheckoutUrl() {
    when(mockPayIdDiscoveryNetworkClient.getPayIdJrd(eq(examplePayId.baseUrl().uri()), eq(examplePayId)))
      .thenReturn(mockJrd);

    UnsignedLong amount = UnsignedLong.ONE;
    PayId receiverPayId = PayId.of("pay$merchant.com");
    String currency = "XRP";
    String network = "XRPL";
    HttpUrl nextUrl = HttpUrl.get("https://merchant.com/thank-you");
    easyCheckoutUrl = HttpUrl.get(String.format("https://wallet.example.com/wallet?amount=%s&receiverPayId=%s&currency=%s&network=%s&nextUrl=%s",
      amount,
      receiverPayId,
      currency,
      network,
      nextUrl
    ));
    Optional<HttpUrl> url = payIdDiscoveryClient.getEasyCheckoutUrl(
      examplePayId,
      amount,
      receiverPayId,
      currency,
      network,
      nextUrl
    );

    assertThat(url).isNotEmpty().get().isEqualTo(easyCheckoutUrl);
  }
}
