package employees;

import logging.LoggerConfig;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static Logger logger = LoggerConfig.configure(App.class.getName());
    public static void main(String[] args) {
        // utils/generateRandomEmployeeSize (final/constant)
        int count = 10;

        logger.info("RUNNING");
        logger.info("RUNNING 2");
        // EmployeeFactory called here
        logger.info(System.getProperty("user.dir"));
        logger.info(Arrays.toString(EmployeeFactory.getEmployees(count)));


        // pass string array into utils/parseData
            // create Employee objects


        // EmployeeDAO (containing array Employee objects)
            // contains functional methods (getById, getByLastNamePartial etc)

    }
}
