package com.rhysticlibrary.core.providers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * A Provider that can be used to return Instants
 */
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public final class InstantProvider implements Provider<Instant> {

  /**
   * @return the current timestamp
   */
  @Override
  public @NonNull Instant provide() {
    return Instant.now();
  }
}
