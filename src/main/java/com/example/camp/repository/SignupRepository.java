package com.example.camp.repository;

import com.example.camp.model.Signup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<Signup, Long> {
}
