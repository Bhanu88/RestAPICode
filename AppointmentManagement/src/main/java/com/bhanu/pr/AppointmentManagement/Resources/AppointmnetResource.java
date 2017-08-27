package com.bhanu.pr.AppointmentManagement.Resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.bhanu.pr.AppointmentManagement.Model.Appointment;
import com.bhanu.pr.AppointmentManagement.Service.AppointmentService;

@Path("appointment")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AppointmnetResource {
	
	AppointmentService appservice=new AppointmentService();
	@GET
	public List<Appointment> getAppointmnet(){
		//appservice.getAllAppointment();
		return appservice.getAllAppointment();
		
	}
	@PUT
	@Path("/add")
	public Appointment addAppointment(@QueryParam ("time")String timeSlot,@QueryParam ("name")String name) throws SQLException{
		System.out.println("time is "+timeSlot+" name is "+name);
		
		return appservice.addAppointment(name, timeSlot);
	}
	
	@PUT
	@Path("/update")
	public Appointment updateAppointment(@QueryParam("time_new")String timeSlot,@QueryParam("name")String name,@QueryParam("ID_prev")int id){
		return appservice.updateAppointment(timeSlot, name, id);
	}
	
	@DELETE
	@Path("/delete")
	public Appointment deleteAppointment(@QueryParam("id")int id){
		return appservice.deleteAppointment(id);
	}
	
	@GET
	@Path("/avil")
	public List<Appointment> getavliableAppointmnet(){
		return appservice.getAvilableAppointment();
	}	
	
	@GET
	@Path("/byname")
	public Appointment getAppointmentbyName(@QueryParam ("name")String name){
		return appservice.getAppointmentbyname(name);
		
	}
		

	@GET
	@Path("/bytime")
	public Appointment getAppointmentbyTime(@QueryParam ("time")String timeslot){
		return appservice.getAppointmentbytime(timeslot);
		
	}
	
	
		
	}
	


