package employees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

class EmployeeDAOTests {

    static EmployeeDAO dao;
    static List<Employee> employees;

    @BeforeAll
    static void SetUp() {
        employees = new ArrayList<>();
        employees.add(new Employee(111111, "Mr", "Bob", "Jones", "M", "M",
                "bob.jones@mail.com", LocalDate.of(1980, 6, 24),
                LocalDate.of(2010, 9, 1), 30000));
        employees.add(new Employee(222222, "Mrs", "Alice", "Smith", "C", "F",
                "alice.smith@mail.com", LocalDate.of(1990, 11, 5),
                LocalDate.of(2015, 10, 1), 40000));
        employees.add(new Employee(111111, "Dr", "Eve", "Brown", "S", "F",
                "eve.brown@mail.com", LocalDate.of(1976, 4, 15),
                LocalDate.of(2005, 4, 1), 50000));
        dao = new EmployeeDAO(employees);
    }

    @Test
    @DisplayName("Given a range of dates that overlaps with the hiring dates of some employees, getByHiredDateRange returns a list of those employees")
    void givenARangeOfDatesThatOverlapsWithTheHiringDatesOfSomeEmployeesGetByHiredDateRangeReturnsAListOfThoseEmployees() {
        LocalDate start = LocalDate.of(2015, 1, 1);
        LocalDate end = LocalDate.of(2016, 1, 1);
        List<Employee> expected = List.of(employees.get(1));
        Assertions.assertEquals(expected, dao.getByHiredDateRange(start, end));
    }

    @Test
    @DisplayName("Given a range of dates that overlaps with the hiring dates of all employees, getHiredByDateRange returns a list of all employees")
    void givenARangeOfDatesThatOverlapsWithTheHiringDatesOfAllEmployeesGetHiredByDateRangeReturnsAListOfAllEmployees() {
        LocalDate start = LocalDate.of(2005, 1, 1);
        LocalDate end = LocalDate.of(2016, 1, 1);
        List<Employee> expected = employees;
        Assertions.assertEquals(expected, dao.getByHiredDateRange(start, end));
    }

    @Test
    @DisplayName("Given a range of dates that does not overlap with the hiring dates of any employees, getByHiredDateRange returns an empty list")
    void givenARangeOfDatesThatDoesNotOverlapWithTheHiringDatesOfAnyEmployeesGetByHiredDateRangeReturnsAnEmptyList() {
        LocalDate start = LocalDate.of(2020, 1, 1);
        LocalDate end = LocalDate.of(2021, 1, 1);
        List<Employee> expected = List.of();
        Assertions.assertEquals(expected, dao.getByHiredDateRange(start, end));
    }

}