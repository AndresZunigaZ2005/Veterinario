package co.edu.uniquindio.pr3.application;

import co.edu.uniquindio.pr3.controllers.ventanaInicialController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage)   {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/pr3/views/ventanaInicial.fxml"));
			Parent root = loader.load();
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
			ventanaInicialController loginController = loader.getController();
	        loginController.setStage(primaryStage);
	        primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main (String args[])   {
		launch(args);
	}
}
