package ar.com.crud.entity;

import java.time.LocalDate;

public class OradorMain {

	public static void main(String[] args) {
		// crear un objeto a partir de la clase Orador
		Orador nuevoOrador = new Orador("carlos", "lopez", "email@email.com", "java", LocalDate.now());
		
		//mostrar por consola el nuevo orador
		System.out.println(nuevoOrador);
		
		//simulando que viene desde la DB
		Orador oradorFromDB = new Orador(1L, "carlos", "lopez", "email@email.com", "java", LocalDate.now());
		
		nuevoOrador.setNombre("pepe");;
		
	}

}
