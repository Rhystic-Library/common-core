package com.rhysticlibrary.core.providers;

import com.rhysticlibrary.core.BaseComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

final class InstantProviderTest extends BaseComponent {

  @Autowired
  private InstantProvider instantProvider;

  @Test
  void testProvide() {
    Instant before = Instant.now();
    assertThat(this.instantProvider.provide())
        .isAfterOrEqualTo(before)
        .isBeforeOrEqualTo(Instant.now());
  }
}