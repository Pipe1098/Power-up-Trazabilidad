package com.pragma.trazabilidad.configuration;


import com.pragma.trazabilidad.adapters.driven.mongodb.adapter.LogsMongodbAdapter;
import com.pragma.trazabilidad.adapters.driven.mongodb.mapper.LogEntityMapper;
import com.pragma.trazabilidad.adapters.driven.mongodb.repository.LogsOrdersRepository;
import com.pragma.trazabilidad.domain.api.LogServicePort;
import com.pragma.trazabilidad.domain.spi.LogPersistencePort;
import com.pragma.trazabilidad.domain.usecase.LogUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final LogsOrdersRepository logsPedidosRepository;
    private final LogEntityMapper logPedidoEntityMapper;

    @Bean
    public LogServicePort logPedidoServicePort(){
        return new LogUseCase(logOrderPersistencePort());
    }

    @Bean
    public LogPersistencePort logOrderPersistencePort(){
        return new LogsMongodbAdapter(logsPedidosRepository, logPedidoEntityMapper);
    }
}
