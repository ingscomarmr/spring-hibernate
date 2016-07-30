package main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import mx.com.comr.capadatos.IPersonaDao;
import mx.com.comr.capadatos.domain.Persona;
import mx.com.comr.servicios.IPersonaService;



@ContextConfiguration(locations = {"classpath:datasource-test.xml", "classpath:applicationContext.xml"})
public class App {

	private static Log log = LogFactory.getLog("App"); 
	@Autowired
	private IPersonaService personaService;		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App();
		app.insertarPersona();
	}
	
	public void insertarPersona() {
		try {			

			System.out.println();
			log.info("Inicia mostrarInsertarPersona");
			Persona p = new Persona();
			p.setNombre("Adolfo");
			p.setApePaterno("Alva");
			p.setApeMaterno("Hernandez");
			p.setEmail(p.getNombre() + "." + p.getApePaterno() + "@mail.com");
			log.info("insertar persona:" + p.toString());
			personaService.agregarPersona(p);

			log.info("Persona insertada");

			
			log.info("Persona insertada:" + p.toString());

			log.info("Fin mostrarInsertarPersona");
		} catch (Exception e) {
			log.info(e.getMessage());
			System.err.println(e.getMessage());
		}
	}

}
