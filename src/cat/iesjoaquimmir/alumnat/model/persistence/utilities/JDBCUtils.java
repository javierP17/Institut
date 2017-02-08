
package cat.iesjoaquimmir.alumnat.model.persistence.utilities;

import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Alumne;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Modul;
import java.sql.ResultSet;
import java.sql.*;

public class JDBCUtils {
     private JDBCUtils(){
   } 
   public static Alumne getAlumne(ResultSet reader) throws SQLException{
       Alumne alumne = new Alumne(
       reader.getString("nom"),
       reader.getString("cognom1"),
       reader.getString("cognom2"),
       reader.getString("dni"));
       alumne.setId(reader.getInt("id"));
       return alumne;
   }
   public static Modul getModul(ResultSet reader) throws SQLException{
       Modul modul = new Modul(
       reader.getString("nom"),
       reader.getString("descripcio"),
       reader.getString("hores"));
       modul.setId(reader.getInt("id"));
       return modul;
   }
}
