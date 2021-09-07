package co.com.sofkau.mongo.helper;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.mongo.entity.ProductsEntity;

import java.util.function.Function;

public class ProductsMapper {
    public Function<ProductsEntity, Products> fromProductsEntity(){
        return newEntity->new Products(
                newEntity.getId(),
                newEntity.getCodigo(),
                newEntity.getNombre(),
                newEntity.getPrecio(),
                newEntity.getLote()
        );
    }

    public Function<Products,ProductsEntity> fromProducts(){
        return newProducts->new ProductsEntity(
                newProducts.getId(),
                newProducts.getCodigo(),
                newProducts.getNombre(),
                newProducts.getPrecio(),
                newProducts.getLote()
        );
    }
}
