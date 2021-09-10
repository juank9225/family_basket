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
                .flatMap(product1 -> {
                            product1.setId(products.getId());
                            product1.setNombre(products.getNombre());
                            product1.setCodigo(products.getCodigo());
                            product1.setPrecio(products.getPrecio());
                            product1.setLote(products.getLote());
                            return productsRepository.updateProducts(product1);
                })
                .switchIfEmpty(Mono.error(new IllegalAccessError("Producto no encontrado")));


    }
}
