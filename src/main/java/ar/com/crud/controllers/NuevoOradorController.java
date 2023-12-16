package ar.com.crud.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ar.com.crud.entity.Orador;
import ar.com.crud.repository.MySQLOradorRepository;
import ar.com.crud.repository.OradorRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/orador")
public class NuevoOradorController extends AppBaseController{
	
	private OradorRepository repository = new MySQLOradorRepository();		
	
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)  
					throws ServletException, IOException {

		String json = super.toJson(request);
		
		OradorRequest oradorRequest = super.mapper.readValue(json, OradorRequest.class);
		
		Orador orador = new Orador(oradorRequest.getNombre(), 
				oradorRequest.getApellido(), 
				oradorRequest.getMail(), 
				oradorRequest.getTema(), 
				LocalDate.now());
		
		repository.save(orador);
		
		response.setStatus(HttpServletResponse.SC_CREATED);//201
		
		response.getWriter().print(mapper.writeValueAsString(orador));
	}

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		List<Orador> oradores = this.repository.findAll();
		
		//convierto de json String a Objecto java usando libreria de jackson2
		
		String jsonParaEnviarAlFrontend = super.mapper.writeValueAsString(oradores);
		
		response.setStatus(HttpServletResponse.SC_OK);

		//escribe la respueta en el objeto response (que despues es lo que recibe el front)
		response.getWriter().print(jsonParaEnviarAlFrontend );
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		this.repository.delete(Long.parseLong(id));
		
		resp.setStatus(HttpServletResponse.SC_OK);
	}
	
	protected void doPut(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		//capturar el id que viene en la url ?id=1
		String id = request.getParameter("id");//f8
		
		//captura los datos nuevos del orador
		//obtengo el json desde el frontend
		String json = super.toJson(request);
		
		//convierto de json String a Objecto java usando libreria de jackson2
		OradorRequest oradorRequest = super.mapper.readValue(json, OradorRequest.class);
		
		//busco el orador en la db
		Orador orador = repository.getById(Long.parseLong(id));
		
		//actualizo los datos del orado con los nuevo que viene en el OradorRequest 	
		orador.setNombre(oradorRequest.getNombre());
		orador.setApellido(oradorRequest.getApellido()); 
		orador.setMail(oradorRequest.getMail()); 
		orador.setTema(oradorRequest.getTema()); 

		//ahora si actualizo en la db
		repository.update(orador);
		
		response.setStatus(HttpServletResponse.SC_OK);
	}
}