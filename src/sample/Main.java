package sample;

import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class Main {
	
	public static void main(String args[]) {	
		
		// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		// Persistence Manager
		PersistenceManager pm = null;
		//Transaction to group DB operations
		Transaction tx = null;
		
		//TODO DATOS A CHOLON 
		//Aerolinea
		Aerolinea a1 = new Aerolinea(1, "Bilbao");
		Aerolinea a2 = new Aerolinea(2, "Madrid");
		Aerolinea a3 = new Aerolinea(3, "Barcelona");
		Aerolinea a4 = new Aerolinea(4, "Granada");
		
		
		System.out.println("Datanucleus + JDO Easybooking");
		System.out.println("=========================");
	
		//Select de prueba
		
		
		
		//Select de la BD
		try {
			System.out.println("- Leyendo todos los vuelos de la BD");			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			pm.makePersistent(a1);
			pm.makePersistent(a2);
			pm.makePersistent(a3);
			pm.makePersistent(a4);
			
			//End the transaction
			tx.commit();
			
			tx = pm.currentTransaction();		
			//Start the transaction
			tx.begin();			
			Extent<Aerolinea> extent = pm.getExtent(Aerolinea.class, true);			
			for (Aerolinea aero : extent) {
				System.out.println("  -> " + aero.getNombre());
			}			
			tx.commit();
			
			
			
		} catch (Exception ex) {
			System.err.println(" $ Error retrieving accounts using a 'Query': " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		System.out.println("====================================");	
		System.out.println("End of the Datanucleus + JDO example");
		
	}	
}