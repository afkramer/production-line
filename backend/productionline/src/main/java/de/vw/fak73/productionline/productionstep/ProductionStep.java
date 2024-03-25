package de.vw.fak73.productionline.productionstep;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "productionStepType", visible = true)
public abstract class ProductionStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long productionTimeInMinutes;

    private double failureProbability;

    protected ProductionStep(String name, long productionTimeInMinutes, double failureProbability) {
        this.name = name;
        this.productionTimeInMinutes = productionTimeInMinutes;
        this.failureProbability = failureProbability;
    }

    protected ProductionStep() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductionTimeInMinutes() {
        return productionTimeInMinutes;
    }

    public void setProductionTimeInMinutes(long productionTimeInMinutes) {
        this.productionTimeInMinutes = productionTimeInMinutes;
    }

    public double getFailureProbability() {
        return failureProbability;
    }

    public void setFailureProbability(double failureProbability) {
        this.failureProbability = failureProbability;
    }

}
