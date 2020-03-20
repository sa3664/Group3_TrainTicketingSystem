package edu.drexel.TrainDemo.models;

import java.sql.Time;
import java.util.List;
import java.util.Objects;

public class Path {
   
    private String id;
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

    @Override
    public String toString() {
        return "Path [arrivalTime=" + arrivalTime + ", connection=" + connection + ", departureTime=" + departureTime
                + ", fromStop=" + fromStop + ", toStop=" + toStop + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
	public int hashCode() {
		int hash = 5;
		hash = 83 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Path other = (Path) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

}

