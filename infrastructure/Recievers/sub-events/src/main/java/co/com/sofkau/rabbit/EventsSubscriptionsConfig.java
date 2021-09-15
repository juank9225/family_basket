package co.com.sofkau.rabbit;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.usecase.createproducts.CreateProductsUseCase;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.api.HandlerRegistry;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableMessageListeners;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.reactivecommons.async.api.HandlerRegistry.register;

@Configuration
@EnableDomainEventBus
@EnableMessageListeners
@EnableDirectAsyncGateway
@RequiredArgsConstructor
public class EventsSubscriptionsConfig {

    private final CreateProductsUseCase createProductsUseCase;
    private static final String CREATE_PRODUCT = "create.product";
    private static final String DELETE_PRODCUT = "delete.product";

    @Bean
    public HandlerRegistry eventSubscriptions() {
        return register().listenEvent(CREATE_PRODUCT, event -> createProductsUseCase.execute2(Products.builder()
                .codigo(event.getData().getCodigo())
                .nombre(event.getData().getNombre())
                .lote(event.getData().getLote())
                .precio(event.getData().getPrecio())
                .build()), Products.class);
    }

}