package com.pragma.trazabilidad.domain.model;

import java.time.LocalDateTime;

public class Log {
    private Long idOrder;
    private LocalDateTime pending;
    private LocalDateTime inPreparation;
    private LocalDateTime ready;
    private LocalDateTime delivered;

    public Log() {
    }

    public Log(Long idOrder, LocalDateTime pending, LocalDateTime inPreparation, LocalDateTime ready, LocalDateTime delivered) {
        this.idOrder = idOrder;
        this.pending = pending;
        this.inPreparation = inPreparation;
        this.ready = ready;
        this.delivered = delivered;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public LocalDateTime getPending() {
        return pending;
    }

    public void setPending(LocalDateTime pending) {
        this.pending = pending;
    }

    public LocalDateTime getInPreparation() {
        return inPreparation;
    }

    public void setInPreparation(LocalDateTime inPreparation) {
        this.inPreparation = inPreparation;
    }

    public LocalDateTime getReady() {
        return ready;
    }

    public void setReady(LocalDateTime ready) {
        this.ready = ready;
    }

    public LocalDateTime getDelivered() {
        return delivered;
    }

    public void setDelivered(LocalDateTime delivered) {
        this.delivered = delivered;
    }
}
