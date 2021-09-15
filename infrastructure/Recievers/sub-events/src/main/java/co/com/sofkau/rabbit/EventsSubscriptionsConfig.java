package co.com.sofkau.rabbit;

import co.com.sofkau.model.products.Products;
import co.com.sofkau.usecase.createproducts.CreateProductsUseCase;
import co.com.sofkau.usecase.createproducts.DeleteProductsUseCase;
import co.com.sofkau.usecase.createproducts.UpdateProductsUseCase;
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
    //Casos de uso
    private final CreateProductsUseCase createProductsUseCase;
    private final DeleteProductsUseCase deleteProductsUseCase;
    private final UpdateProductsUseCase updateProductsUseCase;
    //Constantes (Routing Keys)
    private static final String CREATE_PRODUCT = "create.product";
    private static final String DELETE_PRODCUT = "delete.product";
    private static final String UPDATE_PRODCUT = "update.product";

    @Bean
    public HandlerRegistry eventSubscriptions() {
        return register().listenEvent(CREATE_PRODUCT, event -> createProductsUseCase.executeEvent(Products.builder()
                .codigo(event.getData().getCodigo())
                .nombre(event.getData().getNombre())
                .lote(event.getData().getLote())
                .precio(event.getData().getPrecio())
                .build()), Products.class);
    }

    @Bean
    public HandlerRegistry eventSubscriptionsDelete(){
        return register().listenEvent(DELETE_PRODCUT, event -> deleteProductsUseCase.execute(event.getData().getId()),Products.class);
    }

    @Bean
    public HandlerRegistry eventSubscriptionsUpdate(){
        return register().listenEvent(UPDATE_PRODCUT,event->updateProductsUseCase.executeEvents(Products.builder()
                .id(event.getData().getId())
                .codigo(event.getData().getCodigo())
                .nombre(event.getData().getNombre())
                .lote(event.getData().getLote())
                .precio(event.getData().getPrecio())
                .build()),Products.class);
    }

}