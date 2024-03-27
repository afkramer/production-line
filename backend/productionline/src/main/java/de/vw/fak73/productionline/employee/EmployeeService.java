package de.vw.fak73.productionline.employee;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse saveEmployee(EmployeeRequest request);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(long id);

    EmployeeResponse updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
