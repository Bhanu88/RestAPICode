package com.bhanu.pr.AppointmentManagement.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bhanu.pr.AppointmentManagement.Databse.DatabaseClass;
import com.bhanu.pr.AppointmentManagement.Model.Appointment;



public class AppointmentService {

	DatabaseClass dbclass=new DatabaseClass();
	private Map<Integer, Appointment> appointments;
	private Appointment appointment=null;

	public List<Appointment> getAllAppointment() {
		appointments=dbclass.getAllAppointments();
		return new ArrayList<Appointment>(appointments.values());
	}
	
	public Appointment addAppointment(String name,String timeslot) throws SQLException {
		appointment=dbclass.addAppointment(name, timeslot);
		return appointment;
	}
	
	public Appointment updateAppointment(String time,String name,int id){
		appointment=dbclass.updateAppointment(time, name, id);
		return appointment;
		
	}
	
	public Appointment deleteAppointment(int id){
		appointment=dbclass.deleteAppointment(id);
	return appointment;
	}
	
	public Appointment getAppointmentbytime(String timeslot) {
		appointment=dbclass.getAppointmentbytime(timeslot);
		return appointment;
	}
	
	public Appointment getAppointmentbyname(String name) {
		appointment=dbclass.getAppointmentbyname(name);
		return appointment;
	}
	
	public List<Appointment> getAvilableAppointment() {
		appointments=dbclass.getAvilableAppointment();
		return new ArrayList<Appointment>(appointments.values());
	}
}
