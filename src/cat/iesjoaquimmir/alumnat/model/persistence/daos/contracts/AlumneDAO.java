
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
        //public abstract void assignAM(int idAlumne, int idModul) throws PersistenceException;
    //mostrar alumnos con sus modulos
    //mostrar alumnos
       public abstract List<Alumne> getAlumnes() throws PersistenceException;
    //mostrar modulos
       public abstract List<Modul> getModuls()throws PersistenceException;
}
