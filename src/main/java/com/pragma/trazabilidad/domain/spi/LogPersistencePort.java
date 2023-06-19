package com.pragma.trazabilidad.domain.spi;



import com.pragma.trazabilidad.domain.model.Log;

import java.util.List;


public interface LogPersistencePort {
    void saveLog(Log log);
    List<Log> getLogsOrder(Long idOrder);
    void updateLog(Log log);
    // Log obtenerLogPedidoPorEstado(Long idPedido, String estado);
}
