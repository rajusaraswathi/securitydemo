package com.security.demosecurity.repository;

import com.security.demosecurity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Employee,Integer> {
}
