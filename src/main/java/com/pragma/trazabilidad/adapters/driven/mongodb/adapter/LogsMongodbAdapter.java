package com.pragma.trazabilidad.adapters.driven.mongodb.adapter;

import com.pragma.trazabilidad.adapters.driven.mongodb.document.LogEntity;
import com.pragma.trazabilidad.adapters.driven.mongodb.mapper.LogEntityMapper;
import com.pragma.trazabilidad.adapters.driven.mongodb.repository.LogsOrdersRepository;
import com.pragma.trazabilidad.domain.exceptions.LogNoFoundException;
import com.pragma.trazabilidad.domain.model.Log;
import com.pragma.trazabilidad.domain.spi.LogPersistencePort;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class LogsMongodbAdapter implements LogPersistencePort {

    private final LogsOrdersRepository logsRepository;
    private final LogEntityMapper logEntityMapper;

    @Override
    public void saveLog(Log log) {
        logsRepository.save(logEntityMapper.toDocument(log));

    }
    @Override
    public List<Log> getLogsOrder(Long idOrder) {
        List<LogEntity> logsEntity= logsRepository.findAllByIdOrder(idOrder);
        List<Log> logs = new ArrayList<>();
        logsEntity.forEach(logEntity -> logs.add(logEntityMapper.toLogOrder(logEntity)));
        return logs;
    }

    @Override
    public void updateLog(Log log) {
        Optional<LogEntity> optionalLogEntity = logsRepository.findByIdOrder(log.getIdOrder());

        if (optionalLogEntity.isPresent()) {
            LogEntity logEntity = optionalLogEntity.get();

            if(logEntity.getPending()== null){
                logEntity.setPending(log.getPending());
            }
            if(logEntity.getInPreparation()== null){
                logEntity.setInPreparation(log.getInPreparation());
            }
            if(logEntity.getReady()== null){
                logEntity.setReady(log.getReady());
            }
            if(logEntity.getDelivered()== null){
                logEntity.setDelivered(log.getDelivered());
            }

            logsRepository.save(logEntity);
        } else {
            throw new LogNoFoundException("Log not found with idOrder: " + log.getIdOrder());
        }
    }

}
