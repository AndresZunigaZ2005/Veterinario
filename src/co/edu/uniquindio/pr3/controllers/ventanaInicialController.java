package co.edu.uniquindio.pr3.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ventanaInicialController {

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtFieldCedula;

    @FXML
    private TextField txtFieldCorreo;

    @FXML
    private TextField txtFieldDireccion;

    @FXML
    private TextField txtFieldNombre;

    @FXML
    private TextField txtFieldTelefono;

	private Stage stage;

    @FXML
    /*
     * Papu
     */
    void registrarCliente(ActionEvent event) {
    	System.out.println("Hola mundo");
    }

	public void setStage(Stage primaryStage) {
		this.stage = primaryStage;
	}
}

