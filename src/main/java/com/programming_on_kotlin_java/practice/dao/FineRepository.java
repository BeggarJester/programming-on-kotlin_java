package com.programming_on_kotlin_java.practice.dao;

import com.programming_on_kotlin_java.practice.model.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<Fine, Integer> {
}