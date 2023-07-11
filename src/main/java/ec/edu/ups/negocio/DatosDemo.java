package ec.edu.ups.negocio;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw.datos.DetalleTicketDAO;
import ec.edu.ups.ppw.datos.PersonaDAO;
import ec.edu.ups.ppw.datos.TarifaDAO;
import ec.edu.ups.ppw.datos.TicketDAO;
import ec.edu.ups.ppw.datos.VehiculoDAO;
import ec.edu.ups.ppw.modelo.DetalleTicket;
import ec.edu.ups.ppw.modelo.Persona;
import ec.edu.ups.ppw.modelo.Ticket;
import ec.edu.ups.ppw.modelo.Vehiculo;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DatosDemo {
	
	@Inject
	private PersonaDAO daoPersona;
	
	@Inject
	private VehiculoDAO daoVehiculo;
	
	@Inject
	private TarifaDAO daoTarifa;
	
	@Inject
	private TicketDAO daoTicket;
	
	@Inject
	private DetalleTicketDAO daoDetalle;

	@PostConstruct
	public void init() {
		
		System.out.println("Hola UPS");
		
		Persona p = new Persona();
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		
		p.setCedula("0106585342");
		p.setNombre("Lisseth");
		p.setApellido("Padilla");
		p.setDireccion("Tixan");
		p.setTelefono(4101520);
		
		p1.setCedula("0101994342");
		p1.setNombre("Jack");
		p1.setApellido("Ochoa");
		p1.setDireccion("Calle Vieja");
		p1.setTelefono(4125520);
		
		p2.setCedula("0484848442");
		p2.setNombre("Sanely");
		p2.setApellido("Arias");
		p2.setDireccion("Vergel");
		p2.setTelefono(2802520);
		
		daoPersona.insert(p);
		daoPersona.insert(p1);
		daoPersona.insert(p2);
		
		List<Persona> personas = daoPersona.getAll();
	
		for (Persona persona : personas) {
		    System.out.println("ID: " + persona.getId_Persona());
		    System.out.println("Cédula: " + persona.getCedula());
		    System.out.println("Nombre: " + persona.getNombre());
		    System.out.println("Apellido: " + persona.getApellido());
		    System.out.println("Dirección: " + persona.getDireccion());
		    System.out.println("Teléfono: " + persona.getTelefono());
		    System.out.println("-------------------------------------");
		}
		
		
		Vehiculo veh = new Vehiculo();
		veh.setPlaca("ABC-9369");
		veh.setMatricula("ADADDA");
		veh.setTipo_vehiculo("auto");
		
		Vehiculo veh1 = new Vehiculo();
		veh1.setPlaca("PCZ-9876");
		veh1.setMatricula("LUJSKJKJ");
		veh1.setTipo_vehiculo("camion");
		
		Vehiculo veh2 = new Vehiculo();
		veh2.setPlaca("PND-7410");
		veh2.setMatricula("OLAAS");
		veh2.setTipo_vehiculo("camioneta");
		
		daoVehiculo.insert(veh);
		daoVehiculo.insert(veh1);
		daoVehiculo.insert(veh2);
		
		Ticket tic = new Ticket();
		tic.setId_ticket(1);
		tic.setHora_entrada("9:30");
		tic.setHora_salida("9:50");
		tic.setReporte(null);
		tic.setTarifa(null);
		tic.setVehiculo(veh2);
	
		DetalleTicket det1 = new DetalleTicket();
		det1.setId_detalleTicket(01);
		det1.setTotal(15.25);
		det1.setTotalTime(null);
		det1.setVehiculo(veh2);

		
		List<Vehiculo> vehiculos = daoVehiculo.getAll();
		for(Vehiculo vehi: vehiculos) {
			System.out.println(vehi);
		}
		

		List<Ticket> tickets = daoTicket.getAll();
		for(Ticket tick: tickets) {
			System.out.println(tick.getId_ticket()+ ": " + tick.getHora_entrada() + "- " + tick.getHora_salida() + 
					" total productos: " );
		}
		
	}
}
