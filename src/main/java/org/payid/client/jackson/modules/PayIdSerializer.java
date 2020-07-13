package org.payid.client.jackson.modules;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import org.payid.client.model.payid.PayId;

import java.io.IOException;

/**
 * Jackson serializer {@link PayId}.
 */
public class PayIdSerializer extends StdScalarSerializer<PayId> {

  public PayIdSerializer() {
    super(PayId.class, false);
  }

  @Override
  public void serialize(PayId PayId, JsonGenerator gen, SerializerProvider provider) throws IOException {
    gen.writeString(PayId.toString());
  }
}
