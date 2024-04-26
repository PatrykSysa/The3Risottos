package employees;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
    Employee getById(int employeeId);
    List<Employee> getByLastNamePartial(String lastNamePartial);
    List<Employee> getByHiredDateRange(LocalDate start, LocalDate end);
    List<Employee> getByAgeRange(int lowerAge, int upperAge);
}
