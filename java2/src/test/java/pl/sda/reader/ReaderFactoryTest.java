package pl.sda.reader;

import org.junit.Test;
import pl.sda.model.Employee;
import pl.sda.writer.FileType;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReaderFactoryTest {

    ReaderFactory readerFactory = new ReaderFactory();

    @Test
    public void should_read_correctly_employees_from_json_file() throws IOException {
        //given
        Readable reader = readerFactory.generate(FileType.JSON);
        //when
        List<Employee> read = reader.read("employees.json");
        //then
        assertEquals(1000, read.size());
    }
}