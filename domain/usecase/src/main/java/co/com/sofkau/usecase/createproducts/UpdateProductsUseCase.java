package co.com.sofkau.usecase.createproducts;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.model.products.gateways.ProductsRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateProductsUseCase {

    private final ProductsRepository productsRepository;

    public Mono<Products> execute(Products products){
        return productsRepository.getProductId(products.getId())
                .flatMap(product -> productsRepository.updateProducts(product.toBuilder()
                                .nombre(products.getNombre())
                                .codigo(products.getCodigo())
                                .precio(products.getPrecio())
                                .lote(products.getLote())
                        .build()))
                .switchIfEmpty(Mono.error(new IllegalAccessError("Producto no encontrado")));


    }
}
