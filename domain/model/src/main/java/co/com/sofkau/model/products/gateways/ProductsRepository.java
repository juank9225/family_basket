package co.com.sofkau.model.products.gateways;

import co.com.sofkau.model.products.Products;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductsRepository {
    Mono<Products> addProducts(Products products);

    Flux<Products> listProducts();
}
