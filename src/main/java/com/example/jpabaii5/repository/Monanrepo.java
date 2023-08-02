package com.example.jpabaii5.repository;

import com.example.jpabaii5.model.Monan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Monanrepo extends JpaRepository<Monan,Integer> {
}
