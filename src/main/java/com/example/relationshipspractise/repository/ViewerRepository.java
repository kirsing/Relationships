package com.example.relationshipspractise.repository;

import com.example.relationshipspractise.model.manytomany.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Long> {
}
