package com.rhysticlibrary.core.providers;

import com.rhysticlibrary.core.BaseComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

final class UUIDProviderTest extends BaseComponent {

  @Autowired
  private UUIDProvider uuidProvider;

  @Test
  void testProvide() {
    assertThat(this.uuidProvider.provide())
        .isInstanceOf(UUID.class)
        .isNotEqualTo(this.uuidProvider.provide());
  }
}