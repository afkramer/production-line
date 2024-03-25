package de.vw.fak73.productionline.robot;

import de.vw.fak73.productionline.productionstep.ProductionStep;
import jakarta.persistence.Entity;

@Entity
public class Robot extends ProductionStep {
    private long maintenanceTimeInMinutes;
    private long maintenanceCycleInMinutes;

    public Robot(String name, long productionTimeInMinutes, double failureProbability, long maintenanceTimeInMinutes,
            long maintenanceCycleInMinutes) {
        super(name, productionTimeInMinutes, failureProbability);
        this.maintenanceTimeInMinutes = maintenanceTimeInMinutes;
        this.maintenanceCycleInMinutes = maintenanceCycleInMinutes;
    }

    public Robot() {
    }

    public long getMaintenanceTimeInMinutes() {
        return maintenanceTimeInMinutes;
    }

    public void setMaintenanceTimeInMinutes(long maintenanceTimeInMinutes) {
        this.maintenanceTimeInMinutes = maintenanceTimeInMinutes;
    }

    public long getMaintenanceCycleInMinutes() {
        return maintenanceCycleInMinutes;
    }

    public void setMaintenanceCycleInMinutes(long maintenanceCycleInMinutes) {
        this.maintenanceCycleInMinutes = maintenanceCycleInMinutes;
    }

}
