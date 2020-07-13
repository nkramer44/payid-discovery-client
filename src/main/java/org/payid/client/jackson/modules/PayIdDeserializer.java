package org.payid.client.jackson.modules;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.payid.client.model.payid.PayId;

import java.io.IOException;

/**
 * Jackson deserializer for {@link PayId}.
 */
public class PayIdDeserializer extends StdDeserializer<PayId> {

  protected PayIdDeserializer() {
    super(PayId.class);
  }

  @Override
  public PayId deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
    return PayId.of(jsonParser.getText());
  }
}
