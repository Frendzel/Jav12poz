package pl.sda.csv;

import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import static java.nio.file.Files.newBufferedWriter;
import static java.nio.file.Paths.get;
import static org.apache.commons.csv.CSVFormat.DEFAULT;

public class CsvWriter {
    private static final String SAMPLE_CSV_FILE = "./result.csv";

    public void write(List<Employee> employeeList) throws IOException {
        try (
                BufferedWriter writer = newBufferedWriter(get(SAMPLE_CSV_FILE));
                CSVPrinter csvPrinter = new CSVPrinter(writer, DEFAULT
                        .withHeader("id", "first_name", "last_name"))
        ) {
            for (Employee e : employeeList) {
                csvPrinter.printRecord(e.getId(), e.getFirstName(), e.getLastName());
            }
            csvPrinter.flush();
        }
    }
}
