package com.programming_on_kotlin_java.practice.service;

import com.programming_on_kotlin_java.practice.exception.FineNotFoundException;
import com.programming_on_kotlin_java.practice.exception.FinePaymentException;
import com.programming_on_kotlin_java.practice.exception.FineToCourtException;
import com.programming_on_kotlin_java.practice.model.Fine;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface FineService {

    List<Fine> getAllFines(PageRequest pageRequest);

    void addFine(Fine fine);

    void updateFine(Fine fine) throws FineNotFoundException;

    void deleteFine(Integer id) throws FineNotFoundException;

    Fine getFine(Integer id) throws FineNotFoundException;

    void payFine(Integer id) throws FineNotFoundException, FinePaymentException;

    void fineToCourt(Integer id) throws FineNotFoundException, FineToCourtException;
}