package Boundry;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*if you wish to use this class:
 * 	public void switchToScenceCustomerView(ActionEvent event) throws IOException {
		 Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 SceneManager.GoBack(stage); 
	}
 */

//Navigator between scenes
public class SceneManager {
	private static Stack<Scene> sceneStack = new Stack<Scene>();
	
	public static void MoveSceneWithData(Parent resource,  Scene currentScene, Stage stage) throws IOException
	{	
		Scene targetScene = new Scene(resource);
		SceneManager.sceneStack.push(currentScene);
		stage.setScene(targetScene);
		stage.show(); 
	}

	
	//move to new scene
	public static <T> T MoveToScene(String sceneName, Object classContext, Scene currentScene, Stage stage) throws IOException
	{
		String fxmlPath = sceneName + ".fxml";
		FXMLLoader loader = new FXMLLoader(classContext.getClass().getResource(fxmlPath));
		Parent resource = (Parent) loader.load();
		Scene targetScene = new Scene(resource);
		SceneManager.sceneStack.push(currentScene);
		stage.setScene(targetScene);
		stage.show(); 
		return loader.getController();
	}
	//Open scene in new window
	public static <T> T OpenNewStage(String sceneName, Object classContext, Object sendData) throws IOException
	{
		String fxmlPath = sceneName + ".fxml";
		FXMLLoader loader = new FXMLLoader(classContext.getClass().getResource(fxmlPath));
		Parent root = (Parent) loader.load();
		Stage stage = new Stage();
		stage.setUserData(sendData);
		Scene newScene = new Scene(root);
		stage.setScene(newScene);
		stage.showAndWait();
		return loader.getController();
	}
	//Go back to previous screen
	public static void GoBack(Stage stage)
	{
		if (SceneManager.sceneStack.isEmpty())
			return;
		
		Scene previousScene = SceneManager.sceneStack.pop();
		stage.setScene(previousScene);
		stage.show(); 
	}
	

}
