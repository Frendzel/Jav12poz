package pl.sda.service;

import pl.sda.database.EmployeeDatabase;
import pl.sda.model.JobTitle;

import java.io.IOException;
import java.util.Map;

public class EmployeeService {

    EmployeeDatabase db = new EmployeeDatabase();

    public EmployeeService() throws IOException {
        db.init();
    }

    public Map<Double, JobTitle> avgSalaryGroupingByJobTitle() {
        return null;
    }
}
