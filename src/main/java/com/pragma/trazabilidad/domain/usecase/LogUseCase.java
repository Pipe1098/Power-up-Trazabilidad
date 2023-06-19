package com.pragma.trazabilidad.domain.usecase;

import com.pragma.trazabilidad.adapters.driving.http.dto.response.LogsResponseDto;
import com.pragma.trazabilidad.domain.api.LogServicePort;
import com.pragma.trazabilidad.domain.exceptions.LogNoFoundException;
import com.pragma.trazabilidad.domain.model.Log;
import com.pragma.trazabilidad.domain.spi.LogPersistencePort;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LogUseCase implements LogServicePort {

    private final LogPersistencePort logPersistencePort;

    public LogUseCase(LogPersistencePort logPersistencePort) {
        this.logPersistencePort = logPersistencePort;
    }

    @Override
    public void saveLog(Log log) {
        List<Log> logList = logPersistencePort.getLogsOrder(log.getIdOrder());

        // Verificar si el log ya existe en la lista de logs
      /*  boolean logExists = logList.stream()
                .anyMatch(existingLog -> existingLog.getIdOrder().equals(log.getIdOrder()));

        if (logExists) {
            // Actualizar los datos del log existente
            logPersistencePort.updateLog(log);
        } else {*/
            // Guardar el nuevo log
            logPersistencePort.saveLog(log);

    }
    @Override
    public List<LogsResponseDto> timeStates(Long idOrder) {
        List<Log> logList = logPersistencePort.getLogsOrder(idOrder);

        if (logList.isEmpty()) {
            throw new LogNoFoundException("No logs found for the provided idOrder: " + idOrder);
        }

        List<LogsResponseDto> logsResponseList = new ArrayList<>();

        LocalDateTime previousDateTime = null;
        Long previousTotalDuration = 0L;
        Long duration1 = 0L;
        Long duration2 = 0L;
        Long duration3 = 0L;

        for (Log log : logList) {
            LogsResponseDto logResponse = new LogsResponseDto();
            logResponse.setIdOrder(idOrder);

            LocalDateTime currentDateTime = null;
            Long currentTotalDuration = 0L;

            if (log.getPending() != null) {
                currentDateTime = log.getPending();
                duration1 += calculateDuration(previousDateTime, currentDateTime);
                logResponse.setDuration1(0L);
                currentTotalDuration += logResponse.getDuration1();
            }

            if (log.getInPreparation() != null) {
                currentDateTime = log.getInPreparation();
                duration1 += calculateDuration(previousDateTime, currentDateTime);
                logResponse.setDuration1(duration1);
                currentTotalDuration += logResponse.getDuration1();
            }

            if (log.getReady() != null) {
                currentDateTime = log.getReady();
                duration2 += calculateDuration(previousDateTime, currentDateTime);
                logResponse.setDuration1(duration1 );
                logResponse.setDuration2(duration2 );
                currentTotalDuration += logResponse.getDuration2();
            }

            if (log.getDelivered() != null) {
                currentDateTime = log.getDelivered();
                duration3 +=calculateDuration(previousDateTime, currentDateTime);
                logResponse.setDuration1(duration1 );
                logResponse.setDuration2(duration2 );
                logResponse.setDuration3(duration3);
                currentTotalDuration += logResponse.getDuration3();
            }

            logResponse.setTotalDuration(currentTotalDuration + previousTotalDuration);
            logsResponseList.add(logResponse);

            previousDateTime = currentDateTime;
            previousTotalDuration = logResponse.getTotalDuration();
        }

        // Ordenar la lista de logs por total de duración de menor a mayor
        logsResponseList.sort(Comparator.comparingLong(LogsResponseDto::getTotalDuration));

        return logsResponseList;
    }

    private Long calculateDuration(LocalDateTime previousDate, LocalDateTime currentDate) {
        if (previousDate == null) {
            return 0L;
        }
        return Duration.between(previousDate, currentDate).toMinutes();
    }

    @Override
    public Long totalTime(Long idOrder) {
        List<LogsResponseDto> logsList = timeStates(idOrder);

        if (logsList.isEmpty()) {
            throw new LogNoFoundException("No logs found for the provided idOrder: " + idOrder);
        }

        LogsResponseDto lastLog = logsList.get(logsList.size() - 1);
        if (lastLog.getDuration3() != null) {
            return lastLog.getTotalDuration();
        }
        return 0l;
    }

}
