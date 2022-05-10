package com.luxoftInterview.demo.repository;

import com.luxoftInterview.demo.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division, String> {
}
