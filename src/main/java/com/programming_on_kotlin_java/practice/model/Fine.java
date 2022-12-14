package com.programming_on_kotlin_java.practice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Fine {

    private Integer id;
    private String carNumber;
    private String intruder;
    private String inspector;
    private LocalDateTime timeProtocol;
    private Integer fineAmount;
    private Boolean subpoena;
    private Boolean paymentFine;
    private LocalDate datePaymentFine;
    private LocalDate dateDeadlinePaymentFine;

    public Fine() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getIntruder() {
        return intruder;
    }

    public void setIntruder(String intruder) {
        this.intruder = intruder;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public LocalDateTime getTimeProtocol() {
        return timeProtocol;
    }

    public void setTimeProtocol(LocalDateTime timeProtocol) {
        this.timeProtocol = timeProtocol;
    }

    public Integer getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Integer fineAmount) {
        this.fineAmount = fineAmount;
    }

    public Boolean getSubpoena() {
        return subpoena;
    }

    public void setSubpoena(Boolean subpoena) {
        this.subpoena = subpoena;
    }

    public Boolean getPaymentFine() {
        return paymentFine;
    }

    public void setPaymentFine(Boolean paymentFine) {
        this.paymentFine = paymentFine;
    }

    public LocalDate getDatePaymentFine() {
        return datePaymentFine;
    }

    public void setDatePaymentFine(LocalDate datePaymentFine) {
        this.datePaymentFine = datePaymentFine;
    }

    public LocalDate getDateDeadlinePaymentFine() {
        return dateDeadlinePaymentFine;
    }

    public void setDateDeadlinePaymentFine(LocalDate dateDeadlinePaymentFine) {
        this.dateDeadlinePaymentFine = dateDeadlinePaymentFine;
    }
}