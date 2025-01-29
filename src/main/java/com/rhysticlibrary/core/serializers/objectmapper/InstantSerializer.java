package com.rhysticlibrary.core.serializers.objectmapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * Serializes Instants when using ObjectMapper to an ISO timestamp.
 */
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public final class InstantSerializer extends JsonSerializer<Instant> {

  /**
   * {@inheritDoc}
   */
  @Override
  public void serialize(
      Instant instant,
      JsonGenerator jsonGenerator,
      SerializerProvider serializerProvider
  ) throws IOException {
    String formattedInstant = DateTimeFormatter.ISO_INSTANT.format(instant);
    jsonGenerator.writeString(formattedInstant);
  }
}
