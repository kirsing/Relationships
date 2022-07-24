package com.example.relationshipspractise.model.onetoone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Pattern(regexp = "(^[A-Za-z]+)\\s*\\d{1,}")
    private String address;

    @Min(1)
    @Max(6)
    private short rooms;

    @OneToOne(mappedBy = "house")
    private Owner owner;


}
