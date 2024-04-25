package employees;

import logging.LoggerConfig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Utils {
    private static final Logger LOGGER = LoggerConfig.configure(Utils.class.getName());
    public static int generateRandomEmployeeCount() {
        Random random = new Random();
        return random.nextInt(1, 1001);
    }

    public static List<Employee> parseEmployeeData(String[] rawData) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < rawData.length; i++) {
            String[] parsedEmployee = rawData[i].split(",");
            employeeList.add(new Employee(Integer.parseInt(parsedEmployee[0]), parsedEmployee[1], parsedEmployee[2], parsedEmployee[4], parsedEmployee[3],  parsedEmployee[5],  parsedEmployee[6],  convertToDate(parsedEmployee[7]), convertToDate(parsedEmployee[8]),  Integer.parseInt(parsedEmployee[9])));
        }
        LOGGER.info("employee list: " + employeeList);
        return employeeList;
    }

    public static LocalDate convertToDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(dateString, formatter);
    }

}
