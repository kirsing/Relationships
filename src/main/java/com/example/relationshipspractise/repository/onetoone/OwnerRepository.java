package com.example.relationshipspractise.repository.onetoone;

import com.example.relationshipspractise.model.onetoone.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
