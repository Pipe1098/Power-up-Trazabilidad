package com.pragma.trazabilidad.adapters.driving.http.mapper;

import com.pragma.trazabilidad.adapters.driving.http.dto.request.LogsRequestDto;
import com.pragma.trazabilidad.domain.model.Log;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy =  ReportingPolicy.IGNORE)

public interface LogDtoMapper {
    Log toLog (LogsRequestDto logDto);
}
