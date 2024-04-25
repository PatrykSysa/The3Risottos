package output;

import employees.Employee;

import java.util.List;

public class EmployeeTableFormatter implements EmployeeFormatter {

    private final String HEADER = """
                | ID | First Name | Last Name |
                ===============================
                """;

    @Override
    public String format(List<Employee> employees) {
        StringBuilder formatted = new StringBuilder(HEADER);
        for (Employee employee : employees) {
            String line = formatLine(employee);
            formatted.append(line);
        }
        return formatted.toString();
    }

    private String formatLine(Employee employee) {
        return "| %d ".formatted(employee.getEmpId())
                + "| %s ".formatted(employee.getFirstName())
                + "| %s |\n".formatted(employee.getLastName());
    }
}
