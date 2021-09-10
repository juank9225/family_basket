package co.com.sofkau.usecase.createproducts;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.model.products.gateways.ProductsRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteByCodeUseCase {

    private final ProductsRepository productsRepository;

    public Mono<Products> execute(String code){
        return productsRepository.getProductCode(code)
                .flatMap(product -> productsRepository.deleteByCode(product.getCodigo()));
    }
}
