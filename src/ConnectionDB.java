import java.sql.Connection;
import java.sql.DriverManager;

/** Klasa realizująca połączenie z bazą danych postgres */
public class ConnectionDB{
    /** statyczna metoda realizująca połączenie z bazą danych postgres */
    public static Connection getConnect(){
        Connection c=null;
        try{
            String dbaseURL = "jdbc:postgresql://localhost:5433/u7baczynski";
            String username  = "u7baczynski";
            String password  = "7baczynski"; 
            c = DriverManager.getConnection (dbaseURL, username, password);
            c.setSchema("samoloty");

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return c;
    }
}

