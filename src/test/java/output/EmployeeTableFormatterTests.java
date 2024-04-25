package output;

import employees.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class EmployeeTableFormatterTests {

    static List<Employee> employees;
    EmployeeTableFormatter formatter = new EmployeeTableFormatter();

    @BeforeAll
    static void SetUp() {
        employees = new ArrayList<>();
        employees.add(new Employee(111111, "Mr", "Bob", "Jones", "M", "M",
                "bob.jones@mail.com", LocalDate.of(1980, 6, 24),
                LocalDate.of(2010, 9, 1), 30000));
        employees.add(new Employee(222222, "Mrs", "Alice", "Smith", "C", "F",
                "alice.smith@mail.com", LocalDate.of(1990, 11, 5),
                LocalDate.of(2015, 10, 1), 40000));
    }

    @Test
    @DisplayName("Given a list containing a single employee, format returns a string containing a table of data for that employee")
    void givenAListContainingASingleEmployeeFormatReturnsAStringContainingATableOfDataForThatEmployee() {
        List<Employee> singleEmployee = List.of(employees.get(0));
        String expected = """
                | ID | Prefix | First Name | Last Name | Middle Initial | Gender | Email | DOB | Hire Date | Salary |
                ============================================================================================
                | 111111 | Mr | Bob | Jones | M | M | bob.jones@mail.com | 1980-06-24 | 2010-09-01 | 30000 |
                """;
        Assertions.assertEquals(expected, formatter.format(singleEmployee));
    }

    @Test
    @DisplayName("Given a list containing multiple employees, format returns a string containing a table of data for those employees")
    void givenAListContainingMultipleEmployeesFormatReturnsAStringContainingATableOfDataForThoseEmployees() {
        String expected = """
                | ID | Prefix | First Name | Last Name | Middle Initial | Gender | Email | DOB | Hire Date | Salary |
                ============================================================================================
                | 111111 | Mr | Bob | Jones | M | M | bob.jones@mail.com | 1980-06-24 | 2010-09-01 | 30000 |
                | 222222 | Mrs | Alice | Smith | C | F | alice.smith@mail.com | 1990-11-05 | 2015-10-01 | 40000 |
                """;

        Assertions.assertEquals(expected, formatter.format(employees));
    }

}