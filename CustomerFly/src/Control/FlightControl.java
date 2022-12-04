package Control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;


import Entity.Aircraft;
import Entity.Airport;
import Entity.AirportType;
import Entity.Consts;
import Entity.Flight;
import Entity.FlightInAirport;
import Entity.HirarchSeat;
import Entity.Seat;



  
public class FlightControl{
	private static FlightControl _instance;
	
	private FlightControl() {
	}
	
	public static FlightControl getInstance() {
		if (_instance == null)
			_instance = new FlightControl();
		return _instance;
	}
	
	/**
	 * fetches all flights from DB file.
	 * @return ArrayList of flights.
	 */
	public ArrayList<Flight> getFlights() {
		ArrayList<Flight> results = new ArrayList<Flight>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SELECTALL_FLIGHT);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					
					//public Flight(int id, Time departureTime, Date departureDate, Time landingTime, Date landingDate,  String status, 
					//int aircraftID)
					results.add(new Flight(rs.getInt(i++),rs.getTime(i++), rs.getDate(i++), rs.getTime(i++), rs.getDate(i++), rs.getString(i++),rs.getInt(i++), rs.getInt(i++), rs.getInt(i++),rs.getDate(i++) ));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public ArrayList<Airport> getAirports() {
		ArrayList<Airport> results = new ArrayList<Airport>();
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SELECTALL_AIRPORT);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					//Airport(int id, String country, String city, TimeZone tmz) 
					
					results.add(new Airport(rs.getInt(i++),rs.getString(i++), rs.getString(i++),rs.getString(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public ArrayList<Aircraft> getAircrafts() {
		ArrayList<Aircraft> results = new ArrayList<Aircraft>();
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SELECTALL_AIRCRAFT);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					//public Aircraft(int empennageNumber, int attendantsNumber)
					
					results.add(new Aircraft(rs.getInt(i++),rs.getInt(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public ArrayList<Seat> getSeats() {
		ArrayList<Seat> results = new ArrayList<Seat>();
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SELECTALL_SEAT);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					//public Aircraft(int empennageNumber, int attendantsNumber)
					// int rowNumber, Character seatNumber, string department
					results.add(new Seat(rs.getInt(i++),  rs.getInt(i++), rs.getString(i++),rs.getString(i++),rs.getBoolean(i++), rs.getInt(i++)  ));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	
	/*----------------------------------------- ADD / REMOVE / UPDATE FLIGHT METHODS --------------------------------------------*/
	/**
	 * Adding a new Flight with the parameters received from the form.
	 * return true if the insertion was successful, else return false
     * @return 
	 */
	public boolean addFlight(int id,Time departureTime, Date departureDate, Time landingTime, Date landingDate,String status,int destID, int origID, int aircraftID) {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_ADD_NEW_FLIGHT)) {

				int i = 1;
				stmt.setInt(i++, id); // id cant be null
				//if(departureTime != null) 
					stmt.setTime(i++, departureTime);
//				else 
//					stmt.setNull(i++, java.sql.Types.TIME);
				
				//if(departureDate != null) 
					stmt.setDate(i++, departureDate);
//				else 
//					stmt.setNull(i++, java.sql.Types.DATE);
				
				//if(landingTime != null) 
					stmt.setTime(i++, landingTime);
//				else 
//					stmt.setNull(i++, java.sql.Types.TIME);

				//if(landingDate != null) 
					stmt.setDate(i++, landingDate);
//				else 
//					stmt.setNull(i++, java.sql.Types.DATE);
				
				//if(status != null) 
					stmt.setString(i++, status);
//				else
//					stmt.setNull(i++, java.sql.Types.VARCHAR);

					stmt.setInt(i++, destID);

					stmt.setInt(i++, origID);

				//if(aircraftID != null) 
					stmt.setInt(i++, aircraftID);
//				else
//					stmt.setNull(i++, java.sql.Types.INTEGER);
				
				stmt.executeUpdate();
				System.out.println("added");
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
public boolean addToFlightInAirport(int idFlight,int  idAirport, String OrigOrDest) {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_ADD_FLIGHT_TO_FLIGHTINAIRPORT)) {

				int i = 1;
				stmt.setInt(i++, idFlight); // id cant be null
				//if(departureTime != null) 
				stmt.setInt(i++, idAirport);
				stmt.setString(i++, OrigOrDest);
				
				stmt.executeUpdate();
				System.out.println("added");
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * Delete the selected flight in form.
	 * return true if deleting was successful, else - return false
	 * @param flightID - the flight to delete from DB
     * @return 
	 */
	public boolean removeFlight(int flightID) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_DELETE_FLIGHT)) {
				
				stmt.setInt(1, flightID);
				stmt.executeUpdate();
				
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public boolean updateFlight(int id, Time departureTime, Date departureDate, Time landingTime, Date landingDate, int orgAirportId,
			int destAirportId, String status, int aircraftID, Date lastUpdated) {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPDATE_FLIGHT)) {
				
				int i = 1;
				
					stmt.setTime(i++, departureTime); 
					stmt.setDate(i++, departureDate);
					stmt.setTime(i++, landingTime);
					stmt.setDate(i++, landingDate);
					stmt.setInt(i++, destAirportId);
					stmt.setInt(i++, orgAirportId);
					stmt.setString(i++, status);
					stmt.setInt(i++, aircraftID);
					stmt.setDate(i++, lastUpdated);
					stmt.setInt(i++, id); // id cant be null
				
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateSeats(int id, int rowNumber, String seatNumber,
			String department, int aircraftID, boolean busy) {
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall(Consts.SQL_UPDATE_Seat)) {
				
				int i = 1;
					
					stmt.setString(i++, department);
					stmt.setBoolean(i++, busy);
					stmt.setInt(i++, rowNumber);
					stmt.setString(i++, seatNumber);
					stmt.setInt(i++, aircraftID);
					stmt.setInt(i++, id);
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	
	
}
