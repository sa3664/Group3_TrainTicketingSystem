package edu.drexel.TrainDemo.models;

import java.math.BigInteger;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private Trip trip;
    private Stop startStop;
    private Stop endStop;

    protected Connection() {
    }

    public Connection( Trip trip, Stop startStop, Stop endStop) {
        this.trip = trip;
        this.startStop = startStop;
        this.endStop = endStop;
    }

    @Override
    public String toString() {
        return "Connection{" + "id='" + id + '\'' + ", trip='" + trip + '\'' + ",startStop='" + startStop
                + '\'' + ", endStop=" + endStop + '}';
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Stop getStartStop() {
        return startStop;
    }

    public void setStartStop(Stop startStop) {
        this.startStop = startStop;
    }

    public Stop getEndStop() {
        return endStop;
    }

    public void setEndStop(Stop endStop) {
        this.endStop = endStop;
    }
    
}
