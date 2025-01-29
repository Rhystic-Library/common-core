package com.rhysticlibrary.core.providers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * A Provider that can be used to return UUIDs
 */
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public final class UUIDProvider implements Provider<UUID> {

  /**
   * @return a random UUID.
   */
  @Override
  public @NonNull UUID provide() {
    return UUID.randomUUID();
  }
}
