package co.com.sofkau.rabbit;

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

    //private final PersonUseCase personUseCase;
    //private static final String CREATE_PERSON = "create.person";
    //private static final String DELETE_PERSON = "delete.person";

    /*
    @Bean
    public HandlerRegistry eventSubscriptions() {
        return register().listenEvent(CREATE_PERSON, event -> personUseCase.createPerson(event.getData().getBalance()),
                        PersonDTO.class)
                .listenEvent(DELETE_PERSON, event -> personUseCase.deletePerson(event.getData().getId()),
                        PersonDTO.class);
    }
     */
}