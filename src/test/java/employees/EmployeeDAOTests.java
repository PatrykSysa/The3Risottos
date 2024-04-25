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
        employees.add(new Employee(333333, "Dr", "Eve", "Brown", "S", "F",
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

    @Test
    @DisplayName("Given an id of 222222, get mrs alice smith")
    void givenID222222GetAliceSmith() {
        Employee expected = new Employee(222222, "Mrs", "Alice", "Smith", "C", "F",
                "alice.smith@mail.com", LocalDate.of(1990, 11, 5),
                LocalDate.of(2015, 10, 1), 40000);
        Assertions.assertEquals(expected, dao.getById(222222));
    }

    @Test
    @DisplayName("Given id of 1, should return null")
    void givenID1ReturnNull() {
        Assertions.assertNull(dao.getById(1));
    }

    @Test
    @DisplayName("Given a range of ages that overlaps with the age of an employee, getByAgeRange returns a list containing that employee")
    void givenARangeOfAgesThatOverlapsWithTheAgeOfAnEmployeeGetByAgeRangeReturnsAListContainingThatEmployee() {
        int lower = 30; int higher = 40;
        List<Employee> expected = List.of(employees.get(1));
        Assertions.assertEquals(expected, dao.getByAgeRange(lower, higher));
    }

    @Test
    @DisplayName("Given a range of ages that overlaps the ages of all employees, getByAgeRange returns a list of all employees")
    void givenARangeOfAgesThatOverlapsTheAgesOfAllEmployeesGetByAgeRangeReturnsAListOfAllEmployees() {
        int lower = 10; int higher = 100;
        List<Employee> expected = employees;
        Assertions.assertEquals(expected, dao.getByAgeRange(lower, higher));
    }

    @Test
    @DisplayName("Given a range of ages that overlaps the ages of none of the employees, getByAgeRange returns an empty list")
    void givenARangeOfAgesThatOverlapsTheAgesOfNoneOfTheEmployeesGetByAgeRangeReturnsAnEmptyList() {
        int lower = 5; int higher = 10;
        List<Employee> expected = List.of();
        Assertions.assertEquals(expected, dao.getByAgeRange(lower, higher));
    }

    @Test
    @DisplayName("Given one or more ages that are less than 0, getByAgeRange throws an exception")
    void givenOneOrMoreAgesThatAreLessThan0GetByAgeRangeThrowsAnException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> dao.getByAgeRange(-1, 20));
    }

    @Test
    @DisplayName("Given an upper age that is less than the lower age, getByAgeRange throws an exception")
    void givenAnUpperAgeThatIsLessThanTheLowerAgeGetByAgeRangeThrowsAnException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> dao.getByAgeRange(20, 10));
    }

    @Test
    @DisplayName("Given employees partially match S in last name, return employee")
    void GivenPartialLastNameMatchOfS() {
        List<Employee> employeesTest = new ArrayList<>();
        employeesTest.add(new Employee(111111, "Mr", "Bob", "Jones", "M", "M",
                "bob.jones@mail.com", LocalDate.of(1980, 6, 24),
                LocalDate.of(2010, 9, 1), 30000));
        employeesTest.add(new Employee(222222, "Mrs", "Alice", "Smith", "C", "F",
                "alice.smith@mail.com", LocalDate.of(1990, 11, 5),
                LocalDate.of(2015, 10, 1), 40000));
        Assertions.assertEquals(employeesTest, dao.getByLastNamePartial("S"));
    }

    @Test
    @DisplayName("Given empty string, no employees should be found")
    void givenEmptyStringGiveNoResults() {
        List<Employee> emptyEmployees = new ArrayList<>();
        Assertions.assertEquals(emptyEmployees, dao.getByLastNamePartial(""));
    }

    @Test
    @DisplayName("Given input of ZZZ, no employees should be found")
    void givenInputofZZZGiveNoResults() {
        List<Employee> emptyEmployees = new ArrayList<>();
        Assertions.assertEquals(emptyEmployees, dao.getByLastNamePartial("ZZZ"));
    }


}