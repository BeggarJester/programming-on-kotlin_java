package com.programming_on_kotlin_java.practice.service;

import com.programming_on_kotlin_java.practice.dao.FineRepository;
import com.programming_on_kotlin_java.practice.exception.FineNotFoundException;
import com.programming_on_kotlin_java.practice.exception.FinePaymentException;
import com.programming_on_kotlin_java.practice.exception.FineToCourtException;
import com.programming_on_kotlin_java.practice.model.Fine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FineServiceImplementation implements FineService {

    @Autowired
    private FineRepository fineRepository;

    @Override
    public List<Fine> getAllFines(PageRequest pageRequest) {
        Page<Fine> page = fineRepository.findAll(pageRequest);
        return page.getContent();
    }

    @Override
    public void addFine(Fine fine) {
        fineRepository.save(fine);
    }

    @Override
    public void updateFine(Fine fine) throws FineNotFoundException {
        if (!fineRepository.existsById(fine.getId())) {
            throw new FineNotFoundException("The fine with the specified id was not found.");
        }
        fineRepository.save(fine);
    }

    @Override
    public void deleteFine(Integer id) throws FineNotFoundException {
        if (!fineRepository.existsById(id)) {
            throw new FineNotFoundException("The fine with the specified id was not found.");
        }
        fineRepository.deleteById(id);
    }

    @Override
    public Fine getFine(Integer id) throws FineNotFoundException {
        if (fineRepository.findById(id).isEmpty()) {
            throw new FineNotFoundException("The fine with the specified id was not found.");
        }
        return fineRepository.findById(id).get();
    }

    @Override
    public void payFine(Integer id) throws FineNotFoundException, FinePaymentException {
        if (!fineRepository.existsById(id)) {
            throw new FineNotFoundException("The fine with the specified id was not found.");
        } else if (fineRepository.getReferenceById(id).getPaymentFine()) {
            throw new FinePaymentException("The fine has already been paid.");
        }
        Fine fine = fineRepository.getReferenceById(id);
        fine.setPaymentFine(true);
        fine.setDatePaymentFine(LocalDate.now());
        fineRepository.save(fine);
    }

    @Override
    public void fineToCourt(Integer id) throws FineNotFoundException, FineToCourtException {
        if (!fineRepository.existsById(id)) {
            throw new FineNotFoundException("The fine with the specified id was not found.");
        } else if (fineRepository.getReferenceById(id).getSubpoena()) {
            throw new FineToCourtException("The subpoena has already been sent.");
        } else if (fineRepository.getReferenceById(id).getPaymentFine()) {
            throw new FineToCourtException("Sending a subpoena is not possible. The fine has already been paid.");
        } else if (LocalDate.now().compareTo(fineRepository.getReferenceById(id).getDateDeadlinePaymentFine()) < 0) {
            throw new FineToCourtException("Sending a subpoena is not possible. The deadline for payment of the fine has not been passed.");
        }
        Fine fine = fineRepository.getReferenceById(id);
        fine.setSubpoena(true);
        fineRepository.save(fine);
    }
}