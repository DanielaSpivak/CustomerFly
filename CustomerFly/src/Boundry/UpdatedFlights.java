package Boundry;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import Control.CustSystem;
import Control.FlightControl;
import Control.FlightSystem;
import Control.OrderAndCustControl;
import Entity.Flight;
import Entity.Pilot;
import Entity.Seat;
import Entity.StatusEnum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UpdatedFlights implements Initializable{
	
    @FXML
    private TextField flightNo;
    @FXML
    private TextField currentdate;
    @FXML
    private TextField seats;
    @FXML
    private TableView<Flight> flightsTable;

    @FXML
    private TableColumn<Flight, Integer> id;

    @FXML
    private TableColumn<Flight, Time> DepartureTime;

    @FXML
    private TableColumn<Flight, Date> DepartureDate;

    @FXML
    private TableColumn<Flight, Time> LandingTime;
;

    @FXML
    private TableColumn<Flight, Date> LandingDate;
    @FXML
    private TableColumn<Flight, StatusEnum> Stauts;

    @FXML
    private TableColumn<Flight, Integer> origID;

    @FXML
    private TableColumn<Flight, Integer> DestenationID;

    @FXML
    private TableView<Seat> seatTable;
    
    @FXML
    private TableColumn<Seat, Integer> rowNumber;

    @FXML
    private TableColumn<Seat, String> seatNumber;

    @FXML
    private TableColumn<Seat, String> department;

	private Flight currentFlight;
	private ObservableList<Flight> updatedFlightsList;
	private ObservableList<Seat> updatedSeatsInFlightList;
	private Stage stage;

    public void getFlight(Flight currentFlight) {
		this.currentFlight = currentFlight;
		fillChodenFlight();
		fillSeatsTable();
		flightNo.setText(currentFlight.getId()+"");
	}
    
    public void fillChodenFlight() {

		//get seats for selected flight
		int selectionFlightID = flightsTable.getSelectionModel().getSelectedItem().getId();
		ArrayList<Seat> res = FlightSystem.getInstance().getSeatsByFlight(selectionFlightID);
		for(Seat s: res) {
			seatTable.getItems().add(s);
		}
		
	    
    }
    
    public void fillSeatsTable() {
    	//updatedSeatsInFlightList = FXCollections.observableArrayList(FlightSystem.getInstance().getSeats().values());
    	rowNumber.setCellValueFactory(new PropertyValueFactory<Seat, Integer>("rowNumber"));
    	seatNumber.setCellValueFactory(new PropertyValueFactory<Seat, String>("seatNumber"));
    	department.setCellValueFactory(new PropertyValueFactory<Seat, String>("department"));
    }

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		java.util.Date date1 = new java.util.Date();
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
		currentdate.setText(formatter1.format(date1)+"");
		//add only changed flights
		//java.sql.Date todayDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		//java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
		ArrayList<Flight> updatedFlights = new ArrayList<Flight>();
		for (Flight f : FlightSystem.getInstance().getFlights().values()) {
			if (f.getLastUpdated()!=null) {
				java.util.Date utilDate = new java.util.Date(f.getLastUpdated().getTime());
				java.util.Date date = new java.util.Date();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				if (formatter.format(utilDate).equals(formatter.format(date))) {
					updatedFlights.add(f);
				}
			}
		}
		
    	
    	id.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("id"));
    	DepartureTime.setCellValueFactory(new PropertyValueFactory<Flight, Time>("DepartureTime"));
    	DepartureDate.setCellValueFactory(new PropertyValueFactory<Flight,Date>("DepartureDate"));
    	LandingTime.setCellValueFactory(new PropertyValueFactory<Flight,Time>("LandingTime"));
		LandingDate.setCellValueFactory(new PropertyValueFactory<Flight,Date>("LandingDate"));
		Stauts.setCellValueFactory(new PropertyValueFactory<Flight,StatusEnum>("status"));
		origID.setCellValueFactory(new PropertyValueFactory<Flight,Integer>("origID"));
		DestenationID.setCellValueFactory(new PropertyValueFactory<Flight,Integer>("destID"));
    	
		updatedFlightsList = FXCollections.observableArrayList(updatedFlights);
		flightsTable.setItems(updatedFlightsList);
		
		flightsTable.setOnMouseClicked((MouseEvent event) -> {
			if (event.getButton().equals(MouseButton.PRIMARY)) {
				//get seats for selected flight
				int selectionFlightID = flightsTable.getSelectionModel().getSelectedItem().getId();
				ArrayList<Seat> res = FlightSystem.getInstance().getSeatsByFlight(selectionFlightID);
				for(Seat s: res) {
					seatTable.getItems().add(s);
				}
				fillSeatsTable();
				flightNo.setText(selectionFlightID+"");

				seats.setText(res.size()+"");
				seats.setEditable(false);
			}
		});
	}
	//To check it works
	public void switchBack(ActionEvent event) throws IOException {
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();	
		SceneManager.GoBack(stage);
	}
    
    

}
