package mx.com.comr.servicios;

import java.util.List;

import mx.com.comr.capadatos.domain.Persona;

public interface IPersonaService {

	public List<Persona> listarPersonas();

	public Persona recuperarPersona(Persona persona);	

	public void agregarPersona(Persona persona);

	public void modificarPersona(Persona persona);

	public void eliminarPersona(Persona persona);
	
	public Persona recuperarPersonaEmail(Persona persona);
}
