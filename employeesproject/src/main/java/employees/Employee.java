package employees;

import java.time.LocalDate;

public class Employee {
    private final int empId;
    private final String prefix; // potential enum
    private final String firstName;
    private final String lastName;
    private final String middleInitial;
    private final String gender; // potential enum
    private final String email;
    private final LocalDate dateOfBirth;
    private final LocalDate dateOfJoin;

    public Employee(int empId, String prefix, String firstName, String lastName, String middleInitial, String gender, String email, LocalDate dateOfBirth, LocalDate dateOfJoin) {
        this.empId = empId;
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoin = dateOfJoin;
    }

    public int getEmpId() {
        return empId;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }
}
