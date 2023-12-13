package com.example.springjwt.repositories;

import com.example.springjwt.model.Tshirt;
import com.example.springjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TshirtRepository extends JpaRepository<Tshirt,Integer> {
}
