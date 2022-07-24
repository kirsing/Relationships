package com.example.relationshipspractise.model.manytoone;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @NotBlank(message = "Model is blank")
//    @NotNull
//    @NotEmpty
    private String model;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacture_id")
    private Manufacture manufacture; // ссылка на объект изготовителя

}
