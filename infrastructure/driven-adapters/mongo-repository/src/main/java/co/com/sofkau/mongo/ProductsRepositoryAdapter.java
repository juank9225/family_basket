package co.com.sofkau.mongo;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.model.products.gateways.ProductsRepository;
import co.com.sofkau.mongo.entity.ProductsEntity;
import co.com.sofkau.mongo.helper.AdapterOperations;
import co.com.sofkau.mongo.helper.ProductsMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public class ProductsRepositoryAdapter extends AdapterOperations<Products, ProductsEntity, String, ProductsDBRepository>
implements ProductsRepository
{
    public ProductsRepositoryAdapter(ProductsDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper,ProductsMapper::convertidos);
    }

    @Override
    public Mono<Products> addProducts(Products products) {
        return save(products);
    }

    @Override
    public Flux<Products> listProducts() {
        return findAll();
    }

    @Override
    public Mono<Products> getProductId(String id) {
        return findById(id);
    }

    @Override
    public Mono<Products> updateProducts(Products products) {
        return save(products);
    }

    @Override
    public Mono<Void> deleteProducts(String id) {
        return deleteById(id).then(Mono.empty());
    }

}
