package co.com.sofkau.api.mapper;

import co.com.sofkau.api.dtos.ProductsDTO;
import co.com.sofkau.model.products.Products;

import java.util.function.Function;

public class ProductsMapper {
    public Function<Products, ProductsDTO> toDTO(){
        return products -> new ProductsDTO(
                products.getId(),
                products.getCodigo(),
                products.getNombre(),
                products.getPrecio(),
                products.getLote()
        );
    }

    public Function<ProductsDTO,Products> productsDTO(){
        return productsDTO -> new Products(
                productsDTO.getId(),
                productsDTO.getCodigo(),
                productsDTO.getNombre(),
                productsDTO.getPrecio(),
                productsDTO.getLote()
        );
    }
}
