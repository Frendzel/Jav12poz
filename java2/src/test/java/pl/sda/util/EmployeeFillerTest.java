package pl.sda.util;

import org.junit.Test;
import pl.sda.model.Employee;
import pl.sda.reader.CsvReader;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class EmployeeFillerTest {

    CsvReader csvReader = new CsvReader();

    @Test
    public void fill() throws IOException {
        //given
        List<Employee> employees = csvReader.readAndPrintContentFromEmployeeCsv();
        //when
        EmployeeFiller.fill(employees);
        //then
        employees.forEach(e -> {
            assertNotNull(e.getSex());
            assertNotNull(e.getSalary());
            assertNotNull(e.getJobTitle());
            assertNotNull(e.getEmploymentDate());
        });
    }
}