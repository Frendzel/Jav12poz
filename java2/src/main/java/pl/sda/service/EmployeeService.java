package pl.sda.service;

import pl.sda.database.EmployeeDatabase;
import pl.sda.model.Employee;
import pl.sda.model.JobTitle;

import java.io.IOException;
import java.util.DoubleSummaryStatistics;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class EmployeeService {

    EmployeeDatabase db = new EmployeeDatabase();

    public EmployeeService() throws IOException {
        db.init();
    }

    public Map<JobTitle, Double> avgSalaryGroupingByJobTitle() {
        return db.getEmployees()
                .stream()
                .collect(
                        groupingBy(Employee::getJobTitle,
                                averagingDouble(Employee::getSalary))
                );
    }

    public void showStatistics() {
        DoubleSummaryStatistics stat = db
                .getEmployees()
                .stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
        System.out.println(stat);
    }
}
