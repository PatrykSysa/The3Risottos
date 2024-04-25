package output;

import employees.Employee;

import java.util.List;

public interface EmployeeFormatter {
    String format(List<Employee> employees);
}
