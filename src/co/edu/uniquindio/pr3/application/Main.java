package co.edu.uniquindio.pr3.application;

import co.edu.uniquindio.pr3.controllers.VentanaMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage)   {
		try {
	        // Cargar el ícono desde el archivo de recursos
	        Image icon = new Image(getClass().getResourceAsStream("/imagenes/patita de perro.png"));

	        // Configurar el ícono de la aplicación
	        primaryStage.getIcons().add(icon);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/pr3/views/ventanaMenu.fxml"));
			Parent root = loader.load();
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.setResizable(false);
			VentanaMenuController loginController = loader.getController();
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
