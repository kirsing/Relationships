package com.example.relationshipspractise.repository.onetoone;

import com.example.relationshipspractise.model.onetoone.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {
}
