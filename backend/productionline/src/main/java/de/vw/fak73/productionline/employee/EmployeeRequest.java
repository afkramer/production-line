package de.vw.fak73.productionline.employee;

import de.vw.fak73.productionline.station.Station;

public record EmployeeRequest(String name, Station station) {

}
