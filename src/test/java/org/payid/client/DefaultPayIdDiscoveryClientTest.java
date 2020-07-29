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
    easyCheckoutUrl = HttpUrl.get("https://wallet.example.com/wallet");

    mockJrd = PayIdDiscoveryJrd.builder()
      .subject(examplePayId)
      .addLinks(
        PayIdDiscoveryLink.builder()
          .rel(JrdLinkConstants.PAYID_DISCOVERY_REL)
          .href(payIdUrl)
          .build(),
        PayIdDiscoveryLink.builder()
          .rel(JrdLinkConstants.EASY_CHECKOUT_REL)
          .href(easyCheckoutUrl)
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
    String assetCode = "XRP";
    short assetScale = 6;
    String paymentNetwork = "XRPL";
    HttpUrl nextUrl = HttpUrl.get("https://merchant.com/thank-you");
    HttpUrl expectedAssembledEasyCheckoutUrl = easyCheckoutUrl.newBuilder()
      .addQueryParameter("amount", amount.toString())
      .addQueryParameter("receiverPayId", receiverPayId.toString())
      .addQueryParameter("assetCode", assetCode)
      .addQueryParameter("assetScale", String.valueOf(assetScale))
      .addQueryParameter("paymentNetwork", paymentNetwork)
      .addQueryParameter("nextUrl", nextUrl.toString())
      .build();

    Optional<HttpUrl> url = payIdDiscoveryClient.getEasyCheckoutUrl(
      examplePayId,
      amount,
      receiverPayId,
      assetCode,
      assetScale,
      paymentNetwork,
      nextUrl
    );

    assertThat(url).isNotEmpty();
    assertThat(url.get().scheme()).isEqualTo(expectedAssembledEasyCheckoutUrl.scheme());
    assertThat(url.get().host()).isEqualTo(expectedAssembledEasyCheckoutUrl.host());
    assertThat(url.get().pathSegments()).isEqualTo(expectedAssembledEasyCheckoutUrl.pathSegments());
    assertThat(url.get().queryParameter("amount")).isEqualTo(expectedAssembledEasyCheckoutUrl.queryParameter("amount"));
    assertThat(url.get().queryParameter("receiverPayId")).isEqualTo(expectedAssembledEasyCheckoutUrl.queryParameter("receiverPayId"));
    assertThat(url.get().queryParameter("assetCode")).isEqualTo(expectedAssembledEasyCheckoutUrl.queryParameter("assetCode"));
    assertThat(url.get().queryParameter("assetScale")).isEqualTo(expectedAssembledEasyCheckoutUrl.queryParameter("assetScale"));
    assertThat(url.get().queryParameter("paymentNetwork")).isEqualTo(expectedAssembledEasyCheckoutUrl.queryParameter("paymentNetwork"));
    assertThat(url.get().queryParameter("nextUrl")).isEqualTo(expectedAssembledEasyCheckoutUrl.queryParameter("nextUrl"));
  }
}
