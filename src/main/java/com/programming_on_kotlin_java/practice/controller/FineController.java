package com.programming_on_kotlin_java.practice.controller;

import com.programming_on_kotlin_java.practice.exception.FineNotFoundException;
import com.programming_on_kotlin_java.practice.exception.FinePaymentException;
import com.programming_on_kotlin_java.practice.exception.FineToCourtException;
import com.programming_on_kotlin_java.practice.model.Fine;
import com.programming_on_kotlin_java.practice.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fines")
public class FineController {

    @Autowired
    private FineService fineService;

    @GetMapping
    public ResponseEntity<?> getAllFines() {
        final List<Fine> fines = fineService.getAllFines();
        return fines != null && !fines.isEmpty()
                ? ResponseEntity.ok(fines)
                : ResponseEntity.badRequest().body("The fines database is empty.");
    }

    @PostMapping
    public ResponseEntity<?> addFine(@RequestBody Fine fine) {
        try {
            fineService.addFine(fine);
            fineService.getFine(fine.getId());
            return ResponseEntity.ok("The fine was successfully added to the fines database.");
        } catch (FineNotFoundException e) {
            return ResponseEntity.badRequest().body("The fine was not added to the fines database.");
        }
    }

    @PutMapping
    public ResponseEntity<?> updateFine(@RequestBody Fine fine) {
        try {
            fineService.updateFine(fine);
            return ResponseEntity.ok("The fine was successfully updated.");
        } catch (FineNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteFine(@RequestBody Fine fine) {
        try {
            fineService.deleteFine(fine.getId());
            return ResponseEntity.ok("The fine has been successfully removed.");
        } catch (FineNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/{fineId}")
    public ResponseEntity<?> getFine(@PathVariable(name = "fineId") int id) {
        try {
            return ResponseEntity.ok(fineService.getFine(id));
        } catch (FineNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{fineId}/pay")
    public ResponseEntity<?> payFine(@PathVariable(name = "fineId") int id) {
        try {
            fineService.payFine(id);
            return ResponseEntity.ok("The fine has been successfully paid.");
        } catch (FineNotFoundException | FinePaymentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{fineId}/court")
    public ResponseEntity<?> fineToCourt(@PathVariable(name = "fineId") int id) {
        try {
            fineService.fineToCourt(id);
            return ResponseEntity.ok("The subpoena has been successfully sent.");
        } catch (FineNotFoundException | FineToCourtException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
