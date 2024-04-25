package employees;

import java.time.LocalDate;
import java.util.Objects;

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

    private final int salary;

    public Employee(int empId, String prefix, String firstName, String lastName, String middleInitial, String gender, String email, LocalDate dateOfBirth, LocalDate dateOfJoin, int salary) {
        this.empId = empId;
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoin = dateOfJoin;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && salary == employee.salary && Objects.equals(prefix, employee.prefix) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(middleInitial, employee.middleInitial) && Objects.equals(gender, employee.gender) && Objects.equals(email, employee.email) && Objects.equals(dateOfBirth, employee.dateOfBirth) && Objects.equals(dateOfJoin, employee.dateOfJoin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, prefix, firstName, lastName, middleInitial, gender, email, dateOfBirth, dateOfJoin, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", prefix='" + prefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfJoin=" + dateOfJoin +
                ", salary=" + salary +
                '}';
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

    public int getSalary() {
        return salary;
    }
}
