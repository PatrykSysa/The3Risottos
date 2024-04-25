package output;

import employees.Employee;

import java.util.List;

public class EmployeeTableFormatter implements EmployeeFormatter {

    private final String HEADER = """
                | ID | Prefix | First Name | Last Name | Middle Initial | Gender | Email | DOB | Hire Date | Salary |
                ============================================================================================
                """;


    @Override
    public String format(List<Employee> employees) {
        if (employees.isEmpty()) return NO_RESULTS_MESSAGE;
        return buildTable(employees);
    }

    private String buildTable(List<Employee> employees) {
        StringBuilder formatted = new StringBuilder(HEADER);
        for (Employee employee : employees) {
            String line = formatLine(employee);
            formatted.append(line);
        }
        return formatted.toString();
    }

    private String formatLine(Employee employee) {
        return "| %d ".formatted(employee.getEmpId())
                + "| %s ".formatted(employee.getPrefix())
                + "| %s ".formatted(employee.getFirstName())
                + "| %s ".formatted(employee.getLastName())
                + "| %s ".formatted(employee.getMiddleInitial())
                + "| %s ".formatted(employee.getGender())
                + "| %s ".formatted(employee.getEmail())
                + "| %s ".formatted(employee.getDateOfBirth())
                + "| %s ".formatted(employee.getDateOfJoin())
                + "| %d |\n".formatted(employee.getSalary());
    }
}
