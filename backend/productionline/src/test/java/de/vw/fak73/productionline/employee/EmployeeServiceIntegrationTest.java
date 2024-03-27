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
        EmployeeRequest request = new EmployeeRequest("Norma", null);

        EmployeeResponse response = this.employeeService.saveEmployee(request);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(employeeCount + 1, this.employeeRepository.count());
        Assertions.assertTrue(response.id() > 0);
        Assertions.assertEquals("Norma", response.name());
        Assertions.assertNull(response.station());
    }

    @Test
    void saveEmployeeWithoutStationFailure() {
        long employeeCount = this.employeeRepository.count();
        EmployeeRequest request = new EmployeeRequest(existingName, null);

        Assertions.assertThrows(CannotSaveObjectException.class, () -> this.employeeService.saveEmployee(request));
        Assertions.assertEquals(employeeCount, this.employeeRepository.count());
    }

    @Test
    void getAllEmployeesSuccess() {
        long employeeCount = this.employeeRepository.count();

        List<EmployeeResponse> results = this.employeeService.getAllEmployees();
        Assertions.assertEquals(employeeCount, results.size());
    }

    @Test
    void getEmployeeByIdSuccess() {
        EmployeeResponse response = this.employeeService.getEmployeeById(this.existingEmployee.getId());

        Assertions.assertNotNull(response);
        Assertions.assertEquals(existingEmployee.getName(), response.name());
    }
}
