package co.com.sofkau.api;

import co.com.sofkau.api.dtos.ProductsDTO;
import co.com.sofkau.api.mapper.ProductsMapper;
import co.com.sofkau.usecase.createproducts.CreateProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final CreateProductsUseCase createProductsUseCase;
    private final ProductsMapper productsMapper;

    public Mono<ProductsDTO> createProducts(ProductsDTO productsDTO){
        return createProductsUseCase.execute(productsMapper.productsDTO().apply(productsDTO)).map(productsMapper.toDTO());
    }

}
