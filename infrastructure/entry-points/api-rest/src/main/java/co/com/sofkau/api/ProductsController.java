package co.com.sofkau.api;
import co.com.sofkau.api.dtos.ProductsDTO;
import co.com.sofkau.usecase.createproducts.CreateProductsUseCase;
import co.com.sofkau.usecase.createproducts.ListProductsUseCase;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/product",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ProductsController {

    private final CreateProductsUseCase createProductsUseCase;
    private final ListProductsUseCase listProductsUseCase;

    @PostMapping(path = "/crear")
    public Mono<ProductsDTO> guardarProducts(@RequestBody ProductsDTO productsDTO){
        return createProductsUseCase.execute(ProductsDTO.convertirDTOADominioCreacion(productsDTO))
                .map(ProductsDTO::convertidorDominioADTO);
    }

}
