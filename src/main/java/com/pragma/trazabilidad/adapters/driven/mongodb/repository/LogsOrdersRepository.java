package com.pragma.trazabilidad.adapters.driven.mongodb.repository;

import com.pragma.trazabilidad.adapters.driven.mongodb.document.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface LogsOrdersRepository extends MongoRepository<LogEntity,Long> {

    List<LogEntity> findAllByIdOrder(Long idOrder);

    Optional<LogEntity> findByIdOrder(Long id);

}
