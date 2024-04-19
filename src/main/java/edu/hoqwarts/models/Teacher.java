package edu.hoqwarts.models;

import edu.hoqwarts.enums.EmpType;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dob;

    @ManyToOne  // Assuming a Teacher has one House. Adjust as necessary.
    private House house;

    private boolean headOfHouse;
    private EmpType employment;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;

    public Teacher() {
        // Default constructor
    }

    public Teacher(String firstName,
                   String middleName,
                   String lastName,
                   LocalDate dob,
                   House house,
                   EmpType employment,
                   LocalDate employmentStart,
                   LocalDate employmentEnd) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.house = house;
        this.headOfHouse = headOfHouse;
        this.employment = employment;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }
}
