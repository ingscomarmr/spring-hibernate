package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.comr.capadatos.IPersonaDao;
import mx.com.comr.capadatos.domain.Persona;
import mx.com.comr.servicios.IPersonaService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:datasource-test.xml", "classpath:applicationContext.xml"})
public class TestPersonaDaoImpl {
	
	private static Log logger = LogFactory.getLog("TestPersonasDaoImpl"); 
	
	@Autowired 
	private IPersonaDao personaDao;
	
	@Autowired 
	private IPersonaService personaService;
	
	@Ignore
	@Test
	@Transactional
	public void mostrarPersonas(){
		try{
			//org.hibernate.engine.transaction.spi.TransactionContext
			
			System.out.println();
			logger.info("Inicia mostrarPersonas");
			List<Persona> personaList = personaDao.findAll();
			
			for(Persona p : personaList){
				logger.info(p);
			}
			
			assertEquals(personaList.size(), personaDao.contador());
			logger.info("Fin mostrarPersonas");
		}catch(Exception e){
			logger.info(e.getMessage());
		}
	}
	
	@Ignore
	@Test	
	public void mostrarInsertarPersona(){
		try{
			//org.hibernate.engine.transaction.spi.TransactionContext
			
			System.out.println();
			logger.info("Inicia mostrarInsertarPersona");
			Persona p = new Persona();
			p.setNombre("Adolfo");
			p.setApePaterno("Alva");
			p.setApeMaterno("Hernandez");
			p.setEmail(p.getNombre() + "." + p.getApePaterno() + "@mail.com");			
			logger.info("insertar persona:"+ p.toString());
			personaDao.insert(p);
			
			logger.info("Persona insertada");
			
			p = personaDao.getByEmail(p);			
			logger.info("Persona insertada:" + p.toString());

			logger.info("Fin mostrarInsertarPersona");
		}catch(Exception e){
			logger.info(e.getMessage());
		}
	}
	
	@Test	
	public void eliminarPersona(){
		try{
			//org.hibernate.engine.transaction.spi.TransactionContext
			
			System.out.println();
			logger.info("Inicia eliminarPersona");
			Persona p = personaService.recuperarPersona(new Persona(1300));
			logger.info("Eliminar persona:" + p);
			personaService.eliminarPersona(p);		

			logger.info("Fin eliminarPersona");
		}catch(Exception e){
			logger.info(e.getMessage());
		}
	}
}

