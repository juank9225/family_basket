package co.com.sofkau.mongo.helper;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.mongo.entity.ProductsEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductsMapper {

    public static Products convertidos(ProductsEntity productsEntity){
        return Products.builder()
                .id(productsEntity.getId())
                .codigo(productsEntity.getCodigo())
                .nombre(productsEntity.getNombre())
                .precio(productsEntity.getPrecio())
                .lote(productsEntity.getLote())
                .build();
    }
}
