package sample;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

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
			System.out.println(" $ Error haciendo el SELECT: " + e.getMessage());
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
		//TODO Asinar atributos
		Aerolinea a2 = new Aerolinea();
		Aerolinea a3 = new Aerolinea();
		Aerolinea a4 = new Aerolinea();

		//TODO Crear Vuelos

		//Inicio del programa
		System.out.println("Easybooking JDO test:");
		System.out.println("=========================");
	//=============================================================================
		//INSERT datos en la BD
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
			pm.makePersistent(a4);

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