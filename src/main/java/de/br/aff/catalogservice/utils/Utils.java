package de.br.aff.catalogservice.utils;

import de.br.aff.catalogservice.domain.Product;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public final class Utils {

  public static String getResourceLocation(Product createdProduct) {
    return ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(createdProduct.getId())
        .toUriString();
  }
}
