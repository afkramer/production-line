package de.vw.fak73.productionline.station;

import java.util.Set;

import de.vw.fak73.productionline.employee.Employee;
import de.vw.fak73.productionline.productionstep.ProductionStep;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Station extends ProductionStep {
    @OneToMany(mappedBy = "station")
    private Set<Employee> employees;

    public Station(String name, long productionTimeInMinutes, double failureProbability, Set<Employee> employees) {
        super(name, productionTimeInMinutes, failureProbability);
        this.employees = employees;
    }

    public Station(String name, long productionTimeInMinutes, double failureProbability) {
        this(name, productionTimeInMinutes, failureProbability, null);
    }

    public Station() {
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

}
