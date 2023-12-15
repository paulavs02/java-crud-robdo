package ar.com.crud.repository;

import java.time.LocalDate;
import java.util.List;

import ar.com.crud.entity.Orador;

public class MainOradorRepository {

	public static void main(String[] args) {

		//interface i  = new ClaseQueImplementa()..
		
		OradorRepository repository = new MySQLOradorRepository();
		
		//Orador nuevo = new Orador("marcelo", "lopez", "emailc@email.com", "c#", LocalDate.now());
		//repository.save(nuevo);
		
		//List<Orador> oradores = repository.findAll();
		
		Orador orador = repository.getById(1L);
		
		System.out.println(orador);

	}

}
