package Boundry;

import java.io.IOException;

import Control.ReadJSN;
import Control.ReportControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainScreen {

    private Stage stage;
    

    
    public void importJsn(ActionEvent e) {
    	ReadJSN.importFlightsFromJSON("json/flights.json");
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Importing Jason File");
    	alert.setContentText("Import succeeded.");
    	alert.showAndWait();
    }
    
    public void produceReport(ActionEvent e) {
    	ReportControl.getInstance().produceReport();
    }
    
    public void moveToMangeOrdersScreen(ActionEvent event) throws IOException {
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		SceneManager.MoveToScene("UpdatedFlights", this, stage.getScene(), stage);
		
    }
}

