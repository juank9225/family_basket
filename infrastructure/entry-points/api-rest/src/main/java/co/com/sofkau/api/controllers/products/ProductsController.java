package co.com.sofkau.api.controllers.products;
import co.com.sofkau.api.controllers.products.dtos.ProductsDTO;
import co.com.sofkau.usecase.createproducts.CreateProductsUseCase;
import co.com.sofkau.usecase.createproducts.GetProductUseCase;
import co.com.sofkau.usecase.createproducts.ListProductsUseCase;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ProductsController {

    private final CreateProductsUseCase createProductsUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final GetProductUseCase getProductUseCase;

    @PostMapping(path = "/product/crear")
    public Mono<ProductsDTO> guardarProducts(@RequestBody ProductsDTO productsDTO){
        return createProductsUseCase.execute(ProductsDTO.convertirDTOADominioCreacion(productsDTO))
                .map(ProductsDTO::convertidorDominioADTO);
    }

    @GetMapping(path = "/product/list")
    public ResponseEntity<Flux<ProductsDTO>> listarProductos(){
        return new  ResponseEntity(listProductsUseCase.execute().map(ProductsDTO::convertidorDominioADTO), HttpStatus.OK);
    }

    @GetMapping(path = "/product/getproducto/{id}")
    public ResponseEntity<Mono<ProductsDTO>> getProduct(@PathVariable("id")  String id){   return new ResponseEntity(getProductUseCase.execute(id).map(ProductsDTO::convertidorDominioADTO), HttpStatus.OK);
    }

}
