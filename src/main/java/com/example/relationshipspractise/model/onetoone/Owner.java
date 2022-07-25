package com.example.relationshipspractise.model.onetoone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    private String firstName;  // @NotBlank — аннотированный элемент не должен быть null и должен содержать хотя бы один непробельный символ. Принимает CharSequence.

    @NotEmpty
    private String lastName;  // @NotBlank — аннотированный элемент не должен быть null и должен содержать хотя бы один cимвол.

    @OneToOne
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private House house;


}
