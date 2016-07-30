package mx.com.comr.capadatos;

import java.util.List;

import mx.com.comr.capadatos.domain.Persona;

public interface IPersonaDao {
	void insert(Persona oInert);

	void update(Persona oUpdate);

	void delete(Persona oDelete);

	Persona findById(long idPersona);

	List<Persona> findAll();

	long contador();

	Persona getByEmail(Persona persona);
}
