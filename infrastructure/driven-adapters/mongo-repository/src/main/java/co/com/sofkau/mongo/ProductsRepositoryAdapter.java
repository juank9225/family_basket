package co.com.sofkau.mongo;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.model.products.gateways.ProductsRepository;
import co.com.sofkau.mongo.entity.ProductsEntity;
import co.com.sofkau.mongo.helper.AdapterOperations;
import co.com.sofkau.mongo.helper.ProductsMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ProductsRepositoryAdapter extends AdapterOperations<ProductsEntity, ProductsEntity, String, ProductsDBRepository>
implements ProductsRepository
{

    private ProductsMapper mapper = new ProductsMapper();

    public ProductsRepositoryAdapter(ProductsDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, ProductsEntity.class));
    }

    @Override
    public Mono<Products> addProducts(Products products) {
        return this.repository.save(mapper.fromProducts().apply(products)).map(mapper.fromProductsEntity());
    }
}
