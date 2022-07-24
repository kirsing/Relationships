package com.example.relationshipspractise.repository;

import com.example.relationshipspractise.model.manytoone.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Long> {
}
