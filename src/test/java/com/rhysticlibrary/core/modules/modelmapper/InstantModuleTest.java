package com.rhysticlibrary.core.modules.modelmapper;

import com.rhysticlibrary.core.BaseComponent;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InstantModuleTest extends BaseComponent {

  private static final String ISO_8601_TIMESTAMP = "2024-02-19T06:59:19.220123Z";
  private static final Instant TIMESTAMP = Instant.parse(ISO_8601_TIMESTAMP);

  @Autowired
  private InstantModule instantModule;

  private static Stream<Arguments> provideSetupModuleData() {
    return Stream.of(
        Arguments.of(TIMESTAMP, String.class, ISO_8601_TIMESTAMP),
        Arguments.of(ISO_8601_TIMESTAMP, Instant.class, TIMESTAMP)
    );
  }

  @MethodSource("provideSetupModuleData")
  @ParameterizedTest
  public <T> void testSetupModule(Object source, Class<T> tClass, T expected) {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.registerModule(this.instantModule);

    T result = modelMapper.map(source, tClass);
    assertThat(result)
        .isEqualTo(expected);
  }
}
