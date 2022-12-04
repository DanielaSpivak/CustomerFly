package Control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Airport;
import Entity.Consts;
import Entity.Flight;
import Entity.FlightAttendant;
import Entity.Pilot;



public class StaffControl {

	private int minStaffInFlight;
	private static StaffControl _instance;
		
	private StaffControl () {
	}
		
	public static StaffControl getInstance() {
		if (_instance == null)
			_instance = new StaffControl();
		return _instance;
	}
	
	public ArrayList<Pilot> getPilots() {
		ArrayList<Pilot> results = new ArrayList<Pilot>();
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SELECTALL_PILOTS);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					//(int id, String firstName, String lastName, Date startDate, Date finishDate, 
					//int licenseNumber, Date dateOfLiscense)
					results.add(new Pilot(rs.getInt(i++),rs.getString(i++), rs.getString(i++),rs.getDate(i++), rs.getDate(i++),rs.getInt(i++), rs.getDate(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
		


	public ArrayList<FlightAttendant> getFlightAttendants() {
	ArrayList<FlightAttendant> results = new ArrayList<FlightAttendant>();
	
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SELECTALL_FLIGHTATTENDED);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				//(int id, String firstName, String lastName, Date startDate, Date finishDate, 
				
				results.add(new FlightAttendant(rs.getInt(i++),rs.getString(i++), rs.getString(i++),rs.getDate(i++), rs.getDate(i++)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}

	
}
		
	


