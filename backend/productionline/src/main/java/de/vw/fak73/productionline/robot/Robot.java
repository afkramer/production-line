package de.vw.fak73.productionline.robot;

import de.vw.fak73.productionline.productionstep.ProductionStep;
import jakarta.persistence.Entity;

@Entity
public class Robot extends ProductionStep {
    private long maintenanceTimeInMinutes;
    private long maintenanceCycleInMinutes;
}
