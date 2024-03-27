package de.vw.fak73.productionline.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.vw.fak73.productionline.exceptions.CannotSaveObjectException;
import de.vw.fak73.productionline.exceptions.ObjectNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private Employee employeeRequestToEmployee(EmployeeRequest request) {
        return new Employee(request.name(), request.station());
    }

    private EmployeeResponse employeeToEmployeeResponse(Employee employee) {
        return new EmployeeResponse(employee.getId(), employee.getName(), employee.getStation());
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest request) {
        Optional<Employee> optional = this.employeeRepository.findByName(request.name());
        if (optional.isPresent()) {
            throw new CannotSaveObjectException(String.format(
                    "Could not save requested employee. Employee with name %s already exists.", request.name()));
        }
        Employee employee = employeeRequestToEmployee(request);
        Employee newEmployee = this.employeeRepository.save(employee);
        return employeeToEmployeeResponse(newEmployee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return this.employeeRepository.findAll().stream().map(this::employeeToEmployeeResponse).toList();
    }

    @Override
    public EmployeeResponse getEmployeeById(long id) {
        Optional<Employee> optional = this.employeeRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ObjectNotFoundException(String.format("Employee with id %d not found.", id));
        }

        return employeeToEmployeeResponse(optional.get());
    }

    @Override
    public EmployeeResponse updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    @Override
    public void deleteEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }

}
