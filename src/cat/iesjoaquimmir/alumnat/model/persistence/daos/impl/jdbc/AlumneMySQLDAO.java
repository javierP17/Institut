
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
    private Connection conn;
    
    @Override
    public void saveAlumne(Alumne alumne) throws PersistenceException{
        prepareConnection();
        try{
        CallableStatement insert = conn.prepareCall("CALL insertAlumne(?, ?, ?, ?)");
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
        prepareConnection();
        try{
        CallableStatement insert = conn.prepareCall("CALL insertModul(?, ?, ?)");
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
    public void saveCursa(int idAlumne, int idModul) throws PersistenceException {
	prepareConnection();
	CallableStatement insert;
	try {
		insert = conn.prepareCall("CALL insertCursa(?, ?)");
		int idA = idAlumne;
		int idM = idModul;

		insert.setInt(1, idA);
		insert.setInt(2, idM);

		insert.executeUpdate();
	} catch (SQLException e) {
		throw new PersistenceException(e.getErrorCode());
	}
    }   
    
    @Override
    public List<Alumne> getAlumnes() throws PersistenceException{
        List<Alumne> alumnes = new ArrayList<>();
        prepareConnection();
        try{  
            CallableStatement sql = conn.prepareCall("CALL getAlumnes()");
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
            prepareConnection();
            try{
            CallableStatement sql = conn.prepareCall("CALL getModuls()");
            ResultSet reader = sql.executeQuery();    
            while(reader.next()){
            moduls.add(JDBCUtils.getModul(reader));
            }                
        } catch (SQLException e){
            throw new PersistenceException(e.getErrorCode());
        } 
        return moduls; 
    }
    
    @Override
    public List<Modul> getCursa(int idA) throws PersistenceException {
	prepareConnection();
	CallableStatement sql;
	List<Modul> modulsCursats = new ArrayList<>();
	try {
		sql = conn.prepareCall("CALL getCursa(?)");
		int idAlumne = idA;
		sql.setInt(1, idAlumne);
		ResultSet reader = sql.executeQuery();
		while (reader.next()) {
                    modulsCursats.add(JDBCUtils.getModul(reader));
		}
		} catch (SQLException e) {
                    throw new PersistenceException(e.getErrorCode());
		}
		return modulsCursats;
	}
    
    @Override
    public void updateAlumne(Alumne alumne) throws PersistenceException{
        prepareConnection();
        try{
        CallableStatement actualiza = conn.prepareCall("CALL updateAlumnes(?, ?, ?, ?)");
        String nom = alumne.getNom();
        String c1 = alumne.getCognom1();
        String c2= alumne.getCognom2();
        //String dni = alumne.getDni();
        int id = alumne.getId();
        
        actualiza.setString(1,nom);
        actualiza.setString(2,c1);
        actualiza.setString(3,c2);
        //actualiza.setString(4,dni); 
        actualiza.setInt(4,id);
    
        actualiza.executeUpdate();
        } catch (SQLException e){
            throw new PersistenceException(e.getErrorCode());
        } 
    }
    
    @Override
    public void updateModul(Modul modul) throws PersistenceException{
        prepareConnection();
        try{
        CallableStatement actualiza = conn.prepareCall("CALL updateModuls(?, ?, ?, ?)");
        String nom = modul.getNom();
        String desc = modul.getDescripcio();
        String h = modul.getDurada();
        int id = modul.getId();
        
        actualiza.setString(1,nom);
        actualiza.setString(2,desc);
        actualiza.setString(3,h);
        actualiza.setInt(4,id);
    
        actualiza.executeUpdate();
        } catch (SQLException e){
            throw new PersistenceException(e.getErrorCode());
        } 
    }
    
    @Override
    public void deleteAlumne(int idAlumne) throws PersistenceException {
	prepareConnection();
	CallableStatement delete;
	try {
		delete = conn.prepareCall("CALL deleteAlumne(?)");
		int idA = idAlumne;

		delete.setInt(1, idA);

		delete.executeUpdate();
	} catch (SQLException e) {
		throw new PersistenceException(e.getErrorCode());
	}
    }  
    
    @Override
    public void deleteModul(int idModul) throws PersistenceException {
	prepareConnection();
	CallableStatement delete;
	try {
		delete = conn.prepareCall("CALL deleteModul(?)");
		int idM = idModul;

		delete.setInt(1, idM);

		delete.executeUpdate();
	} catch (SQLException e) {
		throw new PersistenceException(e.getErrorCode());
	}
    } 
    
    @Override
    public void deleteCursa(int idAlumne, int idModul) throws PersistenceException {
	prepareConnection();
	CallableStatement delete;
	try {
		delete = conn.prepareCall("CALL deleteCursa(?, ?)");
		int idA = idAlumne;
		int idM = idModul;

		delete.setInt(1, idA);
		delete.setInt(2, idM);

		delete.executeUpdate();
	} catch (SQLException e) {
		throw new PersistenceException(e.getErrorCode());
	}
    } 
    
    public void prepareConnection() throws PersistenceException {
	try {
		conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Institut", "root", "maletin");
	} catch (SQLException e) {
		throw new PersistenceException(e.getErrorCode());
	}
    }
}

