package com.example.relationshipspractise.model.onetoone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue
    private int id;

    private int age;

    private String name;

    @OneToOne
    @MapsId
    private Owner owner;
}
