package output;

import employees.Employee;

import java.util.List;

public class EmployeePrinter {
    private EmployeeFormatter formatter;

    public EmployeePrinter(EmployeeFormatter formatter) {
        this.formatter = formatter;
    }

    public void print(List<Employee> employees) {
        System.out.println(formatter.format(employees));
    }

    public void setFormatter(EmployeeFormatter formatter) {
        this.formatter = formatter;
    }
}
