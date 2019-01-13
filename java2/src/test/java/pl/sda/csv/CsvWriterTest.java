package pl.sda.csv;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvWriterTest {

    private List<Employee> employees = new ArrayList<>();
    private CsvWriter csvWriter = new CsvWriter();

    @Before
    public void init() {
        //given
        for (int i = 0; i < 10; i++) {
            Employee emp = Employee.builder()
                    .id("" + i)
                    .firstName("test" + i)
                    .lastName("lastName" + i)
                    .build();
            employees.add(emp);
        }
    }

    @Test
    public void write() throws IOException {
        csvWriter.write(employees);
    }
}