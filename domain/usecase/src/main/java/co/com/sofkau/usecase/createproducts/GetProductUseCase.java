package co.com.sofkau.usecase.createproducts;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.model.products.gateways.ProductsRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetProductUseCase {

    private final ProductsRepository productsRepository;

    public Mono<Products> execute (String id){
        return productsRepository.getProductId(id);
    }
}
