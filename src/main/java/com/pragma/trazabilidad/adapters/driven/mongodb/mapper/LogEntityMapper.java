package com.pragma.trazabilidad.adapters.driven.mongodb.mapper;

import com.pragma.trazabilidad.adapters.driven.mongodb.document.LogEntity;

import com.pragma.trazabilidad.domain.model.Log;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LogEntityMapper {
    LogEntity toDocument(Log log);
    Log toLogOrder(LogEntity logEntity);
}
