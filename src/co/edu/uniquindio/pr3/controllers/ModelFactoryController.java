package co.edu.uniquindio.pr3.controllers;

import co.edu.uniquindio.pr3.model.ClinicaVeterinaria;
import co.edu.uniquindio.pr3.model.Veterinario;

public class ModelFactoryController {
	ClinicaVeterinaria clinicaVeterinaria = null;



	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquí al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// Método para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		System.out.println("invocación clase singleton");
		inicializarDatos();
	}


	private void inicializarDatos() {
		clinicaVeterinaria = new ClinicaVeterinaria("Patitas Peluda");
		Veterinario vet1 = new Veterinario("Luis", "32677297", "luisc.calderonc@uqvirtual.edu.co","vet1");
		Veterinario vet2 = new Veterinario("Pacho", "solo las bandidas", "andrese.perezm@uqvirtual.edu.co", "vet2");
	}
}
