package com.example.relationshipspractise.model.manytoone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufactureId;
    private String name;

//    @OneToMany(
//            mappedBy = "manufacture", // позволит нам указать поле, которое владеет отношением. Мы указалаи изготовителя т.к в объекте Кар у нас есть Изготовитель
//            cascade = CascadeType.ALL, // каждая операция выполняемая с производителем, будет распространяться на элементы которые хранятся в коллекции
//           orphanRemoval = true) // если удалю производителя, то машины будут также
@OneToMany(mappedBy = "manufacture", cascade = CascadeType.ALL, orphanRemoval = true)
@JsonIgnore
private List<Car> cars;


}
