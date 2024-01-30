package com.example;
import org.junit.jupiter.api.Test;
import testdoubles.CustomBankServiceSpy;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesTest {

    @Test
    public void testPayEmployees_CustomImplementation() {
        EmployeeRepository employeeRepositoryStub = new EmployeeRepository() {
            @Override
            public List<Employee> findAll() {
                return Arrays.asList(new Employee("1", 1000), new Employee("2", 1500));
            }

            @Override
            public void updateEmployee(Employee employee) {

            }

            @Override
            public Employee save(Employee e) {
                return null;
            }
        };

        BankService bankService = new CustomBankServiceSpy(false);

        Employees employees = new Employees(employeeRepositoryStub, bankService);

        int payments = employees.payEmployees();

        assertEquals(2, payments);

        BankService bankServiceWithException = new CustomBankServiceSpy(true);

        Employees employeesWithException = new Employees(employeeRepositoryStub, bankServiceWithException);

        int paymentsWithException = employeesWithException.payEmployees();

        assertEquals(0, paymentsWithException);
    }

}




