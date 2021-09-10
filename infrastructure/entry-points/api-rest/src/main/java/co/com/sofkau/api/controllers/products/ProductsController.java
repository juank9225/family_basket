package co.com.sofkau.api.controllers.products;
import co.com.sofkau.api.controllers.products.dtos.ProductsDTO;
import co.com.sofkau.usecase.createproducts.*;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(value = "/api/product",produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ProductsController {

    private final CreateProductsUseCase createProductsUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final GetProductUseCase getProductUseCase;
    private final UpdateProductsUseCase updateProductsUseCase;
    private final DeleteProductsUseCase deleteProductsUseCase;
    private final DeleteByCodeUseCase deleteByCodeUseCase;
    private final GetProductCodeUseCase getProductCodeUseCase;

    @PostMapping(path = "/crear")
    public Mono<ProductsDTO> guardarProducts(@RequestBody ProductsDTO productsDTO){
        return createProductsUseCase.execute(ProductsDTO.convertirDTOADominioCreacion(productsDTO))
                .map(ProductsDTO::convertidorDominioADTO);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<Flux<ProductsDTO>> listarProductos(){
        return new  ResponseEntity(listProductsUseCase.execute().map(ProductsDTO::convertidorDominioADTO), HttpStatus.OK);
    }

    @GetMapping(path = "/getproducto/{id}")
    public ResponseEntity<Mono<ProductsDTO>> getProduct(@PathVariable("id")  String id){   return new ResponseEntity(getProductUseCase.execute(id).map(ProductsDTO::convertidorDominioADTO), HttpStatus.OK);
    }

    @PutMapping(path = "/actualizar")
    public ResponseEntity<Mono<ProductsDTO>> updateProducts(@RequestBody ProductsDTO productsDTO){
        return new ResponseEntity(updateProductsUseCase.execute(ProductsDTO.convertirDTOADominioCreacion(productsDTO))
                .map(ProductsDTO::convertidorDominioADTO), HttpStatus.OK);
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<Mono<Void>> deleteProducts(@PathVariable("id")  String id){
        return new ResponseEntity(deleteProductsUseCase.execute(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/eliminarcode/{code}")
    public ResponseEntity<Mono<ProductsDTO>> deleteProductsByCode(@PathVariable("code")  String code){
        return new ResponseEntity(deleteByCodeUseCase.execute(code).map(ProductsDTO::convertidorDominioADTO), HttpStatus.OK);
    }

    @GetMapping(path = "/getcode/{code}")
    public ResponseEntity<Mono<ProductsDTO>> get(@PathVariable("code")  String code){   return new ResponseEntity(getProductCodeUseCase.execute(code).map(ProductsDTO::convertidorDominioADTO), HttpStatus.OK);
    }
}
