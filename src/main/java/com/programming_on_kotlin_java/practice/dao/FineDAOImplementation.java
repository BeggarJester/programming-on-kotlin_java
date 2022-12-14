package com.programming_on_kotlin_java.practice.dao;

import com.programming_on_kotlin_java.practice.model.Fine;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FineDAOImplementation implements FineDAO {

    private static final HashMap<Integer, Fine> FINE_REPOSITORY_HASHMAP = new HashMap<>();
    private static final AtomicInteger FINE_ID_HOLDER = new AtomicInteger();

    @Override
    public void addFine(Fine fine) {
        final int id = FINE_ID_HOLDER.incrementAndGet();
        fine.setId(id);
        FINE_REPOSITORY_HASHMAP.put(id, fine);
    }

    @Override
    public void updateFine(Fine fine) {
        FINE_REPOSITORY_HASHMAP.put(fine.getId(), fine);
    }

    @Override
    public Fine deleteFine(Integer id) {
        return FINE_REPOSITORY_HASHMAP.remove(id);
    }

    @Override
    public Fine getFine(Integer id) {
        return FINE_REPOSITORY_HASHMAP.get(id);
    }

    @Override
    public List<Fine> getAllFines() {
        return new ArrayList<>(FINE_REPOSITORY_HASHMAP.values());
    }

    @Override
    public void payFine(Integer id) {
        FINE_REPOSITORY_HASHMAP.get(id).setPaymentFine(true);
        FINE_REPOSITORY_HASHMAP.get(id).setDatePaymentFine(LocalDate.now());
    }

    @Override
    public void fineToCourt(Integer id) {
        FINE_REPOSITORY_HASHMAP.get(id).setSubpoena(true);
    }
}
