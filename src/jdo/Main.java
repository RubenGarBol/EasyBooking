package jdo;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import java.util.Date;

public class Main {
	// Coger el ManagerFactory en base a lo definido en el "datanucleus.properties"
	static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	// Crear un PersistenceManager
	static PersistenceManager pm = null;
	// Crear una transacción con la que operar
	static Transaction tx = null;

	public static void SelectAerolineas(){
		try{
			// Sacar el PersistenceManager del ManagerFactory
			pm = pmf.getPersistenceManager();
			// Sacar una transaccion desde el PersistenceManager
			tx = pm.currentTransaction();
			// Empezar la transaccion
			tx.begin();
			Extent<Aerolinea> extent = pm.getExtent(Aerolinea.class, true);
			for (Aerolinea aero : extent) {
				System.out.println("  -> " + aero.getCodigo() + " . " + aero.getNombre());
			}
			tx.commit();// Acabar transaccion
		}catch(Exception e){
			System.out.println(" $ Error haciendo el SELECT Aerolineas: " + e.getMessage());
		}finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}

	public static void SelectVuelos(){
		try{
			// Sacar el PersistenceManager del ManagerFactory
			pm = pmf.getPersistenceManager();
			// Sacar una transaccion desde el PersistenceManager
			tx = pm.currentTransaction();
			// Empezar la transaccion
			tx.begin();
			Extent<Vuelo> extent = pm.getExtent(Vuelo.class, true);
			for (Vuelo vue : extent) {
				System.out.println("\n\t-> Código: " + vue.getCodigo() + "\n\tAeropuerto Destino: " + vue.getaDest().getNombre());
			}
			tx.commit();// Acabar transaccion
		}catch(Exception e){
			System.out.println(" $ Error haciendo el SELECT Vuelo: " + e.getMessage());
		}finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}

	public static void main(String args[]) {

		//CREAR DATOS PARA INSERTAR
		//Aerolinea
		Aerolinea a1 = new Aerolinea();
			a1.setCodigo(1);
			a1.setNombre("Iberia");
		Aerolinea a2 = new Aerolinea();
			a2.setCodigo(2);
			a2.setNombre("Turkish Airlines");
		Aerolinea a3 = new Aerolinea();
			a3.setCodigo(3);
			a3.setNombre("Vueling");

		//Aeropuertos
		Aeropuerto ae1 = new Aeropuerto();
			ae1.setCodigo(1);
			ae1.setNombre("La Gaviota");
			ae1.setCiudad("Bilbao");
			ae1.setPais("España");
		Aeropuerto ae2 = new Aeropuerto();
			ae2.setCodigo(2);
			ae2.setNombre("Barajas");
			ae2.setCiudad("Madrid");
			ae2.setPais("España");

		//Vuelos
		Vuelo v1 = new Vuelo();
			v1.setCodigo(1);
			v1.setaDest(ae1);
			v1.setaOrig(ae2);
			v1.setAerolinea(a1);
			v1.setFechaHoraLlegada(new Date(2019,11,12));
			v1.setFechaHoraSalida(new Date(2019,11,12));


		//Inicio del programa
		System.out.println("Easybooking JDO test:");
		System.out.println("=========================");
	//=============================================================================
		//INSERT Aerolineas en la BD
		try{
			System.out.println("- INSERT Aerolineas en la BD");
			// Sacar el PersistenceManager del ManagerFactory
			pm = pmf.getPersistenceManager();
			// Sacar una transaccion desde el PersistenceManager
			tx = pm.currentTransaction();
			// Iniciar transaccion
			tx.begin();
			// Hacer persistentes las aerolineas en la BD
			pm.makePersistent(a1);
			pm.makePersistent(a2);
			pm.makePersistent(a3);

			tx.commit();// Acabar transaccion
			System.out.println(" ->INSERT CORRECTO");
		}catch(Exception e){
			System.out.println(" $ Error haciendo el INSERT: " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}

		//Insertar Aeropuertos
		try{
			System.out.println("- INSERT Aeropuerto en la BD");
			// Sacar el PersistenceManager del ManagerFactory
			pm = pmf.getPersistenceManager();
			// Sacar una transaccion desde el PersistenceManager
			tx = pm.currentTransaction();
			// Iniciar transaccion
			tx.begin();
			// Hacer persistentes los aeropuertos en la BD
			pm.makePersistent(ae1);
			pm.makePersistent(ae2);

			tx.commit();// Acabar transaccion
			System.out.println(" ->INSERT CORRECTO");
		}catch(Exception e){
			System.out.println(" $ Error haciendo el INSERT: " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		//Insertar Vuelos
		try{
			System.out.println("- INSERT Vuelo en la BD");
			// Sacar el PersistenceManager del ManagerFactory
			pm = pmf.getPersistenceManager();
			// Sacar una transaccion desde el PersistenceManager
			tx = pm.currentTransaction();
			// Iniciar transaccion
			tx.begin();
			// Hacer persistentes los vuelos en la BD
			pm.makePersistent(v1);

			tx.commit();// Acabar transaccion
			System.out.println(" ->INSERT CORRECTO");
		}catch(Exception e){
			System.out.println(" $ Error haciendo el INSERT: " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}



		//=============================================================================
		//SELECT de la BD
		System.out.println("- SELECT Aerolineas de la BD");
		SelectAerolineas(); //Se ha sacado a un método externo porque se utiliza más de una vez
		SelectVuelos();
	//=============================================================================
		//UPDATE de una aerolinea en BD
		try{
			System.out.println("- UPDATE Aerolineas en la BD");
			// Sacar el PersistenceManager del ManagerFactory
			pm = pmf.getPersistenceManager();
			// Sacar una transaccion desde el PersistenceManager
			tx = pm.currentTransaction();
			// Iniciar transaccion
			tx.begin();
			a1.setNombre("San Francisco ( Nombre Nuevo )");
			pm.makePersistent(a1);
			tx.commit();// Acabar transaccion
			System.out.println(" -> UPDATE CORRECTO");
		}catch(Exception e){
			System.out.println(" $ Error haciendo el UPDATE: " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		System.out.println("- BD actualizada:");
		SelectAerolineas(); // Se comprueba que los cambios están hechos
	//=============================================================================
		// DELETE de la BD
		try{
			System.out.println("- DELETE de la Aerolinea 2:");
			// Sacar el PersistenceManager del ManagerFactory
			pm = pmf.getPersistenceManager();
			// Sacar una transaccion desde el PersistenceManager
			tx = pm.currentTransaction();
			// Iniciar transaccion
			tx.begin();
			pm.deletePersistent(a2);
			tx.commit();// Acabar transaccion
		}catch(Exception e){
			System.out.println(" $ Error haciendo el DELETE: " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		System.out.println("- BD actualizada:");
		SelectAerolineas(); // Se comprueba que los cambios están hechos
	// =============================================================================

		System.out.println("====================================");	
		System.out.println("Final del codigo JDO del proyecto EasyBooking ( Nombre Generico 2 )");
	}	
}