package pl.sda.database;

import pl.sda.model.Employee;
import pl.sda.reader.CsvReader;
import pl.sda.util.EmployeeFiller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {

    private List<Employee> employees = new ArrayList<>();
    private CsvReader csvReader = new CsvReader();

    public void init() throws IOException {
        this.employees = csvReader.readAndPrintContentFromEmployeeCsv();
        EmployeeFiller.fill(employees);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
