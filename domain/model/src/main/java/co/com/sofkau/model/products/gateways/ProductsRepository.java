package co.com.sofkau.model.products.gateways;

import co.com.sofkau.model.products.Products;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductsRepository {
    //Casos de uso
    Mono<Products> addProducts(Products products);
    Flux<Products> listProducts();
    Mono<Products> getProductId(String id);
    Mono<Products> updateProducts(Products products);
    Mono<Void> deleteProducts(String id);
    Mono<Products> getProductCode(String code);
}
