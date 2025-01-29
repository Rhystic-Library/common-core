package com.rhysticlibrary.core.providers;

import lombok.NonNull;

/**
 * Provider interface that returns objects of the defined type.
 *
 * @param <T> The type of object the provider should return.
 */
public interface Provider<T> {

  /**
   * @return the define type of the provider.
   */
  @NonNull
  T provide();
}
