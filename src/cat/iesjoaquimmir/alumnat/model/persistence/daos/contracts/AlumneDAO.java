
package cat.iesjoaquimmir.alumnat.model.persistence.daos.contracts;

import cat.iesjoaquimmir.alumnat.model.persistence.exception.PersistenceException;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Alumne;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Modul;
import java.util.List;

public interface AlumneDAO {
    //crear moduls
        public abstract void saveModul(Modul modul) throws PersistenceException;
    //crear alumnos
        public abstract void saveAlumne(Alumne alumne) throws PersistenceException;
    //asignar modulos a alumnos
	public abstract void saveCursa(int idAlumne, int idModul) throws PersistenceException;
    //mostrar alumnos con sus modulos
        public abstract List<Modul> getCursa(int idAlumne) throws PersistenceException;
    //mostrar alumnos
       public abstract List<Alumne> getAlumnes() throws PersistenceException;
    //mostrar modulos
       public abstract List<Modul> getModuls()throws PersistenceException;
    //Modificar alumnes
       public abstract void updateAlumne(Alumne alumne) throws PersistenceException;
    //esborrar alumnes
       public abstract void deleteAlumne(int idAlumne) throws PersistenceException;
    //esborrar moduls
       public abstract void deleteModul(int idModul) throws PersistenceException;
}
