package com.sign.dao;


import com.sign.entity.SignReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignRepository extends JpaRepository<SignReason, Integer> {


}
