package com.example.camp.repository;

import com.example.camp.model.Signup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SignupRepository extends JpaRepository<Signup, Long> {
    List<Signup> findAllByCamperId(Long camperId);
}
