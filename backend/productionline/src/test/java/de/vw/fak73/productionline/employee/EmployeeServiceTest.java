package de.vw.fak73.productionline.employee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void testCreateSuccessNoStation() {
        Employee request = new Employee("Norma", null);
        Employee employee = new Employee(1l, "Norma", null);

        Mockito.when(employeeRepository.save(request)).thenReturn(employee);

        Employee response = employeeService.saveEmployee(request);
        Mockito.verify(employeeRepository).save(request);
        Assertions.assertNotNull(response);
    }

}
