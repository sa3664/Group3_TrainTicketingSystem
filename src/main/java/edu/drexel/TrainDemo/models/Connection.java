package edu.drexel.TrainDemo.models;

import java.math.BigInteger;

import javax.persistence.Id;


public class Connection {

    @Id
    private BigInteger id;
    private Trip trip;
    private Stop startStop;
    private Stop endStop;

    protected Connection() {
    }

    public Connection(BigInteger id, Trip trip, Stop startStop, Stop endStop) {
        this.id = id;
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
