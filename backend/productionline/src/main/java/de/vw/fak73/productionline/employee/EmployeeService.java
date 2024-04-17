package de.vw.fak73.productionline.employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee request);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
