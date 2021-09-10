package co.com.sofkau.usecase.createproducts;

import co.com.sofkau.model.products.gateways.ProductsRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteProductsUseCase {

    private final ProductsRepository productsRepository;

    public Mono<Void> execute (String idProductId){
        return productsRepository.getProductId(idProductId)
                .flatMap(product -> productsRepository.deleteProducts(product.getId()));
    }
}
