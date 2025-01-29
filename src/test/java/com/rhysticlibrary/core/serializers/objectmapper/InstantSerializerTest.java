package com.rhysticlibrary.core.serializers.objectmapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.rhysticlibrary.core.BaseComponent;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class InstantSerializerTest extends BaseComponent {

  private static final AtomicLong EPOC_SECOND = new AtomicLong(0);
  @Autowired
  private InstantSerializer instantSerializer;
  @Mock
  private JsonGenerator jsonGeneratorMock;
  @Mock
  private SerializerProvider serializerProviderMock;

  @Test
  void serializeTest() throws IOException {
    Instant timestamp = Instant.ofEpochSecond(EPOC_SECOND.incrementAndGet());
    String expectedFormattedTimestamp = DateTimeFormatter.ISO_INSTANT.format(timestamp);

    this.instantSerializer.serialize(timestamp, this.jsonGeneratorMock, this.serializerProviderMock);

    verify(this.jsonGeneratorMock, times(1))
        .writeString(expectedFormattedTimestamp);
  }
}
