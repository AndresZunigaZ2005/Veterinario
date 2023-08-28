package co.edu.uniquindio.pr3.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import co.edu.uniquindio.pr3.exceptions.ClienteException;
import co.edu.uniquindio.pr3.exceptions.MascotaException;
import co.edu.uniquindio.pr3.model.Cliente;
import co.edu.uniquindio.pr3.model.ClinicaVeterinaria;
import co.edu.uniquindio.pr3.model.Sexo;
import co.edu.uniquindio.pr3.model.Tipo;
import co.edu.uniquindio.pr3.model.Veterinario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class VentanaMenuController {
	
	private ClinicaVeterinaria clinicaVeterinaria= new ClinicaVeterinaria();

    @FXML
    private ComboBox<String> ComboBoxCambiarEstadoCita;

    @FXML
    private ComboBox<Sexo> ComboBoxSexoMascota;

    @FXML
    private ComboBox<Tipo> ComboBoxTipoMascota;

    @FXML
    private DatePicker DatePickerFechaCita;

    @FXML
    private DatePicker DatePickerFechaFinal;

    @FXML
    private DatePicker DatePickerFechaInicio;

    @FXML
    private Spinner<Integer> SpinnerHoraCita;

    @FXML
    private Spinner<Integer> SpinnerMinutosCita;

    @FXML
    private TreeTableColumn<?, ?> TreeTCIdCita;

    @FXML
    private TreeTableColumn<?, ?> TreeTCIdEstado;

    @FXML
    private TableColumn<?, ?> TreeTCIdEstadoFiltrar;

    @FXML
    private TreeTableColumn<?, ?> TreeTCIdFactura;

    @FXML
    private TreeTableColumn<?, ?> TreeTCIdFecha;

    @FXML
    private TableColumn<?, ?> TreeTCIdFechaFiltrar;

    @FXML
    private TreeTableColumn<?, ?> TreeTCIdFechaHistorial;

    @FXML
    private TableColumn<?, ?> TreeTCIdIdCitaFiltrar;

    @FXML
    private TreeTableColumn<?, ?> TreeTCIdMascota;

    @FXML
    private TableColumn<?, ?> TreeTCIdMascotaFiltrar;

    @FXML
    private TreeTableColumn<?, ?> TreeTCIdVet;

    @FXML
    private TableColumn<?, ?> TreeTCIdVetFiltrar;

    @FXML
    private Button btnActDatosCliente;

    @FXML
    private Button btnActualizarEstado;

    @FXML
    private Button btnAgendarCita;

    @FXML
    private Button btnFiltrarHistorial2;

    @FXML
    private Button btnFiltrarMascotaHistorial;

    @FXML
    private Button btnRegistrarCliente;

    @FXML
    private Button btnRegistrarMascota;

    @FXML
    private TreeTableColumn<?, ?> columnaCedulaCliente;

    @FXML
    private TreeTableColumn<?, ?> columnaCorreoCliente;

    @FXML
    private TreeTableColumn<?, ?> columnaDireccionCliente;

    @FXML
    private TreeTableColumn<?, ?> columnaNombreCliente;

    @FXML
    private TreeTableColumn<?, ?> columnaTelefonoCliente;

    @FXML
    private ComboBox<?> comboBoxSelMascotaHistorial;

    @FXML
    private ComboBox<?> comboBoxSelMascotaICita;

    @FXML
    private ComboBox<Veterinario> comboBoxSelVet;

    @FXML
    private TreeTableView<?> treeTableViewHistorial;

    @FXML
    private TextArea txtAreaDiagnosticoCita;

    @FXML
    private TextArea txtAreaDiagnosticoHistorial;

    @FXML
    private TextArea txtAreaTratamientoCita;

    @FXML
    private TextArea txtAreaTratamientoHistorial;

    @FXML
    private TextField txtFieldCedulaBuscarMascotasCita;

    @FXML
    private TextField txtFieldCedulaCliente;

    @FXML
    private TextField txtFieldCedulaDueñoHistorial;

    @FXML
    private TextField txtFieldCedulaMascota;

    @FXML
    private TextField txtFieldCorreoActCliente;

    @FXML
    private TextField txtFieldCorreoCliente;

    @FXML
    private TextField txtFieldDireccionActCliente;

    @FXML
    private TextField txtFieldDireccionCliente;

    @FXML
    private TextField txtFieldEdadMascota;

    @FXML
    private TextField txtFieldNombreActCliente;

    @FXML
    private TextField txtFieldNombreCliente;

    @FXML
    private TextField txtFieldNombreMascota;

    @FXML
    private TextField txtFieldRazaMascota;

    @FXML
    private TextField txtFieldTelefonoActCliente;

    @FXML
    private TextField txtFieldTelefonoCliente;

    @FXML
    void actualizarDatosCliente(ActionEvent event) {

    }

    @FXML
    void actualizarEstado(ActionEvent event) {

    }

    @FXML
    void agendarCita(ActionEvent event) {
        LocalDate selectedDate = DatePickerFechaCita.getValue();
        int selectedHour = SpinnerHoraCita.getValue();
        int selectedMinute = SpinnerMinutosCita.getValue();
    
        LocalTime selectedTime = LocalTime.of(selectedHour, selectedMinute);
        LocalDateTime selectedDateTime = LocalDateTime.of(selectedDate, selectedTime);

    }

    @FXML
    void filtrarFechaCitas(ActionEvent event) {

    }

    @FXML
    void registrarCliente(ActionEvent event) {
    	
    	String nombreCliente = txtFieldNombreCliente.getText();
    	String telefonoCliente = txtFieldTelefonoCliente.getText();
    	String direccionCliente = txtFieldDireccionCliente.getText();
    	String correoCliente = txtFieldCorreoCliente.getText();
    	String cedulaCliente = txtFieldCedulaCliente.getText();
    	
    	try {
			clinicaVeterinaria.crearCliente(nombreCliente, telefonoCliente, correoCliente, cedulaCliente, direccionCliente);
	    	alerta(AlertType.CONFIRMATION,"Cliente Registrado","Registro de Cliente exitoso", "El cliente ha sido añadido de manera exitosa");
    	} catch (ClienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void regitrarMascota(ActionEvent event) {
    	
    	String nombreMascota = txtFieldNombreCliente.getText();
    	int edad = Integer.parseInt(txtFieldEdadMascota.getText());
    	String raza = txtFieldDireccionCliente.getText();
    	Sexo sexoSTR = ComboBoxSexoMascota.getValue();
    	Tipo tipoSTR = ComboBoxTipoMascota.getValue();
    	String cedulaDueño = txtFieldCedulaMascota.getText();
	
    	try {
			clinicaVeterinaria.aniadirMascotaCliente(nombreMascota, edad , raza, sexoSTR , tipoSTR, cedulaDueño);
	    	alerta(AlertType.CONFIRMATION,"Mascota Registrada","Registro de Mascota exitoso", "La mascota ha sido añadida de manera exitosa a la cédula"+cedulaDueño);
    	} catch (MascotaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void verHistorialMascota(ActionEvent event) {

    }

	public void setStage(Stage primaryStage) {
		// TODO Auto-generated method stub
		
	}
	
	public static void alerta(AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*private void inicializarDatos() {
		clinicaVeterinaria = new ClinicaVeterinaria("Patitas Peluda");
		Veterinario vet1 = new Veterinario("Luis", "32677297", "luisc.calderonc@uqvirtual.edu.co","vet1");
		Veterinario vet2 = new Veterinario("Pacho", "solo las bandidas", "andrese.perezm@uqvirtual.edu.co", "vet2");
		Veterinario vet3 = new Veterinario("ZZ", "3218861990", "andresf.zunigaz@uqvirtual.edu.co", "vet3");
		Veterinario vet4 = new Veterinario("Esperanza", "teamoEspe", "eespitia@uniquindio.edu.co", "vet4");
	
		public void initialize(URL arg0, ResourceBundle arg1) {
			this.columnaNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			this.columnaCodigoEmpleado.setCellValueFactory(new PropertyValueFactory<>("idEmpleado"));
			this.columnaIdentificacionEmpleado.setCellValueFactory(new PropertyValueFactory<>("identificacion"));

	}*/

}
