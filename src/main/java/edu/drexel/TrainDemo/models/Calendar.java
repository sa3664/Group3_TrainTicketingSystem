package edu.drexel.TrainDemo.models;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calendar")
public class Calendar {

	@Id
	private BigInteger id ;
    private Boolean monday;
    private Boolean tuesday;
    private Boolean wednesday;
    private Boolean thursday;
    private Boolean friday;
    private Boolean saturday;
    private Boolean sunday;
	private Date start_date ;
	private Date end_date;
	
	protected Calendar() {
	}

	public Calendar(BigInteger id, Boolean monday, Boolean tuesday,Boolean wednesday,Boolean thursday,Boolean friday,Boolean saturday,Boolean sunday,Date start_date, Date end_date) {
		this.id = id;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "Calendar{" + "id='" + id + '\'' + ", monday='" + monday + '\'' + ",tuesday='" + tuesday + '\'' + ",wednesday='" + wednesday + '\'' + ", thursday='" + thursday + '\'' + ",friday='" + friday + '\'' + ",saturday='" + saturday + '\'' + ",sunday='" + sunday + '\'' + ",start_date='" + start_date + '\'' + ", end_date=" + end_date + '}';
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Boolean getMonday() {
		return monday;
	}

	public void setMonday(Boolean monday) {
		this.monday = monday;
	}

	public Boolean getTuesday() {
		return tuesday;
	}

	public void setTuesday(Boolean tuesday) {
		this.tuesday = tuesday;
	}

	public Boolean getWednesday() {
		return wednesday;
	}

	public void setWednesday(Boolean wednesday) {
		this.wednesday = wednesday;
	}

	public Boolean getThursday() {
		return thursday;
	}

	public void setThursday(Boolean thursday) {
		this.thursday = thursday;
	}

	public Boolean getFriday() {
		return friday;
	}

	public void setFriday(Boolean friday) {
		this.friday = friday;
	}

	public Boolean getSaturday() {
		return saturday;
	}

	public void setSaturday(Boolean saturday) {
		this.saturday = saturday;
	}

	public Boolean getSunday() {
		return sunday;
	}

	public void setSunday(Boolean sunday) {
		this.sunday = sunday;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


}
