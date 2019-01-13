package pl.sda.writer;

import pl.sda.model.Employee;
import pl.sda.writer.csv.CsvWriter;
import pl.sda.writer.json.JsonWriter;

import java.io.IOException;
import java.util.List;

import static pl.sda.writer.FileType.CSV;

public class WriterFactory {

    public Writable generate(FileType fileType) {
        if (CSV == fileType) {
            return new CsvWriter();
        } else {
            return new JsonWriter();
        }
    }

    public void write(FileType fileType, List<Employee> employees) throws IOException {
        Writable writer = generate(fileType);
        writer.write(employees);
    }

}
