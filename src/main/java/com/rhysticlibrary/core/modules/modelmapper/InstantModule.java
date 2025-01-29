package com.rhysticlibrary.core.modules.modelmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * Adds mapping capability of Instants to ModelMapper
 */
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public final class InstantModule implements Module {

  private final ObjectMapper objectMapper;

  /**
   * {@inheritDoc}
   */
  @Override
  public void setupModule(ModelMapper modelMapper) {
    modelMapper.typeMap(Instant.class, String.class)
        .setConverter(ctx -> this.objectMapper.convertValue(ctx.getSource(), String.class));
    modelMapper.typeMap(String.class, Instant.class)
        .setConverter(ctx -> this.objectMapper.convertValue(ctx.getSource(), Instant.class));
    modelMapper.typeMap(Instant.class, Instant.class)
        .setConverter(ctx -> this.objectMapper.convertValue(
            this.objectMapper.convertValue(ctx.getSource(), String.class), Instant.class)
        );
  }
}
