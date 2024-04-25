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
        employees.add(new Employee(333333, "Dr", "Eve", "Brown", "S", "F",
                "eve.brown@mail.com", LocalDate.of(1976, 4, 15),
                LocalDate.of(2005, 4, 1), 50000));
    }

    @Test
    @DisplayName("Given a list containing a single employee, format returns a string containing a table of data for that employee")
    void givenAListContainingASingleEmployeeFormatReturnsAStringContainingATableOfDataForThatEmployee() {
        List<Employee> singleEmployee = List.of(employees.get(0));
        String expected = """
                | ID | First Name | Last Name |
                ===============================
                | 111111 | Bob | Jones |
                """;
        Assertions.assertEquals(expected, formatter.format(singleEmployee));
    }

}