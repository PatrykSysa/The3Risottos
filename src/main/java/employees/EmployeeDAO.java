package employees;

import logging.LoggerConfig;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeDAO {
    private List<Employee> employees;

    private final Logger LOGGER = LoggerConfig.configure(EmployeeDAO.class.getName());


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
        LOGGER.info("getById method started, looking for:" +employeeId);
        for (Employee employee : employees) {
            LOGGER.fine("current employee id is: " + employee.getEmpId());

            if (employee.getEmpId() == employeeId) {
                LOGGER.finer("Seems employee id: " + employee.getEmpId() + " is equal to: " + employeeId);
                return employee;
            }
        }
        LOGGER.info("no employee found?");
        return null;
    }

//    public Employee getByLastNamePartial(Employee e) {
//
//    }
    public List<Employee> getByHiredDateRange(LocalDate start, LocalDate end) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            LocalDate hiredDate = employee.getDateOfJoin();
            if (isWithinDateRange(hiredDate, start, end)) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getByAgeRange(int lowerAge, int upperAge) {
        checkAgesAreValid(lowerAge, upperAge);
        List<Employee> result = new ArrayList<>();
        LocalDate start = minusYearsFromPresent(upperAge);
        LocalDate end = minusYearsFromPresent(lowerAge);
        LOGGER.info("Searching for DOB between " + start + " and " + end);
        for (Employee employee : employees) {
            if (isWithinDateRange(employee.getDateOfBirth(), start, end)) {
                result.add(employee);
            }
        }
        return result;
    }

    private void checkAgesAreValid(int lowerAge, int upperAge) {
        if (lowerAge < 0) {
            throw new IllegalArgumentException("Ages cannot be negative");
        } else if (upperAge < lowerAge) {
            throw new IllegalArgumentException("The upper age must be greater than the lower age");
        }
    }

    private LocalDate minusYearsFromPresent(int years) {
        LocalDate current = LocalDate.now();
        return current.minusYears(years);
    }

    private boolean isWithinDateRange(LocalDate query, LocalDate start, LocalDate end) {
        LOGGER.finer("Testing if " + query + " is between " + start + " and " + end);
        boolean isAfterStart = query.isAfter(start);
        boolean isBeforeEnd = query.isBefore(end);
        return isAfterStart && isBeforeEnd;
    }

}
