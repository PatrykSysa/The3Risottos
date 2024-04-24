package employees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private List<Employee> employees;

    public EmployeeDAO(List<Employee> employees) {
        this.employees = employees;
    }
//
//
//
//
//    public createEmployeeDAO(Employee e) {
//
//    }
//
//    public Employee getById(Employee e) {
//
//    }
//    public Employee getByLastNamePartial(Employee e) {
//
//    }
    public List<Employee> getByHiredDateRange(LocalDate start, LocalDate end) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            LocalDate hiredDate = employee.getDateOfJoin();
            if (hiredDate.isAfter(start) && hiredDate.isBefore(end)) {
                result.add(employee);
            }
        }
        return result;
    }

}
