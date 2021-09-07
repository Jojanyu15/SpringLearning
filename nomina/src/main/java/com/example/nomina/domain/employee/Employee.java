package com.example.nomina.domain.employee;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
   // @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastName;
    @Column(name="role")
    private String role;

    public Employee() {}

    public Employee(String firstName, String lastName, String role) {

        this.firstname = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getName() {
        return this.firstname + " " + this.lastName;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.firstname = parts[0];
        this.lastName = parts[1];
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.firstname, employee.firstname)
                && Objects.equals(this.lastName, employee.lastName) && Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstname, this.lastName, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", firstName='" + this.firstname + '\'' + ", lastName='" + this.lastName
                + '\'' + ", role='" + this.role + '\'' + '}';
    }
}