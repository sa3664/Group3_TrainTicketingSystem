package edu.drexel.TrainDemo.models;

import java.sql.Time;
import java.util.List;

public class Path {
   
    private String fromStop;
    private String toStop;
    private Time departureTime;
    private Time arrivalTime;
    List<Connection> connection;

	public Path(){
		
	}

    public Path(String fromStop, String toStop, Time departureTime , Time arrivalTime , List<Connection> connection) {
        this.fromStop=fromStop;
        this.toStop=toStop;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.connection=connection;
    }


    public String getFromStop() {
        return fromStop;
    }

    public void setFromStop(String fromStop) {
        this.fromStop = fromStop;
    }

    public String getToStop() {
        return toStop;
    }

    public void setToStop(String toStop) {
        this.toStop = toStop;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Connection> getConnection() {
        return connection;
    }

    public void setConnection(List<Connection> connection) {
        this.connection = connection;
    }


}

