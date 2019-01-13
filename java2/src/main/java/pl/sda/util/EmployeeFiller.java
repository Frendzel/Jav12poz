package pl.sda.util;

import pl.sda.model.Employee;
import pl.sda.model.Sex;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static java.lang.Math.random;
import static pl.sda.model.JobTitle.*;

public class EmployeeFiller {

    private EmployeeFiller() {
    }

    public static void fill(List<Employee> employees) {
        for (Employee e : employees) {
            int id = Integer.parseInt(e.getId());
            setSex(e, id);
            e.setSalary(random() * 10000);
            setJobTitle(e, id);
            setEmploymentDate(e);
        }
    }

    private static void setEmploymentDate(Employee e) {
        Random random = new Random();
        int year = random.nextInt(20);
        e.setEmploymentDate(LocalDate.of(1990 + year, 5, 2));
    }

    private static void setJobTitle(Employee e, int id) {
        if (id % 4 == 0) {
            e.setJobTitle(JUNIOR);
        } else if ((id % 4 == 1)) {
            e.setJobTitle(REGULAR);
        } else if ((id % 4 == 2)) {
            e.setJobTitle(SENIOR);
        } else {
            e.setJobTitle(PRINCIPAL);
        }
    }

    private static void setSex(Employee e, int id) {
        if (id % 2 == 0) {
            e.setSex(Sex.MALE);
        } else {
            e.setSex(Sex.FEMALE);
        }
    }

}
