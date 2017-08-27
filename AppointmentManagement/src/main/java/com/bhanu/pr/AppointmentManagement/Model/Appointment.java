package com.bhanu.pr.AppointmentManagement.Model;


import java.time.*;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
public class Appointment {

	private int id;
	private String Time_slot;
	private String Availability;
	private String appointee;
	private Instant last_updated;
	
	public Appointment(int id,String TIme_Slot,String Availability,String appointee){
		
		this.id=id;
		this.Time_slot=TIme_Slot;
		this.appointee=appointee;
		this.Availability=Availability;
		//this.last_updated=new Date().toInstant();
	}
	
	public Appointment(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTIme_Slot() {
		return Time_slot;
	}

	public void setTIme_Slot(String tIme_Slot) {
		Time_slot = tIme_Slot;
	}

	public String getAvailability() {
		return Availability;
	}

	public void setAvailability(String availability) {
		Availability = availability;
	}

	public String getAppointee() {
		return appointee;
	}

	public void setAppointee(String appointee) {
		this.appointee = appointee;
	}
@XmlTransient
	public Instant getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(Instant last_updated) {
		this.last_updated = last_updated;
	}
	
	
}
