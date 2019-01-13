package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @NonNull
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private Double salary;
    private LocalDate employmentDate;
    private JobTitle jobTitle;
    private Sex sex;

    //TODO please remove it later
    public Employee(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
