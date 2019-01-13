package pl.sda.writer;

import pl.sda.model.Employee;
import pl.sda.writer.csv.CsvWriter;
import pl.sda.writer.json.JsonWriter;

import java.io.IOException;
import java.util.List;

import static pl.sda.writer.FileType.CSV;

/**
 * Please use {@link WriterFactory} instead.
 */
@Deprecated
public class WriterFactory2 implements Writable {

    private FileType fileType;

    public WriterFactory2(FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public void write(List<Employee> employees) throws IOException {
        Writable writer;
        if (CSV == fileType) {
            writer = new CsvWriter();
        } else {
            writer = new JsonWriter();
        }
        writer.write(employees);

    }
}
