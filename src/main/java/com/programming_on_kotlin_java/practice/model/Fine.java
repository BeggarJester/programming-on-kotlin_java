package com.programming_on_kotlin_java.practice.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "fine")
public class Fine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "intruder")
    private String intruder;

    @Column(name = "inspector")
    private String inspector;

    @Column(name = "time_protocol")
    private LocalDateTime timeProtocol;

    @Column(name = "fine_amount")
    private Integer fineAmount;

    @Column(name = "subpoena")
    private Boolean subpoena;

    @Column(name = "payment_fine")
    private Boolean paymentFine;

    @Column(name = "date_payment_fine")
    private LocalDate datePaymentFine;

    @Column(name = "date_deadline_payment_fine")
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

    public int getFineAmount() {
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