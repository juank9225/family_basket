package co.com.sofkau.api;
import co.com.sofkau.api.dtos.ProductsDTO;
import co.com.sofkau.usecase.createproducts.CreateProductsUseCase;
import co.com.sofkau.usecase.createproducts.ListProductsUseCase;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/product",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ProductsController {

    private final CreateProductsUseCase createProductsUseCase;
    private final ListProductsUseCase listProductsUseCase;

    @PostMapping(path = "/crear")
    public Mono<ProductsDTO> guardarProducts(@RequestBody ProductsDTO productsDTO){
        return createProductsUseCase.execute(ProductsDTO.convertirDTOADominioCreacion(productsDTO))
                .map(ProductsDTO::convertidorDominioADTO);
    }

    @GetMapping(path = "/list")
    public Flux<ProductsDTO> listarProductos(){
        return listProductsUseCase.execute().map(ProductsDTO::convertidorDominioADTO);
    }

}
