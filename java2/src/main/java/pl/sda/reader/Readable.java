package pl.sda.reader;

import pl.sda.model.Employee;

import java.io.IOException;
import java.util.List;

public interface Readable {

    List<Employee> read(String fileName) throws IOException;
}
