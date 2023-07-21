package ec.edu.ups.negocio;

import java.util.List;

import ec.edu.ups.ppw.datos.PersonaDAO;
import ec.edu.ups.ppw.modelo.Persona;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;



@Stateless
public class GestionClientes {
	
	@Inject
	private PersonaDAO daoPersona;

	public void guardarClientes(Persona persona) throws Exception {
		
		if(!this.isCedulaValida(persona.getCedula()))
			throw new Exception("Cedula incorrecta");
		
		if(daoPersona.read(persona.getId_Persona())==null) {
			try {
				
				daoPersona.insert(persona);
				
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());	
			}
		}else {
			
			try {
				
				daoPersona.update(persona);
				
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());	
			}
		}
	}
	
	public void guardarPersonas(Persona persona) throws Exception {
		
		if(!this.isCedulaValida(persona.getCedula()))
			throw new Exception("Cedula incorrecta");
		
		if(daoPersona.read(persona.getId_Persona())==null) {
			try {
				
				daoPersona.insert(persona);
				
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());	
			}
		}else {
			
			try {
				
				daoPersona.update(persona);
				
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());	
			}
		}
	}
	
	private boolean isCedulaValida(String cedula) {
		
		return cedula.length()==10;
	}
	
    public void guardarClientes(String cedula, String nombre, String direccion) {
		
	}
    
   public List<Persona> getClientes(){
	   return daoPersona.getAll();
   }
   
   public void actualizarPersona(Persona persona) throws Exception {
	    if (!isCedulaValida(persona.getCedula()))
	        throw new Exception("Cedula incorrecta");

	    try {
	        if (daoPersona.read(persona.getId_Persona()) == null) {
	            throw new Exception("La persona no existe en la base de datos.");
	        } else {
	            daoPersona.update(persona);
	        }
	    } catch (Exception e) {
	        throw new Exception("Error al actualizar: " + e.getMessage());
	    }
	}

   public void eliminarPersona(String cedula) {
	   daoPersona.delete(cedula);
   }
	
}