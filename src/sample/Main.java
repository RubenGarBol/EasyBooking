package sample;

/* TODO Imports de JAVAFX
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 */

import javax.jdo.*;
import java.util.List;

public class Main
{
    /*
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }*/
    static PersistenceManagerFactory pManagerFactory;
    static PersistenceManager pManager;
    static Transaction transaction;

    //Método para iniciar los elementos por primera vez
    public static void IniciarElementos()
    {
        try
        {
            pManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            pManager = pManagerFactory.getPersistenceManager();
            transaction = pManager.currentTransaction();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Método que devuelve una lista de vuelos que son de una aerolinea concreta
    public static List<Aerolinea> selectAerolinea(int codAerolinea){
        try
        {
            transaction.begin();

            Query q = pManager.newQuery("SELECT * FROM VUELO");
            List<Aerolinea> lVuelo = (List)q.execute();

            transaction.commit();
            return lVuelo;
        }catch (Exception e){
            System.out.println("* Error leyendo de BD: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args)
    {
        IniciarElementos();
        try
        {
            transaction.begin();

            Query q = pManager.newQuery("SELECT * FROM VUELO");
            List<Vuelo> lVuelo = (List)q.execute();
            lVuelo.toString();
            transaction.commit();
        }catch (Exception e){
            System.out.println("* Error leyendo de BD: " + e.getMessage());
        }
        System.out.println("hola");
    }
}
/*try {

            //Iniciar elementos


            try {
                transaction.begin();




                transaction.commit();
            } catch(Exception ex) {
                System.err.println("* Exception inserting data into db: " + ex.getMessage());
            } finally {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                pManager.close();
            }

            //Select data using a Query
            pManager = pManagerFactory.getPersistenceManager();
            transaction = pManager.currentTransaction();

            try {
                transaction.begin();

                @SuppressWarnings("unchecked")
                Query<Product> productsQuery = persistentManager.newQuery("SELECT FROM " + Product.class.getName() + " WHERE price < 150.00 ORDER BY price ASC");

                for (Product product : productsQuery.executeList()) {
                    System.out.println("- Selected product from db: " + product.name);
                    persistentManager.deletePersistent(product);
                    System.out.println("- Deleted product from db: " + product.name);
                }

                Extent<Inventory> inventoryExtent = persistentManager.getExtent(Inventory.class);

                for (Inventory inventory : inventoryExtent) {
                    persistentManager.deletePersistent(inventory);
                    System.out.println("- Deleted inventory from db: " + inventory.name);
                }

                transaction.commit();
            } catch(Exception ex) {
                System.err.println("* Exception executing a query: " + ex.getMessage());
            } finally {
                if (transaction.isActive()) {
                    transaction.rollback();
                }

                persistentManager.close();
            }
        } catch (Exception ex) {
            System.err.println("* Exception: " + ex.getMessage());
        }
    }

 */
