package org.payid.client.model.discovery;

import okhttp3.HttpUrl;

public class JrdLinkConstants {

  public static final HttpUrl PAYID_DISCOVERY_REL = HttpUrl.get("https://payid.org/ns/payid-discovery-url/1.0");
  public static final HttpUrl EASY_CHECKOUT_REL = HttpUrl.get("https://payid.org/ns/easy-checkout-url/1.0");

  public static final String ACCT_PART = "acctPart";
  public static final String AMOUNT = "amount";
  public static final String RECEIVER_PAY_ID = "receiverPayId";
  public static final String ASSET_CODE = "assetCode";
  public static final String ASSET_SCALE = "assetScale";
  public static final String PAYMENT_NETWORK = "paymentNetwork";
  public static final String NEXT_URL = "nextUrl";

}
