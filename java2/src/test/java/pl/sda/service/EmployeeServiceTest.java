package pl.sda.service;

import org.junit.Before;
import org.junit.Test;
import pl.sda.model.JobTitle;

import java.io.IOException;
import java.util.Map;

public class EmployeeServiceTest {

    EmployeeService employeeService;

    @Before
    public void init() throws IOException {
        //given
        employeeService = new EmployeeService();
    }


    @Test
    public void avgTest() {
        //when
        Map<JobTitle, Double> jobTitleDoubleMap = employeeService.avgSalaryGroupingByJobTitle();
        //then
        jobTitleDoubleMap
                .forEach((jobTitle, sal) -> System.out.println(jobTitle + " " + sal));
    }


    @Test
    public void showStatisticsTest(){
        employeeService.showStatistics();
    }

}