package co.com.sofkau.mongo;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.mongo.entity.ProductsEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

public interface ProductsDBRepository extends ReactiveMongoRepository<ProductsEntity, String>, ReactiveQueryByExampleExecutor<ProductsEntity> {
    //@Transactional(readOnly = false)
    Mono<Products> findByCodigo (String code);
}
