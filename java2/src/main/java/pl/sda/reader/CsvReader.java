package pl.sda.reader;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import pl.sda.model.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.currentThread;
import static org.apache.commons.csv.CSVFormat.DEFAULT;

public class CsvReader implements Readable {

    private static final String CSV_FILE_NAME = "employee.csv";

    public List<Employee> readAndPrintContentFromEmployeeCsv() throws IOException {
        return read(CSV_FILE_NAME);
    }

    @Override
    public List<Employee> read(String csvFileName) throws IOException {
        ClassLoader classloader = currentThread().getContextClassLoader();
        List<Employee> employees = new ArrayList<>();
        try (
                InputStream is = classloader.getResourceAsStream(csvFileName);
                InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(streamReader);
                CSVParser csvParser = new CSVParser(reader, DEFAULT
                        .withHeader("id", "first_name", "last_name")
                        .withIgnoreHeaderCase()
                        .withSkipHeaderRecord()
                        .withTrim())
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String id = csvRecord.get(0);
                String firstName = csvRecord.get(1);
                String lastName = csvRecord.get(2);

                Employee employee = new Employee(id, firstName, lastName);
                employees.add(employee);

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Id : " + id);
                System.out.println("FirstName : " + firstName);
                System.out.println("LastName : " + lastName);
                System.out.println("---------------\n\n");
            }
        }
        return employees;
    }
}
