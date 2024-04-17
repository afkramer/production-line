package de.vw.fak73.productionline.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void cleanUp() {
        this.employeeRepository.deleteAll();
        Employee employee1 = new Employee("Norma", null);
        Employee employee2 = new Employee("Sandy", null);
        Employee employee3 = new Employee("Penny", null);

        this.employeeRepository.save(employee1);
        this.employeeRepository.save(employee2);
        this.employeeRepository.save(employee3);
    }

    @Test
    void saveEmployeeSuccessTest() {
        long count = this.employeeRepository.count();
        long maxId = this.employeeRepository.findAll().stream().map(Employee::getId).max(Long::compareTo).get();
        String name = "Newbie";
        Employee newEmployee = new Employee(name, null);

        ResponseEntity<Employee> response = restTemplate.postForEntity("/employees", newEmployee, Employee.class);

        Assertions.assertEquals(count + 1, this.employeeRepository.count());
        Assertions.assertEquals(maxId + 1, response.getBody().getId());
        Assertions.assertEquals(name, response.getBody().getName());
    }
}
