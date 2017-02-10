
package cat.iesjoaquimmir.alumnat.views.console;
import cat.iesjoaquimmir.alumnat.model.persistence.daos.contracts.AlumneDAO;
import cat.iesjoaquimmir.alumnat.model.persistence.daos.impl.jdbc.AlumneMySQLDAO;
import cat.iesjoaquimmir.alumnat.model.persistence.exception.PersistenceException;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Alumne;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.LongException;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Modul;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.StringTooLongException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author daw2017
 */
public class AlumnatApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws LongException, StringTooLongException, IOException, PersistenceException{
              int opc;
        Scanner inici = new Scanner(System.in);
        do{
            //System.out.println("\nEscull una opció:\n1.Edat-Nom-Dni\n2.dni\n3.Edat-Nom\n4.Dni-Edat\n5.Nom-Dni\n6.Pt8a\n7.FitxersEscriptura\n8.FitxersLectura\n9.EscripturaOutput\n10.LecturaInput\n11.Surt\n");
            System.out.println("\n1.Afegeix un alumne\n2.Mostra alumnes\n3.Afegeix un módul\n4.Mostra els móduls\n11.Surt\n");
            opc = inici.nextInt();
            switch (opc){
                case 1:
                    saveAlumne();
                    break;
                case 2:
                    getAlumne();
                    break;
                case 3:
                    saveModul();
                    break;
                case 4:
                    getModul();
                    break;
            } 
          }while(opc!=11);
    }
        private static void saveAlumne() throws PersistenceException{
         String nom;
         String c1;
         String c2;
         String dni;
         //mètode que necesitem per operar amb la pregunta:
         Scanner pregunta = new Scanner(System.in);
         //pregunta el color en Hexadecimal:
         System.out.printf("\nNom: ");
         nom = pregunta.next();      
         System.out.printf("\nPrimer Cognom: ");
         c1 = pregunta.next();  
         System.out.printf("\nSegon Cognom: ");
         c2 = pregunta.next();  
         System.out.printf("\nDNI: ");
         dni = pregunta.next();  
         Alumne a1 = new Alumne(nom,dni,c1,c2);
         AlumneDAO alumneDAO = new AlumneMySQLDAO();
         alumneDAO.saveAlumne(a1);
         }
        private static void saveModul() throws PersistenceException{
         String nom;
         String desc;
         String hores;
         //mètode que necesitem per operar amb la pregunta:
         Scanner pregunta = new Scanner(System.in);
         //pregunta el color en Hexadecimal:
         System.out.printf("\nNom: ");
         nom = pregunta.nextLine();      
         System.out.printf("\nDescripció ");
         desc = pregunta.nextLine();  
         System.out.printf("\nhores: ");
         hores = pregunta.nextLine();   
         Modul m1 = new Modul(nom,desc,hores);
         AlumneDAO modulDAO = new AlumneMySQLDAO();
         modulDAO.saveModul(m1);
         }
         private static void getAlumne() throws PersistenceException{
           AlumneDAO alumneDAO = new AlumneMySQLDAO();
           try {
                List<Alumne> alumnes = alumneDAO.getAlumnes();
                /*for(Alumne alumne : alumnes){
                  System.out.println(alumne.toString());
                }*/
                for(int i=0; i<alumnes.size();i++){
                   System.out.println(alumnes.get(i));
                }
            
            }catch(PersistenceException e){
                 e.printStackTrace();       
            }
         }
         private static void getModul() throws PersistenceException{
           AlumneDAO modulDAO = new AlumneMySQLDAO();
           try {
                List<Modul> moduls = modulDAO.getModuls();
                for(Modul modul : moduls){
                  System.out.println(modul.toString());
                }
                /*for(int i=0; i<moduls.size();i++){
                   System.out.println(moduls.get(i));
                }*/
            
            }catch(PersistenceException e){
                 e.printStackTrace();       
            }
         }
}
