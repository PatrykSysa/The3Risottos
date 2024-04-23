package employees;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // utils/generateRandomEmployeeSize (final/constant)
        int count = 10;


        // EmployeeFactory called here
        System.out.println(System.getProperty("user.dir"));
        System.out.println(Arrays.toString(EmployeeFactory.getEmployees(count)));


        // pass string array into utils/parseData
            // create Employee objects


        // EmployeeDAO (containing array Employee objects)
            // contains functional methods (getById, getByLastNamePartial etc)

    }
}
