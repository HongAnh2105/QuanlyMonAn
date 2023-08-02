package com.example.jpabaii5.repository;

import com.example.jpabaii5.model.Congthuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Conthucrepo extends JpaRepository<Congthuc,Integer> {
}
