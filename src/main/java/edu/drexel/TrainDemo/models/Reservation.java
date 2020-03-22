package edu.drexel.TrainDemo.models;

import java.math.BigInteger;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private BigInteger id;
    @Column(name = "name",  nullable = false)
    private String name;
    @Column(name = "from_stop", nullable = false)
    private String from;
    @Column(name = "to_stop", nullable = false)
    private String to;
    @Column(name = "arrival_time", nullable = false)
    private Time arrival_Time;
    private Time departure_Time;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name = "reservationid", unique = true, nullable = false)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Time getArrival_Time() {
        return arrival_Time;
    }

    public void setArrival_Time(Time arrival_Time) {
        this.arrival_Time = arrival_Time;
    }

    public Time getDeparture_Time() {
        return departure_Time;
    }

    public void setDeparture_Time(Time departure_Time) {
        this.departure_Time = departure_Time;
    }

    public Reservation(String name, String from, String to, Time arrival_Time, Time departure_Time, String email) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.arrival_Time = arrival_Time;
        this.departure_Time = departure_Time;
        this.email = email;
    }
}
