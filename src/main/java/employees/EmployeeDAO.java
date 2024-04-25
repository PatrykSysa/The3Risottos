package employees;

import logging.LoggerConfig;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeDAO {
    private List<Employee> employees;
    private static Logger logger = LoggerConfig.configure(EmployeeDAO.class.getName());

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

    public Employee getById(int employeeId) {
        logger.info("getById method started, looking for:" +employeeId);
        for (Employee employee : employees) {
            logger.fine("current employee id is: " + employee.getEmpId());

            if (employee.getEmpId() == employeeId) {
                logger.finer("Seems employee id: " + employee.getEmpId() + " is equal to: " + employeeId);
                return employee;
            }
        }
        logger.info("no employee found?");
        return null;
    }

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
