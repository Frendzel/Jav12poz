package pl.sda.writer;

import org.junit.Before;
import org.junit.Test;
import pl.sda.model.Employee;
import pl.sda.reader.CsvReader;
import pl.sda.writer.csv.CsvWriter;
import pl.sda.writer.json.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static pl.sda.writer.FileType.*;

public class WriterFactoryTest {

    CsvReader csvReader = new CsvReader();
    List<Employee> employees = new ArrayList<>();
    WriterFactory factory = new WriterFactory();

    @Before
    public void init() throws IOException {
        //given
        employees = csvReader.readAndPrintContentFromEmployeeCsv();
    }

    @Test
    public void should_write_data_to_csv_file() {
        //when
        Writable writer = factory.generate(CSV);
        //then
        assertTrue(writer instanceof CsvWriter);
        try {
            writer.write(employees);
        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void should_write_data_to_json_file() {
        //when
        Writable writer = factory.generate(JSON);
        //then
        assertTrue(writer instanceof JsonWriter);
        try {
            writer.write(employees);
        } catch (IOException e) {
            fail();
        }
    }
}