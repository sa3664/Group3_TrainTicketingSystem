package edu.drexel.TrainDemo.models;

import java.math.BigInteger;
import java.sql.Time;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stop_time")
public class StopTime {

    @EmbeddedId
    private StopTimeIdentity id;

    private Integer stop_Sequence;
    private Time arrival_Time;
    private Time departure_Time;
    private Integer pickup_Type;
    private Integer dropoff_Type;

    
	protected StopTime() {
	}

    public StopTime(StopTimeIdentity id, Integer stop_Sequence, Time arrival_Time, Time departure_Time,Integer pickup_Type, Integer dropoff_Type)
     {
        this.id = id;
        this.stop_Sequence=stop_Sequence;
        this.arrival_Time=arrival_Time;
        this.departure_Time=departure_Time;
        this.pickup_Type=pickup_Type;
        this.dropoff_Type=dropoff_Type;
       
	}

	@Override
	public String toString() {
		return "Trip{" + "stopTime_Id='" + id + '\'' + '\'' + ",stop_Sequence='" + stop_Sequence + '\'' + ",arrival_Time='" + arrival_Time + '\'' + ",departure_Time='" + departure_Time + '\'' + ",pickup_Type='" + pickup_Type + '\'' + ", dropoff_Type=" + dropoff_Type + '}';
	}

   

    public Integer getStop_Sequence() {
        return stop_Sequence;
    }

    public void setStop_Sequence(Integer stop_Sequence) {
        this.stop_Sequence = stop_Sequence;
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

    public Integer getPickup_Type() {
        return pickup_Type;
    }

    public void setPickup_Type(Integer pickup_Type) {
        this.pickup_Type = pickup_Type;
    }

    public Integer getDropoff_Type() {
        return dropoff_Type;
    }

    public void setDropoff_Type(Integer dropoff_Type) {
        this.dropoff_Type = dropoff_Type;
    }

    public StopTimeIdentity getId() {
        return id;
    }

    public void setId(StopTimeIdentity id) {
        this.id = id;
    }

    public BigInteger getTrip_id(){
        return getId().getTrip_Id();
    }


}
