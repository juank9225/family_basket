package co.com.sofkau.api;

import co.com.sofkau.api.dtos.ProductsDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class Router {
@Bean
public RouterFunction<ServerResponse> createProduct(Handler handler) {
    return route(POST("/api/product/create").and(accept(MediaType.APPLICATION_JSON)),
            request -> request.bodyToMono(ProductsDTO.class)
                    .flatMap(productsDTO -> handler
                            .createProducts(productsDTO)
                            .flatMap(result-> ServerResponse.ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(result))));
            }
}
