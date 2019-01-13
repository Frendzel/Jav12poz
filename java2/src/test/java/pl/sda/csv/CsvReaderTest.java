package pl.sda.csv;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class CsvReaderTest {

    CsvReader csvReader = new CsvReader();

    @Test
    public void readAndPrintContentFromCsv() {
        //given
        csvReader = new CsvReader();
        try {
            //when
            List<Employee> employees = csvReader.readAndPrintContentFromEmployeeCsv();
            //then
            assertEquals(1000, employees.size());
        } catch (IOException e) {
            fail();
        }
    }
}