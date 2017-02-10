
package cat.iesjoaquimmir.alumnat.model.persistence.daos.impl.jdbc;

import cat.iesjoaquimmir.alumnat.model.persistence.daos.contracts.AlumneDAO;
import cat.iesjoaquimmir.alumnat.model.persistence.exception.PersistenceException;
import cat.iesjoaquimmir.alumnat.model.persistence.utilities.JDBCUtils;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Alumne;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Modul;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumneMySQLDAO implements AlumneDAO {
     @Override
    public void saveAlumne(Alumne alumne) throws PersistenceException{
        try(Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Institut", "root", "maletin");
        CallableStatement insert = conn.prepareCall("CALL insertAlumne(?, ?, ?, ?)");){
        String nom = alumne.getNom();
        String c1 = alumne.getCognom1();
        String c2 = alumne.getCognom2();
        String dni = alumne.getDni();

        insert.setString(1,nom);
        insert.setString(2,c1);
        insert.setString(3,c2);
        insert.setString(4,dni);    
    
        insert.executeUpdate();
        } catch (SQLException e){
            throw new PersistenceException(e.getErrorCode());
        }
    }
    @Override
    public void saveModul(Modul modul) throws PersistenceException{
        try(Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Institut", "root", "maletin");
        CallableStatement insert = conn.prepareCall("CALL insertModul(?, ?, ?)");){
        String nom = modul.getNom();
        String desc = modul.getDescripcio();
        String durada = modul.getDurada();

        insert.setString(1,nom);
        insert.setString(2,desc);
        insert.setString(3,durada);  
    
        insert.executeUpdate();
        } catch (SQLException e){
            throw new PersistenceException(e.getErrorCode());
        }
    }
    @Override
    public List<Alumne> getAlumnes() throws PersistenceException{
        List<Alumne> alumnes = new ArrayList<>();
        try(Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Institut", "root", "maletin");
            CallableStatement sql = conn.prepareCall("CALL getAlumnes()");){
            ResultSet reader = sql.executeQuery();    
            while(reader.next()){
                alumnes.add(JDBCUtils.getAlumne(reader));
            }                
        } catch (SQLException e){
            throw new PersistenceException(e.getErrorCode());
        } 
        return alumnes; 
    }
    @Override
    public List<Modul> getModuls() throws PersistenceException{
        List<Modul> moduls = new ArrayList<>();
        try(Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Institut", "root", "maletin");
            CallableStatement sql = conn.prepareCall("CALL getModuls()");){
            ResultSet reader = sql.executeQuery();    
            while(reader.next()){
            moduls.add(JDBCUtils.getModul(reader));
            }                
        } catch (SQLException e){
            throw new PersistenceException(e.getErrorCode());
        } 
        return moduls; 
    }
}

