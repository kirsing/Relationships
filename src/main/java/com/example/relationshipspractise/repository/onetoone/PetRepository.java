package com.example.relationshipspractise.repository.onetoone;

import com.example.relationshipspractise.model.onetoone.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {
}
