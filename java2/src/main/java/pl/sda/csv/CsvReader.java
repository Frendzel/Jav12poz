package pl.sda.csv;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.apache.commons.csv.CSVFormat.DEFAULT;

public class CsvReader {

    private static final String CSV_FILE_NAME = "employee.csv";

    public void readAndPrintContentFromEmployeeCsv() throws IOException {
        readAndPrintContentFromCsv(CSV_FILE_NAME);
    }

    public void readAndPrintContentFromCsv(String csvFileName) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(csvFileName);
        try (
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

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Id : " + id);
                System.out.println("FirstName : " + firstName);
                System.out.println("LastName : " + lastName);
                System.out.println("---------------\n\n");
            }
        }
    }
}
