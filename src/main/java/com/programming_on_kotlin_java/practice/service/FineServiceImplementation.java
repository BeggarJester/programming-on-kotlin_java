package com.programming_on_kotlin_java.practice.service;

import com.programming_on_kotlin_java.practice.dao.FineDAO;
import com.programming_on_kotlin_java.practice.exception.FineNotFoundException;
import com.programming_on_kotlin_java.practice.exception.FinePaymentException;
import com.programming_on_kotlin_java.practice.exception.FineToCourtException;
import com.programming_on_kotlin_java.practice.model.Fine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FineServiceImplementation implements FineService {

    @Autowired
    private FineDAO fineDAO;

    @Override
    public List<Fine> getAllFines() {
        return fineDAO.getAllFines();
    }

    @Override
    public void addFine(Fine fine) {
        fineDAO.addFine(fine);
    }

    @Override
    public void updateFine(Fine fine) throws FineNotFoundException {
        if (fineDAO.getFine(fine.getId()) == null) {
            throw new FineNotFoundException("The fine with the specified id was not found.");
        }
        fineDAO.updateFine(fine);
    }

    @Override
    public Fine deleteFine(Integer id) throws FineNotFoundException {
        if (fineDAO.getFine(id) == null) {
            throw new FineNotFoundException("The fine with the specified id was not found.");
        }
        return fineDAO.deleteFine(id);
    }

    @Override
    public Fine getFine(Integer id) throws FineNotFoundException {
        if (fineDAO.getFine(id) == null) {
            throw new FineNotFoundException("The fine with the specified id was not found.");
        }
        return fineDAO.getFine(id);
    }

    @Override
    public void payFine(Integer id) throws FineNotFoundException, FinePaymentException {
        if (fineDAO.getFine(id) == null) {
            throw new FineNotFoundException("The fine with the specified id was not found.");
        } else if (fineDAO.getFine(id).getPaymentFine()) {
            throw new FinePaymentException("The fine has already been paid.");
        }
        fineDAO.payFine(id);
    }

    @Override
    public void fineToCourt(Integer id) throws FineNotFoundException, FineToCourtException {
        if (fineDAO.getFine(id) == null) {
            throw new FineNotFoundException("The fine with the specified id was not found.");
        } else if (fineDAO.getFine(id).getSubpoena()) {
            throw new FineToCourtException("The subpoena has already been sent.");
        } else if (fineDAO.getFine(id).getPaymentFine()) {
            throw new FineToCourtException("Sending a subpoena is not possible. The fine has already been paid.");
        } else if (LocalDate.now().compareTo(fineDAO.getFine(id).getDateDeadlinePaymentFine()) < 0) {
            throw new FineToCourtException("Sending a subpoena is not possible. The deadline for payment of the fine has not been passed.");
        }
        fineDAO.fineToCourt(id);
    }
}
