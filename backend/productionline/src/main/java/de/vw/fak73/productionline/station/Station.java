package de.vw.fak73.productionline.station;

import java.util.Set;

import de.vw.fak73.productionline.employee.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Station {
    @OneToMany(mappedBy = "station")
    private Set<Employee> employees;
}
