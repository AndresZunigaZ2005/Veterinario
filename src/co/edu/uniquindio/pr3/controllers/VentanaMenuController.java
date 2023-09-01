package co.edu.uniquindio.pr3.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.UUID;

import co.edu.uniquindio.pr3.exceptions.ClienteException;
import co.edu.uniquindio.pr3.exceptions.MascotaException;
import co.edu.uniquindio.pr3.exceptions.RegistroVeterinarioException;
import co.edu.uniquindio.pr3.model.Cliente;
import co.edu.uniquindio.pr3.model.ClinicaVeterinaria;
import co.edu.uniquindio.pr3.model.Estado;
import co.edu.uniquindio.pr3.model.Mascota;
import co.edu.uniquindio.pr3.model.RegistroVeterinario;
import co.edu.uniquindio.pr3.model.Sexo;
import co.edu.uniquindio.pr3.model.Tipo;
import co.edu.uniquindio.pr3.model.Veterinario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

public class VentanaMenuController implements Initializable{
	
	private ClinicaVeterinaria clinicaVeterinaria; 
	
	private ObservableList <Cliente> listaClientes = FXCollections.observableArrayList();
	
	private ObservableList <RegistroVeterinario> listaRegistros = FXCollections.observableArrayList();

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
    private TableColumn<RegistroVeterinario, Estado> columnEstadoCita;

    @FXML
    private TableColumn<?, ?> columnEstadoFiltro;

    @FXML
    private TableColumn<RegistroVeterinario, Void> columnFactura;

    @FXML
    private TableColumn<RegistroVeterinario, String> columnFechaCita;

    @FXML
    private TableColumn<?, ?> columnFechaFiltro;

    @FXML
    private TableColumn<?, ?> columnFechaHistorialMascota;

    @FXML
    private TableColumn<RegistroVeterinario, UUID> columnIDCita;

    @FXML
    private TableColumn<?, ?> columnIDCitaFiltro;

    @FXML
    private TableColumn<RegistroVeterinario, Mascota> columnMascotaCita;

    @FXML
    private TableColumn<?, ?> columnMascotaFiltro;

    @FXML
    private TableColumn<RegistroVeterinario, Veterinario> columnVeterinarioCita;

    @FXML
    private TableColumn<?, ?> columnVeterinarioFiltro;

    @FXML
    private TableColumn<Cliente, String> columnaCedula;

    @FXML
    private TableColumn<Cliente, String> columnaCorreo;

    @FXML
    private TableColumn<Cliente, String> columnaDireccion;

    @FXML
    private TableColumn<Cliente, String> columnaNombre;

    @FXML
    private TableColumn<Cliente, String> columnaTelefono;

    @FXML
    private ComboBox<?> comboBoxSelMascotaHistorial;

    @FXML
    private ComboBox<Mascota> comboBoxSelMascotaICita;

    @FXML
    private ComboBox<Veterinario> comboBoxSelVet;

    @FXML
    private TableView<RegistroVeterinario> tableViewCitas;

    @FXML
    private TableView<?> tableViewFiltroFecha;

    @FXML
    private TableView<?> tableViewHistorialMascota;

