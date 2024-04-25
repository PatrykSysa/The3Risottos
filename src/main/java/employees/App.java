package employees;

import logging.LoggerConfig;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = LoggerConfig.configure(App.class.getName());
    public static void main(String[] args) {
        final int numEmployees = Utils.generateRandomEmployeeCount();

        String[] rawEmployeeData = EmployeeFactory.getEmployees(numEmployees);
        List<Employee> parsedEmployeeData = Utils.parseEmployeeData(rawEmployeeData);

        // EmployeeDAO (containing array Employee objects)
            // contains functional methods (getById, getByLastNamePartial etc)

    }
}