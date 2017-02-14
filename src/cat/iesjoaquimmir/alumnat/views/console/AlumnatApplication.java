
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
            System.out.println("\n1.Afegeix un alumne\n2.Mostra alumnes\n3.Afegeix un módul\n4.Mostra els móduls\n5.Assignar un alumne a un mòdul\n6.Mostra els mòduls d'un usuari\n7.Edita un alumne\n8.Esborra un alumne\n9.Esborra un mòdul\n11.Surt\n");
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
                case 5: saveCursa();
                    break;
                case 6: getCursa();
                    break;
                case 7: updateAlumne();
                    break;
                case 8: deleteAlumne();
                    break;
                case 9: deleteModul();
                    break;
            } 
          }while(opc!=11);
    }
        /**
	* This method stores students on the database
	*/
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
      	/**
	* This method stores moduls on the database
	*/
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
        
        /**
	* This method assign alumnes to the modules on the database
	*/
        private static void saveCursa() throws PersistenceException {
            int idAlumne;
            int idModul;
            Scanner pregunta = new Scanner(System.in);
            getAlumne();
            System.out.printf("\nDigues el id del Alumne que vols assignar a un modul: ");
            idAlumne = pregunta.nextInt();
            getModul();
            System.out.printf("\nDigues el id del Mdul al que vols assignar-li l'alumne anterior: ");
            idModul = pregunta.nextInt();
            AlumneDAO alumneDAO = new AlumneMySQLDAO();
            alumneDAO.saveCursa(idAlumne, idModul);
            //pregunta.close();
	}
        
        /**
	 * This method get students from the database
	 */
         private static void getAlumne() throws PersistenceException{
           AlumneDAO alumneDAO = new AlumneMySQLDAO();
           try {
                List<Alumne> alumnes = alumneDAO.getAlumnes();
                for(Alumne alumne : alumnes){
                  System.out.println(alumne.toString());
                }
            
            }catch(PersistenceException e){
                 e.printStackTrace();       
            }
         }
         
         /**
	 * This method get moduls from the database
	 */
         private static void getModul() throws PersistenceException{
           AlumneDAO modulDAO = new AlumneMySQLDAO();
           try {
                List<Modul> moduls = modulDAO.getModuls();
                for(Modul modul : moduls){
                  System.out.println(modul.toString());
                }
            
            }catch(PersistenceException e){
                 e.printStackTrace();       
            }
         }
         
         /**
	 * This method get moduls assignats a un alumne on the database
	 */
	private static void getCursa() throws PersistenceException {
            AlumneDAO modulDAO = new AlumneMySQLDAO();
            int idAlumne;
            getAlumne();
            Scanner pregunta = new Scanner(System.in);
            System.out.printf("\nDigues el id del Alumne que vols mostrar amb els seus moduls: ");
            idAlumne = pregunta.nextInt();
            //pregunta.close();
            try {
		List<Modul> modulsAssign = modulDAO.getCursa(idAlumne);
		for (Modul modul : modulsAssign) {
                    System.out.println(modul.toString());
		}

            } catch (PersistenceException e) {
			e.printStackTrace();
            }
	}
        
         /**
	 * This method update alumnes from the database
	 */
            private static void updateAlumne() throws PersistenceException{
            Scanner pregunta = new Scanner(System.in);
            String nom;
            String c1;
            String c2;
            String dni;
            String resposta;
            int alumneM;
            AlumneDAO alumneDAO = new AlumneMySQLDAO();
            try {
                List<Alumne> alumnes = alumneDAO.getAlumnes();
                for(int i=0; i<alumnes.size();i++){
                   System.out.println(alumnes.get(i));
                }
                System.out.printf("\nVols modificar algún color?(y/n): ");
                resposta = pregunta.next();
                resposta.toUpperCase();
                if(resposta.equals("y") || resposta.equals("Y")){
                  System.out.printf("\nIntrodueix l'id de l'alumne que vols modificar: ");  
                  alumneM = pregunta.nextInt();
                  System.out.printf("\nIntrodueix el nom: ");  
                  nom = pregunta.next();
                  System.out.printf("\nIntrodueix el primer cognom: ");  
                  c1 = pregunta.next();
                  System.out.printf("\nIntrodueix el segon cognom: ");  
                  c2 = pregunta.next();
                  /*System.out.printf("\nIntrodueix el dni: ");  
                  dni = pregunta.next();*/
                  Alumne alumne=alumnes.get(alumneM - 1);
                  alumne.setNom(nom);
                  alumne.setCognom1(c1);
                  alumne.setCognom2(c2);
                  //alumne.setDni(dni);
                  alumneDAO.updateAlumne(alumne);
                }
            }catch(PersistenceException e){
                 e.printStackTrace();       
            }
        }
        
        /**
	* This method delete alumnes from the database
	*/
        private static void deleteAlumne() throws PersistenceException {
            int idAlumne;
            Scanner pregunta = new Scanner(System.in);
            getAlumne();
            System.out.printf("\nDigues el id del Alumne que vols esborrar: ");
            idAlumne = pregunta.nextInt();
            AlumneDAO alumneDAO = new AlumneMySQLDAO();
            alumneDAO.deleteAlumne(idAlumne);
	}
         /**
	* This method delete moduls from the database
	*/
        private static void deleteModul() throws PersistenceException {
            int idModul;
            Scanner pregunta = new Scanner(System.in);
            getModul();
            System.out.printf("\nDigues el id del mòdul que vols esborrar: ");
            idModul = pregunta.nextInt();
            AlumneDAO modulDAO = new AlumneMySQLDAO();
            modulDAO.deleteModul(idModul);
	}
}
