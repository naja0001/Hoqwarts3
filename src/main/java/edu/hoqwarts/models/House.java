package edu.hoqwarts.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class House {

    @Id
    private String name;
    private String founder;
    private String color1;
    private String color2;
    @ElementCollection
    private List<String> colors; //ElementCollection laver en join tabel med House og colors, således at tabellerne kan forblive atomar da colors er et array.

    public House() {

    }

    public House(String name, String founder, String color1, String color2) {
        this.name = name;
        this.founder = founder;
        this.color1 = color1;
        this.color2 = color2;
    }

}