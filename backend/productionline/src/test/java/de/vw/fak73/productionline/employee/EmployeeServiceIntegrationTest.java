package de.vw.fak73.productionline.employee;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import de.vw.fak73.productionline.exceptions.CannotSaveObjectException;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class EmployeeServiceIntegrationTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    private String existingName = "Existing Employee";
    private Employee existingEmployee;

    @BeforeEach
    void init() {
        this.employeeRepository.deleteAll();
        Employee employee = new Employee(existingName, null);
        existingEmployee = employeeRepository.save(employee);
    }

    @Test
    void saveEmployeeWithoutStationSuccess() {
        long employeeCount = this.employeeRepository.count();
        Employee request = new Employee("Norma", null);

        Employee response = this.employeeService.saveEmployee(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(employeeCount + 1, this.employeeRepository.count());
        Assertions.assertTrue(response.getId() > 0);
        Assertions.assertEquals("Norma", response.getName());
        Assertions.assertNull(response.getStation());
    }

    @Test
    void saveEmployeeWithoutStationFailure() {
        long employeeCount = this.employeeRepository.count();
        Employee request = new Employee(existingName, null);

        Assertions.assertThrows(CannotSaveObjectException.class, () -> this.employeeService.saveEmployee(request));
        Assertions.assertEquals(employeeCount, this.employeeRepository.count());
    }

    @Test
    void getAllEmployeesSuccess() {
        long employeeCount = this.employeeRepository.count();

        List<Employee> results = this.employeeService.getAllEmployees();
        Assertions.assertEquals(employeeCount, results.size());
    }

    @Test
    void getEmployeeByIdSuccess() {
        Employee response = this.employeeService.getEmployeeById(this.existingEmployee.getId());

        Assertions.assertNotNull(response);
        Assertions.assertEquals(existingEmployee.getName(), response.getName());
    }

}
