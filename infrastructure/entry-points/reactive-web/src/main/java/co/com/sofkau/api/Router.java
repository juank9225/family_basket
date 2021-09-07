package co.com.sofkau.api;

import co.com.sofkau.api.dtos.ProductsDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
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
                            .flatMap(result-> ServerResponse.ok()//ServerResponse.created(URI.create("/create))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(result))));
            }

@Bean
public RouterFunction<ServerResponse> listProduct(Handler handler){
    return route(GET( "api/product/list").and(accept(MediaType.APPLICATION_JSON))
            ,request -> ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON)
                    //.body(handler.listProducts(), PersonDTO.class));
            .body(BodyInserters.fromPublisher(handler.listProducts(), ProductsDTO.class)));
}

}
