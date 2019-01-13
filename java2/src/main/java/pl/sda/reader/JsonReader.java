package pl.sda.reader;

import com.google.gson.Gson;
import pl.sda.model.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class JsonReader implements Readable {

    @Override
    public List<Employee> read(String fileName) {
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            Employee[] employees = gson.fromJson(reader, Employee[].class);
            return Arrays.asList(employees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
