package co.edu.uniquindio.pr3.model;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.pr3.exceptions.ClienteException;

public class Prueba {

	public static void main(String[] args) {
		ClinicaVeterinaria clinicaVeterinaria = new ClinicaVeterinaria("Patitas peludas");
		/*Cliente cliente = new Cliente("a", "a", "a", "a", "1094889063");

        try {
			clinicaVeterinaria.crearCliente("Juan Pérez", "", "correo", "12345", "direccion");
		} catch (ClienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			clinicaVeterinaria.crearCliente("María Rodríguez", "", "correo", "67890", "direccion");
		} catch (ClienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(clinicaVeterinaria.getListaClientes().toString());
        
        String cedulaBuscada = "12345";
        Cliente clienteEncontrado = clinicaVeterinaria.obtenerCliente(cedulaBuscada);
        
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.getNombre());
        } else {
            System.out.println("Cliente no encontrado.");
        }
		try {
			clinicaVeterinaria.crearCliente("a", "a", "a", "1094889063","A");
		} catch (ClienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(clinicaVeterinaria.obtenerCliente("1094889063"));
		System.out.println(clinicaVeterinaria.getListaClientes().toString());*/
		
		try {
			clinicaVeterinaria.crearCliente("Andrés", "3218861990", "andresf.zunigaz@uqvirtual.edu.co", "1094889063", "Calle 47 #25-50");
		} catch (ClienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(clinicaVeterinaria.obtenerCliente("1094889063"));
		} catch (ClienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
