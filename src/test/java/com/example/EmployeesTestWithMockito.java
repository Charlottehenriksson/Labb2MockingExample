package com.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class EmployeesTestWithMockito {

    @Test
    public void testPayEmployees_SuccessfulPayments() {

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);


        Employee employee1 = new Employee("123", 5000.0);
        Employee employee2 = new Employee("456", 6000.0);
        List<Employee> employees = Arrays.asList(employee1, employee2);


        when(employeeRepository.findAll()).thenReturn(employees);


        Employees employeesSpy = spy(new Employees(employeeRepository, bankService));


        doNothing().when(bankService).pay(anyString(), anyDouble());


        int payments = employeesSpy.payEmployees();


        verify(employeeRepository, times(1)).findAll();
        verify(bankService, times(employees.size())).pay(anyString(), anyDouble());
        verify(employeesSpy, times(1)).payEmployees();


        assertEquals(2, payments);
        assertTrue(employee1.isPaid());
        assertTrue(employee2.isPaid());
    }

    @Test
    public void testPayEmployees_FailedPayments() {

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);


        Employee employee1 = new Employee("123", 5000.0);
        Employee employee2 = new Employee("456", 6000.0);
        List<Employee> employees = Arrays.asList(employee1, employee2);


        when(employeeRepository.findAll()).thenReturn(employees);


        Employees employeesSpy = spy(new Employees(employeeRepository, bankService));


        doThrow(new RuntimeException("Payment failed")).when(bankService).pay(anyString(), anyDouble());


        int payments = employeesSpy.payEmployees();


        verify(employeeRepository, times(1)).findAll();
        verify(bankService, times(employees.size())).pay(anyString(), anyDouble());
        verify(employeesSpy, times(1)).payEmployees();


        assertEquals(0, payments);
        assertFalse(employee1.isPaid());
        assertFalse(employee2.isPaid());
    }
}