package co.com.sofkau.usecase.createproducts;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.model.products.gateways.ProductsRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListProductsUseCase {

    private final ProductsRepository productsRepository;

    public Flux<Products> execute (){
        return productsRepository.listProducts();
    }
}
