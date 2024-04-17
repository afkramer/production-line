package de.vw.fak73.productionline.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    void testCreateSuccessNoStation() {
        NewEmployeeRequest request = new NewEmployeeRequest("Norma", null);
        Employee employee = new Employee(1l, "Norma", null);

        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

        EmployeeResponse response = employeeService.saveEmployee(request);
        Mockito.verify(employeeRepository).save(employee);
        Assertions.assertNotNull(response);
    }

}
