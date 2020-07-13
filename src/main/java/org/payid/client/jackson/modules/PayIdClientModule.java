package org.payid.client.jackson.modules;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.payid.client.model.payid.PayId;

/**
 * A Jackson {@link SimpleModule} for serializing and deserializing XRP Mall typed identifiers.
 */
public class PayIdClientModule extends SimpleModule {

  private static final String NAME = "XrpMallIdsModule";

  /**
   * No-args Constructor.
   */
  public PayIdClientModule() {
    super(
      NAME,
      new Version(1, 0, 0, null, "io.xpring.demo.xrpmall",
        "xrpmall-ids")
    );

    addSerializer(PayId.class, new PayIdSerializer());
    addDeserializer(PayId.class, new PayIdDeserializer());
  }
}
