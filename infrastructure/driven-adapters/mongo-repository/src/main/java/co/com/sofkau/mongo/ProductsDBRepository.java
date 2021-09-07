package co.com.sofkau.mongo;

import co.com.sofkau.mongo.entity.ProductsEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface ProductsDBRepository extends ReactiveMongoRepository<ProductsEntity, String>, ReactiveQueryByExampleExecutor<ProductsEntity> {
}
