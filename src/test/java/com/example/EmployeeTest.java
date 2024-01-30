package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void testEmployeeConstructorAndGetters() {
        Employee employee = new Employee("1", 1000);

        assertEquals("1", employee.getId());
        assertEquals(1000, employee.getSalary(), 0.01);
        assertFalse(employee.isPaid());
    }

    @Test
    public void testEmployeeSetters() {
        Employee employee = new Employee("1", 1000);

        employee.setId("2");
        assertEquals("2", employee.getId());

        employee.setSalary(1500);
        assertEquals(1500, employee.getSalary(), 0.01);

        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    @Test
    public void testEmployeeToString() {
        Employee employee = new Employee("1", 1000);

        assertEquals("Employee [id=1, salary=1000.0]", employee.toString());
    }

}