package co.com.sofkau.api.controllers.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public abstract class ControllerBase {

    protected <T> ResponseEntity<List<T>> validarLista(List<T> lista){
        HttpStatus httpStatus = lista.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity
                .status(httpStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(lista);
    }

    protected <T> Mono<ResponseEntity<T>> validarEntidad(Mono<T> valor){
        return valor.map(entidad -> ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(entidad))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).build()));
    }

}
