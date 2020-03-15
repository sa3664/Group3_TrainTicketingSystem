package edu.drexel.TrainDemo.models;

import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trip")
public class Trip {

	@Id
	private BigInteger id ;
    private BigInteger route_Id;
    private BigInteger calendar_Id;
    private String headsign;
    private Boolean direction;
 
	protected Trip() {
	}

	public Trip(BigInteger id, BigInteger route_Id, BigInteger calendar_Id,String headsign,Boolean direction) {
        this.id = id;
        this.route_Id=route_Id;
        this.calendar_Id=calendar_Id;
        this.headsign=headsign;
        this.direction=direction;
	}

	@Override
	public String toString() {
		return "Trip{" + "id='" + id + '\'' + ", route_Id='" + route_Id + '\'' + ",calendar_Id='" + calendar_Id + '\'' + ",headsign='" + headsign + '\'' + ", direction=" + direction + '}';
	}

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getRoute_Id() {
        return route_Id;
    }

    public void setRoute_Id(BigInteger route_Id) {
        this.route_Id = route_Id;
    }

    public BigInteger getCalendar_Id() {
        return calendar_Id;
    }

    public void setCalendar_Id(BigInteger calendar_Id) {
        this.calendar_Id = calendar_Id;
    }

    public String getHeadsign() {
        return headsign;
    }

    public void setHeadsign(String headsign) {
        this.headsign = headsign;
    }

    public Boolean getDirection() {
        return direction;
    }

    public void setDirection(Boolean direction) {
        this.direction = direction;
    }


}
