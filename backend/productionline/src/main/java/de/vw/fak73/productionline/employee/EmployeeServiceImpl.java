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

    @Override
    public Employee saveEmployee(Employee request) {
        Optional<Employee> optional = this.employeeRepository.findByName(request.getName());
        if (optional.isPresent()) {
            throw new CannotSaveObjectException(String.format(
                    "Could not save requested employee. Employee with name %s already exists.", request.getName()));
        }
        return this.employeeRepository.save(request);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = this.employeeRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ObjectNotFoundException(String.format("Employee with id %d not found.", id));
        }

        return optional.get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> optional = this.employeeRepository.findById(employee.getId());
        if (optional.isEmpty()) {
            throw new ObjectNotFoundException(String.format("Employee with id %d not found.", employee.getId()));
        }
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Optional<Employee> optional = this.employeeRepository.findById(employee.getId());
        if (optional.isEmpty()) {
            throw new ObjectNotFoundException(String.format("Employee with id %d not found.", employee.getId()));
        }
        this.employeeRepository.delete(employee);
    }

}
