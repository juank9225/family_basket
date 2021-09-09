package co.com.sofkau.api;

import co.com.sofkau.api.dtos.ProductsDTO;
import co.com.sofkau.api.mapper.MapperProducts;
import co.com.sofkau.usecase.createproducts.CreateProductsUseCase;
import co.com.sofkau.usecase.createproducts.ListProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final CreateProductsUseCase createProductsUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final MapperProducts mapperProducts;

    public Mono<ProductsDTO> createProducts(ProductsDTO productsDT){
        return createProductsUseCase.execute(mapperProducts.productsDTO().apply(productsDTO)).map(mapperProducts.toDTO());
    }

    public Flux<ProductsDTO> listProducts(){
        return listProductsUseCase.execute().map(mapperProducts.toDTO());
    }



}
