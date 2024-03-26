package de.vw.fak73.productionline.employee;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveEmployee'");
    }

    @Override
    public List<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEmployees'");
    }

    @Override
    public Employee getEmployeeById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployeeById'");
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    @Override
    public void deleteEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }

}
