package com.example.jpabaii5.repository;

import com.example.jpabaii5.model.Loaimonan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Loaimonanrepo extends JpaRepository<Loaimonan,Integer> {
}
