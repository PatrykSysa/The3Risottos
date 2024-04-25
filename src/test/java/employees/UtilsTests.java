package test.java.employees;

import employees.Employee;
import employees.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTests {
    private static final String[] rawData = {
            "807262,Mr.,Stefan,O,Maeda,M,stefan.maeda@yahoo.com,3/23/1990,11/5/2011,67028",
            "368234,Drs.,Gillian,T,Winter,F,gillian.winter@gmail.com,1/17/1960,11/28/1984,103619"
    };

    @RepeatedTest(100)
    @DisplayName("When called, generate a random number that fits between 1 and 1000 inclusive")
    void generateRandomEmployeeCountTest() {
        int count = Utils.generateRandomEmployeeCount();
        assertTrue(count >= 1 && count <= 1000);
    }

    @Test
    @DisplayName("Given the raw csv data, return the first employee's data in the correct format as an employee object")
    void parseFirstEmployeeDataTest() {
        List<Employee> employeeList = Utils.parseEmployeeData(rawData);

        Employee expectedEmployee = new Employee(807262, "Mr.","Stefan","Maeda", "O", "M","stefan.maeda@yahoo.com", LocalDate.of(1990, 3, 23), LocalDate.of(2011, 11, 5),67028);

        Employee firstEmployee = employeeList.get(0);

        assertEquals(expectedEmployee, firstEmployee);
    }

    @Test
    @DisplayName("Given the raw csv data, return the second employee's data in the correct format as an employee object")
    void parseSecondEmployeeDataTest() {
        List<Employee> employeeList = Utils.parseEmployeeData(rawData);

        Employee expectedEmployee = new Employee(368234,"Drs.","Gillian","Winter", "T","F","gillian.winter@gmail.com", LocalDate.of(1960, 1, 17), LocalDate.of(1984, 11, 28),103619);

        Employee secondEmployee = employeeList.get(1);

        assertEquals(expectedEmployee, secondEmployee);
    }

    @Test
    @DisplayName("Given a date in the CSV file format, return correct local date format")
    void convertToDateTest() {
        LocalDate date = Utils.convertToDate("12/31/2023");
        assertEquals(LocalDate.of(2023, 12, 31), date);
    }

}
