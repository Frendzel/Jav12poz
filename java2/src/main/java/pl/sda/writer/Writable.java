package pl.sda.writer;

import pl.sda.model.Employee;

import java.io.IOException;
import java.util.List;

@FunctionalInterface
public interface Writable {

    void write(List<Employee> employees) throws IOException;
}
