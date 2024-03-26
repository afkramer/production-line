package de.vw.fak73.productionline.employee;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse saveEmployee(EmployeeRequest request);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
