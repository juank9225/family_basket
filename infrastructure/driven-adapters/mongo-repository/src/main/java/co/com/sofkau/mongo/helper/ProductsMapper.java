package co.com.sofkau.mongo.helper;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.mongo.entity.ProductsEntity;
import com.mongodb.annotations.Beta;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
