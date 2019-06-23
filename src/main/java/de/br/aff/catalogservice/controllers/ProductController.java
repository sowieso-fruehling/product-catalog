package de.br.aff.catalogservice.controllers;

import de.br.aff.catalogservice.domain.Product;
import de.br.aff.catalogservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getCatalogItems(Principal principal)
    {
        return productService.getProducts(principal.getName());
    }

}
