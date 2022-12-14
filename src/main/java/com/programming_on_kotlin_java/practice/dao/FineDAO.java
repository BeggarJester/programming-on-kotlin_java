package com.programming_on_kotlin_java.practice.dao;

import com.programming_on_kotlin_java.practice.model.Fine;

import java.util.List;

public interface FineDAO {

    void addFine(Fine fine);

    void updateFine(Fine fine);

    Fine deleteFine(Integer id);

    Fine getFine(Integer id);

    List<Fine> getAllFines();

    void payFine(Integer id);

    void fineToCourt(Integer id);
}
