package Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import Entity.Flight;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Main extends Application{
	static Flight newf;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlightSystem.getInstance();

		launch(args);
		
		
		//ReadJSN.importFlightsFromJSON("json/flights.json");

		
	}
	public void start(Stage primaryStage) throws Exception 
	{
		Parent root = FXMLLoader.load(getClass().getResource("/Boundry/MainScreen.fxml"));
		Scene scene = new Scene(root);  //size of window
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);  //not resizeable
		primaryStage.initStyle(StageStyle.DECORATED);
		FileInputStream input;

		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) 
			{
				Platform.exit();
				System.exit(0);
			}
		});

	}

	
}


