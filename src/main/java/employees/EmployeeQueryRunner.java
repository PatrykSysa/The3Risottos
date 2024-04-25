package employees;

import output.EmployeePrinter;
import output.EmployeeTableFormatter;

import java.time.LocalDate;
import java.util.List;

public class EmployeeQueryRunner {

    private final EmployeeDAO dao;
    private final EmployeePrinter printer;

    public EmployeeQueryRunner() {
        int numEmployees = Utils.generateRandomEmployeeCount();
        String[] rawEmployeeData = EmployeeFactory.getEmployees(numEmployees);
        List<Employee> parsedEmployeeData = Utils.parseEmployeeData(rawEmployeeData);

        dao = new EmployeeDAO(parsedEmployeeData);
        printer = new EmployeePrinter(new EmployeeTableFormatter());
    }

    public void getById(int employeeId) {
        Employee found = dao.getById(employeeId);
        List<Employee> foundList = found == null ? List.of() : List.of(found);
        printer.print(foundList);
    }

    public void getByLastNamePartial(String partialLastName) {
        List<Employee> employees = dao.getByLastNamePartial(partialLastName);
        printer.print(employees);
    }

    public void getByHiredDateRange(LocalDate start, LocalDate end) {
        List<Employee> employees = dao.getByHiredDateRange(start, end);
        printer.print(employees);
    }
    
    public void getByAgeRange(int lowerAge, int upperAge) {
        List<Employee> employees = dao.getByAgeRange(lowerAge, upperAge);
        printer.print(employees);
    }
}
