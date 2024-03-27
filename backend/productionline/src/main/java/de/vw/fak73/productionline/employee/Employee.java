package de.vw.fak73.productionline.employee;

import de.vw.fak73.productionline.station.Station;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Station station;

    public Employee(long id, String name, Station station) {
        this.id = id;
        this.name = name;
        this.station = station;
    }

    public Employee(String name, Station station) {
        this(0, name, station);
    }

    public Employee(String name) {
        this(name, null);
    }

    public Employee() {
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

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

}
