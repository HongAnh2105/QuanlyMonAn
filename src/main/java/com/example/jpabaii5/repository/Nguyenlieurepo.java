package com.example.jpabaii5.repository;

import com.example.jpabaii5.model.Nguyenlieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Nguyenlieurepo extends JpaRepository<Nguyenlieu,Integer> {
}
