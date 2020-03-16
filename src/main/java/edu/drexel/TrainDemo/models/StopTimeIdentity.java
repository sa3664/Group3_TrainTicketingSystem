package edu.drexel.TrainDemo.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Embeddable;

import com.sun.istack.NotNull;

@Embeddable
public class StopTimeIdentity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @NotNull
    private BigInteger trip_Id;

    @NotNull 
    private String stop_Id;

    public StopTimeIdentity(){

    }

    public StopTimeIdentity(BigInteger trip_id, String stop_id) {
        trip_Id = trip_id;
        stop_Id = stop_id;
    }

    public BigInteger getTrip_Id() {
        return trip_Id;
    }

    public void setTrip_Id(BigInteger trip_id) {
        trip_Id = trip_id;
    }

    public String getStop_id() {
        return stop_Id;
    }

    public void setStop_id(String stop_id) {
        stop_Id = stop_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StopTimeIdentity that = (StopTimeIdentity) o;

        if (!trip_Id.equals(that.trip_Id)) return false;
        return stop_Id.equals(that.stop_Id);
    }

    @Override
    public int hashCode() {
        int result = trip_Id.hashCode();
        result = result + stop_Id.hashCode();
        return result;
    }

}