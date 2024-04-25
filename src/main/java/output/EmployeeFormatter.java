package output;

import employees.Employee;

import java.util.List;

public interface EmployeeFormatter {
    String NO_RESULTS_MESSAGE = "No employees matching your query were found";

    String format(List<Employee> employees);
}