    @FXML
    private TableView<Cliente> tableViewVerClientes;

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
        //////////////////////
        String diagnostico =txtAreaDiagnosticoCita.getText();
        String tratamiento = txtAreaTratamientoCita.getText();
        Veterinario veterinario = comboBoxSelVet.getValue();
        Mascota mascota = comboBoxSelMascotaICita.getValue();
        if(diagnostico=="" || tratamiento=="" || selectedDate.equals(null) || veterinario.equals(null)
        		|| mascota.equals(null)) {
        	alerta(AlertType.ERROR, "Error","No se agendó la cita", "Rellene todos los campos");
        }else {
        	try {
				clinicaVeterinaria.aniadirRegistroVeterinario(selectedDateTime, diagnostico, tratamiento, Estado.CREADA, veterinario, null, mascota);
				RegistroVeterinario registroVeterinario = new RegistroVeterinario(selectedDateTime, diagnostico, tratamiento, Estado.CREADA, veterinario, mascota);
				listaRegistros.add(registroVeterinario);
				tableViewCitas.setItems(listaRegistros);
				DatePickerFechaCita.setValue(null);
				SpinnerHoraCita.getValueFactory().setValue(0);
				SpinnerMinutosCita.getValueFactory().setValue(0);
				txtAreaDiagnosticoCita.clear();
				txtAreaTratamientoCita.clear();
				//tableViewCitas.setItems(listaRegistros);
        	} catch (RegistroVeterinarioException e) {
				e.printStackTrace();
			}
        }
    }

    @FXML
    void filtrarFechaCitas(ActionEvent event) {
    	
    }

    @FXML
    void registrarCliente(ActionEvent event) {
    	
    	String title="Error al registrar el cliente";
    	String header="No se ha registrado el cliente";
    	String content="Rellene todos los campos";
    	if(!verificarTextField(txtFieldNombreCliente) || !verificarTextField(txtFieldTelefonoCliente) 
    			|| !verificarTextField(txtFieldDireccionCliente) || !verificarTextField(txtFieldCorreoCliente) || !verificarTextField(txtFieldCedulaCliente)) {
    		alerta(AlertType.ERROR, title, header, content);
    	}else {
    		String nombreCliente = devolverStringTextField(txtFieldNombreCliente);
    		String telefonoCliente = devolverStringTextField(txtFieldTelefonoCliente);
    		String direccionCliente = devolverStringTextField(txtFieldDireccionCliente);
    		String correoCliente = devolverStringTextField(txtFieldCorreoCliente);
    		String cedulaCliente = devolverStringTextField(txtFieldCedulaCliente);   	    	
    		try {
    			clinicaVeterinaria.crearCliente(nombreCliente, telefonoCliente, correoCliente, cedulaCliente, direccionCliente);
    			//System.out.println(clinicaVeterinaria.obtenerCliente(cedulaCliente).toString());
    			Cliente cliente = new Cliente(nombreCliente, telefonoCliente, correoCliente, cedulaCliente, direccionCliente);
    			listaClientes.add(cliente);
    			tableViewVerClientes.setItems(listaClientes);
    			txtFieldNombreCliente.clear();
    			txtFieldTelefonoCliente.clear();
    			txtFieldDireccionCliente.clear();
    			txtFieldCorreoCliente.clear();
    			txtFieldCedulaCliente.clear();
    			alerta(AlertType.INFORMATION,"Cliente Registrado","Registro de Cliente exitoso", "El cliente ha sido añadido de manera exitosa");
    		} catch (ClienteException e) {
    			alerta(AlertType.ERROR,"Error en el registro","No se ha registrado el cliente", "El cliente ya existe");
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void regitrarMascota(ActionEvent event) {
    	
    	if(!verificarTextField(txtFieldNombreMascota) || !verificarTextField(txtFieldEdadMascota)
    			|| !verificarTextField(txtFieldRazaMascota) || !verificarTextField(txtFieldCedulaMascota)) {
    		alerta(AlertType.ERROR, "Error","Error al registrar la mascota","Rellene todos los campos");
    	}else if (!txtFieldEdadMascota.getText().matches("\\d*")) {
            alerta(AlertType.ERROR,"Error", "Error al registrar la mascota","Solo se pueden ingresar caracteres numéricos en la edad.");
        }else {
    		try {
    	    	String nombreMascota = txtFieldNombreMascota.getText();
    	    	int edad = Integer.parseInt(txtFieldEdadMascota.getText());
    	    	String raza = txtFieldRazaMascota.getText();
    	    	Sexo sexoSTR = ComboBoxSexoMascota.getValue();
    	    	Tipo tipoSTR = ComboBoxTipoMascota.getValue();
    	    	Cliente cedulaDueño = clinicaVeterinaria.obtenerCliente(txtFieldCedulaMascota.getText());
    	    	System.out.println(cedulaDueño.toString());
    			clinicaVeterinaria.aniadirMascotaCliente(nombreMascota, edad , raza, sexoSTR , tipoSTR, cedulaDueño);
    			txtFieldNombreMascota.clear();
    			txtFieldEdadMascota.clear();
    			txtFieldRazaMascota.clear();
    			txtFieldCedulaMascota.clear();
    			alerta(AlertType.INFORMATION,"Mascota Registrada","Registro de Mascota exitoso", "La mascota ha sido añadida de manera exitosa a la cédula "+cedulaDueño);
    		} catch (MascotaException | ClienteException e) {
    			alerta(AlertType.ERROR, "Error", "La mascota no se ha añadido", "La cédula del dueño no existe");
    			e.printStackTrace();
    		}
    	}	
    }
    @FXML
    void llenarComboMascotasDueño(ActionEvent event) {
    	Cliente cliente;
		try {
			cliente = clinicaVeterinaria.obtenerCliente(txtFieldCedulaBuscarMascotasCita.getText());
	    	if(cliente==null) {
	    		alerta(AlertType.WARNING,"Atención","Error al buscar mascotas","El cliente no existe");
	    	}else {
	    		comboBoxSelMascotaICita.getItems().addAll(cliente.getListaMascotas().toArray(new Mascota[cliente.getListaMascotas().size()]));
	    	}
		} catch (ClienteException e) {
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
	
	
	public static boolean verificarTextField(TextField textField) {
		if(textField.getText().equals("")) {
			return false;
		}
		return true;
	}
	
	public static String devolverStringTextField(TextField textField){
		if(verificarTextField(textField)) {
			return textField.getText();
		}
		return "";
	}
	
    private class BotonTableCell extends TableCell<RegistroVeterinario, Void> {
        private final Button boton = new Button("Mi Botón");

        public BotonTableCell() {
            boton.setOnAction(this::onBotonClick);
        }

        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setGraphic(null);
            } else {
                setGraphic(boton);
            }
        }

        private void onBotonClick(ActionEvent event) {
            RegistroVeterinario registroVeterinario = getTableRow().getItem();
            if (registroVeterinario != null) {
                // Lógica que deseas realizar al hacer clic en el botón
                System.out.println("Clic en el botón para: " + registroVeterinario.getIdCita());
            }
        }
    }
	
	
	
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		//this.columnaNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		inicializar();

	}
	
	public void inicializar() {
		
		SpinnerHoraCita.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0));
		SpinnerMinutosCita.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0)); 
		
		
		ComboBoxTipoMascota.getItems().addAll(Tipo.values());
		ComboBoxTipoMascota.getSelectionModel().selectFirst();
		ComboBoxSexoMascota.getItems().addAll(Sexo.values());
		ComboBoxSexoMascota.getSelectionModel().selectFirst();
		
		clinicaVeterinaria = new ClinicaVeterinaria("Patitas Peludas");
		System.out.println("Hola");
		Veterinario vet1 = new Veterinario("Luis", "32677297", "luisc.calderonc@uqvirtual.edu.co","vet1");
		Veterinario vet2 = new Veterinario("Pacho", "solo las bandidas", "andrese.perezm@uqvirtual.edu.co", "vet2");
		Veterinario vet3 = new Veterinario("ZZ", "3218861990", "andresf.zunigaz@uqvirtual.edu.co", "vet3");
		Veterinario vet4 = new Veterinario("Esperanza", "teamoEspe", "eespitia@uniquindio.edu.co", "vet4");
		Veterinario listVet[] = new Veterinario[4];
		listVet[0] = vet1;
		listVet[1] = vet2;
		listVet[2] = vet3;
		listVet[3] = vet4;
		
		columnaCedula.setCellValueFactory(new PropertyValueFactory<>("Cedula"));
		columnaNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
		columnaTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
		columnaCorreo.setCellValueFactory(new PropertyValueFactory<>("Correo"));
		columnaDireccion.setCellValueFactory(new PropertyValueFactory<>("Direccion"));
		
		columnEstadoCita.setCellValueFactory(new PropertyValueFactory<>("Estado"));
		columnIDCita.setCellValueFactory(new PropertyValueFactory<>("ID Cita"));
		columnVeterinarioCita.setCellValueFactory(new PropertyValueFactory<>("Veterinario"));
		columnMascotaCita.setCellValueFactory(new PropertyValueFactory<>("Mascota"));
		columnFechaCita.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
		columnFactura.setCellValueFactory(new PropertyValueFactory<>("Factura"));
		
        columnFactura.setCellFactory(new Callback<TableColumn<RegistroVeterinario, Void>, TableCell<RegistroVeterinario, Void>>() {
            @Override
            public TableCell<RegistroVeterinario, Void> call(TableColumn<RegistroVeterinario, Void> param) {
                return new BotonTableCell();
            }
        });
		
	    comboBoxSelVet.getItems().addAll(listVet);
	    comboBoxSelVet.setCellFactory((Callback<ListView<Veterinario>, ListCell<Veterinario>>) new Callback<ListView<Veterinario>, ListCell<Veterinario>>() {
            @Override
            public ListCell<Veterinario> call(ListView<Veterinario> param) {
                return new ListCell<Veterinario>() {
                    @Override
                    protected void updateItem(Veterinario veterinario, boolean empty) {
                        super.updateItem(veterinario, empty);
                        if (veterinario != null) {
                            setText(veterinario.getNombre());
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });;
	}
}
