package com.example;

import java.util.List;

public interface EmployeeRepository {

	List<Employee> findAll();

	void updateEmployee(Employee employee);

	Employee save(Employee e);
}
