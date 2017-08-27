package com.bhanu.pr.AppointmentManagement.Databse;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.glassfish.jersey.jaxb.internal.XmlCollectionJaxbProvider.App;

import com.bhanu.pr.AppointmentManagement.Model.Appointment;

public class DatabaseClass {
	
	 
	
	
	
	@SuppressWarnings("null")
	public   Map<Integer, Appointment> getAllAppointments() {
		DBConnection dbconn=new DBConnection();
		int count = 0;
		Map<Integer,Appointment> appointmnets=new HashMap<>() ;
		try {
			Connection conn=dbconn.getConnection();
			Statement smt=conn.createStatement();
			String sqlstr="select * from public.appointmnet";
			ResultSet rs = smt.executeQuery(sqlstr);
			while ( rs.next() ) {
				Appointment ap=new Appointment();
				int id=rs.getInt("ID");
				String TIme_Slot=rs.getString("TIme_Slot");
				String Availability=rs.getString("Availability");
				String appointee=rs.getString("appointee");
			//	Instant last_updated=rs.getDate("last_updated").toInstant();
				
				ap.setAppointee(appointee);
				ap.setAvailability(Availability);
				ap.setId(id);
				ap.setTIme_Slot(TIme_Slot);
				//ap.setLast_updated(last_updated);
				appointmnets.put(count, ap);
				count++;
				//System.out.println("*"+ap.getAppointee());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return appointmnets;
	}
	
	
	public Appointment addAppointment(String name,String time) throws SQLException{
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getConnection();

		Appointment appointmnet=new Appointment();
		try {
			
			Statement smt=conn.createStatement();
			conn.setAutoCommit(false);
			 String sqlupdate = "UPDATE public.appointmnet set \"appointee\" = '"+name+"',\"Availability\"='N', last_updated=current_timestamp where \"TIme_Slot\"='"+time+"';";
			 System.out.println(sqlupdate);
			 smt.executeUpdate(sqlupdate);
			 conn.commit();

			
			String sqlstr="select * from public.appointmnet where \"appointee\" = '"+name+"';";
			ResultSet rs = smt.executeQuery(sqlstr);
			while ( rs.next() ) {
				
				int id=rs.getInt("ID");
				String TIme_Slot=rs.getString("TIme_Slot");
				String Availability=rs.getString("Availability");
				String appointee=rs.getString("appointee");
				//Instant last_updated=rs.getDate("last_updated").toInstant();
				
				appointmnet.setAppointee(appointee);
				appointmnet.setAvailability(Availability);
				appointmnet.setId(id);
				appointmnet.setTIme_Slot(TIme_Slot);
				//appointmnet.setLast_updated(last_updated);
			
				System.out.println("*"+appointmnet.getAppointee());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		return appointmnet;
		
	}
	
	
	public Appointment updateAppointment(String time,String name,int id){
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getConnection();
		Appointment appointmnet=new Appointment();
		try {
			
			Statement smt=conn.createStatement();
			conn.setAutoCommit(false);
			String sqlupdate_old="UPDATE public.appointmnet set \"appointee\" = null,\"Availability\"='Y', last_updated=current_timestamp where \"ID\"="+id+";";
			smt.executeUpdate(sqlupdate_old);
			conn.commit();
			 String sqlupdate = "UPDATE public.appointmnet set \"appointee\" = '"+name+"',\"Availability\"='N', last_updated=current_timestamp where \"TIme_Slot\"='"+time+"';";
			 System.out.println(sqlupdate);
			 smt.executeUpdate(sqlupdate);
			 conn.commit();

			
			String sqlstr="select * from public.appointmnet where \"appointee\" = '"+name+"';";
			ResultSet rs = smt.executeQuery(sqlstr);
			while ( rs.next() ) {
				
				int id_new=rs.getInt("ID");
				String TIme_Slot=rs.getString("TIme_Slot");
				String Availability=rs.getString("Availability");
				String appointee=rs.getString("appointee");
				//Date last_updated=rs.getDate("last_updated");
				//Instant last_updated=rs.getDate("last_updated").toInstant();
				appointmnet.setAppointee(appointee);
				appointmnet.setAvailability(Availability);
				appointmnet.setId(id_new);
				appointmnet.setTIme_Slot(TIme_Slot);
				//appointmnet.setLast_updated(last_updated);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointmnet;
		
	}
	
	public Appointment deleteAppointment(int id){
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getConnection();
		Appointment appointmnet=new Appointment();
		try {
			
			Statement smt=conn.createStatement();
			conn.setAutoCommit(false);
			String sqlupdate_old="UPDATE public.appointmnet set \"appointee\" = null,\"Availability\"='Y', last_updated=current_timestamp where \"ID\"="+id+";";
			smt.executeUpdate(sqlupdate_old);
			
			 conn.commit();

			
			String sqlstr="select * from public.appointmnet where \"ID\" = "+id+";";
			ResultSet rs = smt.executeQuery(sqlstr);
			while ( rs.next() ) {
				
				int id_new=rs.getInt("ID");
				String TIme_Slot=rs.getString("TIme_Slot");
				String Availability=rs.getString("Availability");
				String appointee=rs.getString("appointee");
				//Date last_updated=rs.getDate("last_updated");
				//Instant last_updated=rs.getDate("last_updated").toInstant();
				appointmnet.setAppointee(appointee);
				appointmnet.setAvailability(Availability);
				appointmnet.setId(id_new);
				appointmnet.setTIme_Slot(TIme_Slot);
				//appointmnet.setLast_updated(last_updated);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointmnet;
		
		
	}

	public Appointment getAppointmentbytime(String time){
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getConnection();
		Appointment appointmnet=new Appointment();
		try {
			
			Statement smt=conn.createStatement();
			conn.setAutoCommit(false);
			String sqlstr="select * from public.appointmnet where \"TIme_Slot\" = '"+time+"';";
			ResultSet rs = smt.executeQuery(sqlstr);
			while ( rs.next() ) {
				
				int id_new=rs.getInt("ID");
				String TIme_Slot=rs.getString("TIme_Slot");
				String Availability=rs.getString("Availability");
				String appointee=rs.getString("appointee");
			//	Date last_updated=rs.getDate("last_updated");
				//Instant last_updated=rs.getDate("last_updated").toInstant();
				appointmnet.setAppointee(appointee);
				appointmnet.setAvailability(Availability);
				appointmnet.setId(id_new);
				appointmnet.setTIme_Slot(TIme_Slot);
				//appointmnet.setLast_updated(last_updated);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointmnet;
		
	}
	
	public Appointment getAppointmentbyname(String name){
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getConnection();
		Appointment appointmnet=new Appointment();
		try {
			
			Statement smt=conn.createStatement();
			conn.setAutoCommit(false);
			String sqlstr="select * from public.appointmnet where \"appointee\" = '"+name+"';";
			ResultSet rs = smt.executeQuery(sqlstr);
			while ( rs.next() ) {
				
				int id_new=rs.getInt("ID");
				String TIme_Slot=rs.getString("TIme_Slot");
				String Availability=rs.getString("Availability");
				String appointee=rs.getString("appointee");
				//Date last_updated=rs.getDate("last_updated");
				//Instant last_updated=rs.getDate("last_updated").toInstant();
				appointmnet.setAppointee(appointee);
				appointmnet.setAvailability(Availability);
				appointmnet.setId(id_new);
				appointmnet.setTIme_Slot(TIme_Slot);
				//appointmnet.setLast_updated(last_updated);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointmnet;
	}
	
	public   Map<Integer, Appointment> getAvilableAppointment() {
		DBConnection dbconn=new DBConnection();
		Connection conn=dbconn.getConnection();
		int count = 0;
		Map<Integer,Appointment> appointmnets=new HashMap<>() ;
		try {
			
			Statement smt=conn.createStatement();
			String sqlstr="select * from public.appointmnet where \"Availability\" = 'Y';";
			ResultSet rs = smt.executeQuery(sqlstr);
			while ( rs.next() ) {
				Appointment ap=new Appointment();
				int id=rs.getInt("ID");
				String TIme_Slot=rs.getString("TIme_Slot");
				String Availability=rs.getString("Availability");
				String appointee=rs.getString("appointee");
				//Date last_updated=rs.getDate("last_updated");
				//Instant last_updated=rs.getDate("last_updated").toInstant();
				ap.setAppointee(appointee);
				ap.setAvailability(Availability);
				ap.setId(id);
				ap.setTIme_Slot(TIme_Slot);
				//ap.setLast_updated(last_updated);
				appointmnets.put(count, ap);
				count++;
				System.out.println("count "+count);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appointmnets;
	}
	
	
}
