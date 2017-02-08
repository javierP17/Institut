
package cat.iesjoaquimmir.alumnat.views.console;
import cat.iesjoaquimmir.alumnat.model.persistence.daos.contracts.AlumneDAO;
import cat.iesjoaquimmir.alumnat.model.persistence.daos.impl.jdbc.AlumneMySQLDAO;
import cat.iesjoaquimmir.alumnat.model.persistence.exception.PersistenceException;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Alumne;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Domicili;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.LongException;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Modul;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.NumNegatiuException;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.LongModuls;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.StringTooLongException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Application {
    public static void main(String[] args) throws LongException, StringTooLongException, IOException, PersistenceException {
        
        int opc;
        Scanner inici = new Scanner(System.in);
        do{
            //System.out.println("\nEscull una opció:\n1.Edat-Nom-Dni\n2.dni\n3.Edat-Nom\n4.Dni-Edat\n5.Nom-Dni\n6.Pt8a\n7.FitxersEscriptura\n8.FitxersLectura\n9.EscripturaOutput\n10.LecturaInput\n11.Surt\n");
            System.out.println("\n1.Afegeix usuaris\n2.Mostra Usuaris\n11.Surt\n");
            opc = inici.nextInt();
            switch (opc){
                /*case 1:
                    a();
                    break;*/
               /* case 2:
                    b();
                    break;
                case 3:
                    c();
                    break; 
                case 4:
                    d();
                    break;
                case 5:
                    e();
                    break;
                case 6:
                    f();
                    break;
                case 7:
                    g();
                    break;
                case 8:
                    h();
                    break;
                case 9:
                    i();
                    break;
                case 10:
                    j();
                    break;*/
                /*case 1:
                    i();
                    break;
                case 2:
                    j();
                    break;*/
                case 1:
                    a();
                    break;
            } 
          }while(opc!=11);
    }
    //Insertem usuaris a la BDD
    
    private static void a() throws PersistenceException{
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     /*private static void a(){
                //variables
                String Nom;
                String Dni;
                int Edat;
                //mètode que necesitem per operar amb la pregunta:
                Scanner pregunta = new Scanner(System.in);
                //pregunta el la edat, el nom i el dni de l'alumne:
                    System.out.printf("Introdueix la edat ");
                    Edat = pregunta.nextInt();
                    System.out.printf("Introdueix el nom ");
                    Nom = pregunta.next();
                    System.out.printf("Introdueix el Dni ");
                    Dni = pregunta.next();
                    //Objecte Opció A
                    Alumne opcA = new Alumne(Edat,Nom,Dni);
                //imprimeix el resultat:
                System.out.printf(opcA.getSalutacio());
        }
       private static void b(){
                //variables
                String Dni;
                //mètode que necesitem per operar amb la pregunta:
                Scanner pregunta = new Scanner(System.in);
                //pregunta el la edat, el nom i el dni de l'alumne:
                    System.out.printf("Introdueix el Dni ");
                    Dni = pregunta.next();
                    //Objecte Opció A
                    Alumne opcA = new Alumne(Dni);
                //imprimeix el resultat:
                System.out.printf(opcA.getSalutacio());
       }
       private static void c(){
                //variables
                String Nom;
                int Edat;
                //mètode que necesitem per operar amb la pregunta:
                Scanner pregunta = new Scanner(System.in);
                //pregunta la edat i el nom de l'alumne:
                    System.out.printf("Introdueix la edat ");
                    Edat = pregunta.nextInt();
                    System.out.printf("Introdueix el nom ");
                    Nom = pregunta.next();
                    //Objecte Opció A
                    Alumne opcA = new Alumne(Edat,Nom);
                //imprimeix el resultat:
                System.out.printf(opcA.getSalutacio());
       }
         private static void d(){
                //variables
                String Dni;
                int Edat;
                //mètode que necesitem per operar amb la pregunta:
                Scanner pregunta = new Scanner(System.in);
                //pregunta el dni i  la edat de l'alumne:
                    System.out.printf("Introdueix el dni ");
                    Dni = pregunta.next();
                    System.out.printf("Introdueix la edat ");
                    Edat = pregunta.nextInt();
                    //Objecte Opció A
                    Alumne opcA = new Alumne(Dni,Edat);
                //imprimeix el resultat:
                System.out.printf(opcA.getSalutacio());
         }
      private static void e(){
                //variables
                String Dni;
                String Nom;
                //mètode que necesitem per operar amb la pregunta:
                Scanner pregunta = new Scanner(System.in);
                //pregunta el nom i el dni de l'alumne:
                    System.out.printf("Introdueix el nom ");
                    Nom = pregunta.next();
                    System.out.printf("Introdueix el dni ");
                    Dni = pregunta.next();
                    //Objecte Opció A
                    Alumne opcA = new Alumne(Nom,Dni);
                //imprimeix el resultat:
                System.out.printf(opcA.getSalutacio());
      }   
      private static void f() throws LongException, StringTooLongException{
               //Generem l'ArrayList
               String carrer;
               int num;
               String pis;
               String cp;
               String poblacio;
               String provincia;
               String nom;
               String c1;
               String c2;
               String dni;
               int edat=0;
               int telefonQ;
               int moduls;
               String nomM;
               String descM;
               String horesM;
                //Array de telèfons
                ArrayList<String> telefon = new ArrayList<String>();  
                //Array de mòduls
                ArrayList<Modul> modul = new ArrayList<Modul>();
                //mètode que necesitem per operar amb la pregunta:
                Scanner pregunta = new Scanner(System.in);
                //pregunta el nom i el dni de l'alumne:
                    System.out.printf("Introdueix el nom ");
                    nom = pregunta.next();
                    System.out.printf("Introdueix el primer cognom ");
                    c1 = pregunta.next();
                    System.out.printf("Introdueix el segon cognom ");
                    c2 = pregunta.next();
                    System.out.printf("Introdueix la edat ");   
                    try{  
                        edat = pregunta.nextInt();
                     }catch(InputMismatchException m){
                         m.printStackTrace();
                         dni = pregunta.next();
                     }
                    
                    System.out.printf("Introdueix el dni ");
                    dni = pregunta.next();
                    System.out.printf("Introdueix la provincia ");
                    provincia = pregunta.next();
                    System.out.printf("Introdueix la població ");
                    poblacio = pregunta.next();
                    System.out.printf("Introdueix el codi postal ");
                    cp = pregunta.next();
                    System.out.printf("Introdueix el carrer ");
                    carrer = pregunta.next();
                    System.out.printf("Introdueix la número ");
                    num = pregunta.nextInt();
                    System.out.printf("Introdueix el pis ");
                    pis = pregunta.next();    
                Domicili domicili = new Domicili(carrer, num, pis, cp, poblacio, provincia);
                Alumne alumne = new Alumne( edat,nom,dni, c1,c2 ,telefon,domicili,modul);
                //Pregutem quants mòduls volem i preguntem les dades de cadascun.
                //Quan veigem que l'array de mòduls és superior a 13 crida a un mètode de la classe alumne que crida a una excepió i és caputarada aquí al application
                System.out.printf("Quants mòduls vols introduïr? ");
                    moduls = pregunta.nextInt();
                    for(int o=0;o<moduls;o++){
                        System.out.printf("Introdueix el nom del mòdul ");
                        nomM = pregunta.next();
                        System.out.printf("Introdueix la descripció del mòdul ");
                        descM = pregunta.next();
                        System.out.printf("Introdueix la durada en hores del mòdul ");
                        horesM = pregunta.next(); 
                        try{
                            if(modul.size()>13){
                                alumne.modulsException();
                            }
                            modul.add(new Modul(nomM,descM,horesM));
                        }catch(LongModuls m){
                            m.printStackTrace();
                        }
                    }
                    //Preguntem quants telèfons volem i introduïm les dades de cadascun i
                    //per cada un cridem al mètode de la classe alumne TelException 
                    //que comproba que el telèfon sigui menor de 9 caràcters i que
                    //l'array sigui m menor o igual que 3 si no és així crida 
                    //les diferents excepcions i els errors son capturats a la pròpia classe alumne.
                    System.out.printf("Quants telèfons vols introduïr? ");
                    telefonQ = pregunta.nextInt();
                    for(int o=0;o<telefonQ;o++){
                    System.out.printf("Introdueix el telefon ");
                    String tel = pregunta.next();
                    alumne.TelException(tel);
                 }
                //mostra el format cognom1 cognom2, nom
                System.out.println(alumne.getNomComplert());
                //Pinta el mateix que la linia anterior
                System.out.println(alumne.getDomicili().getDomiciliAmigable());
                //Industria 188, 2o 1a, 08025, Badalona (Barcelona)
                System.out.println(domicili.getDomiciliAmigable());
                System.out.println(alumne.getMajorMenor());
                
                //imprimeix els telefons de l'alumne
                for (int i=0; i<alumne.getTelefon().size();i++){
                   System.out.printf("Telèfon %d: %s\n",i,alumne.getTelefon().get(i));
                }
                
                //imprimeix els mòduls de l'alumne
                for (int i=0; i<alumne.getModul().size();i++){
                   System.out.printf("Mòdul %d:\n Nom del mòdul: %s\n Descripció del mòdul: %s\n hores del mòdul: %s\n",i,
                   alumne.getModul().get(i).getNom(), 
                   alumne.getModul().get(i).getDescripcio(), 
                   alumne.getModul().get(i).getDurada());
                }
              
      } 
      //mètode que escriu el que rep per pantalla a un fitxer
      private static void g() throws IOException{
                //variables
                String Nom;
                String Dni;
                int Edat;
                //mètode que necesitem per operar amb la pregunta:
                Scanner pregunta = new Scanner(System.in);
                //pregunta el la edat, el nom i el dni de l'alumne:
                    System.out.printf("Introdueix la edat ");
                    Edat = pregunta.nextInt();
                    System.out.printf("Introdueix el nom ");
                    Nom = pregunta.next();
                    System.out.printf("Introdueix el Dni ");
                    Dni = pregunta.next();
                    //Objecte Opció A
                    Alumne opcA = new Alumne(Edat,Nom,Dni);
                    Alumne opcA2 = new Alumne(15,"javier","47836761G");
                //imprimeix el resultat:
                System.out.printf(opcA.getSalutacio());
                
                //Escribir datos en fichero mediante caracteres
                    FileWriter writer = null;
                    try {
                        writer = new FileWriter("/home/alumne/lala.txt",true);
                        writer.write(opcA.getSalutacio() + "\n");
                        writer.write(opcA2.getSalutacio()+ "\n");
                        //writer.write("ciao\n");

                    } catch (FileNotFoundException e) {
                        System.err.println("Fitxer no trobat: " + e);
                    } catch (IOException e) {
                        System.err.println("Error d'I/O: " + e);
                    } finally {
                        if(writer != null) {
                            try {
                                writer.close();
                            } catch (IOException ignored) {
                                ignored.printStackTrace();
                            }
                        }
                    }
                
                
        }
      //mètode que llegeix el contingut delfitxer anterior
       private static void h() throws IOException{
        FileReader reader = null;
 
        try {
            reader = new FileReader("/home/alumne/lala.txt");
            int charsLlegits;
            char[] buffer = new char[1024];
            do {
                charsLlegits = reader.read(buffer);
 
                for(int i=0;i<charsLlegits;++i) {
                    System.out.print(buffer[i]);
                }
            } while (charsLlegits != -1);
 
        } catch (FileNotFoundException e) {
            System.err.println("Fitxer no trobat: " + e);
        } catch (IOException e) {
            System.err.println("Error d'I/O: " + e);
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                    ignored.printStackTrace();
                }
            }
        }
       }
       
       //Provem la interface Serializable
       
       //Escriptura de l'objecte al fitxer
    
        */
        
    /*
        private static void i() throws IOException{
            String respuesta="";
            //mètode que necesitem per operar amb la pregunta:
            Scanner pregunta = new Scanner(System.in);
            Alumne p = new Alumne(20,"javier", "47836761G");
            Alumne a = new Alumne(17,"edu", "47836761G");

            ArrayList<Alumne> list = new ArrayList<Alumne>();
            list.add(p);
            list.add(a);
   
       

            ObjectOutputStream objectOutput = null;
            try {
                    //Preguntem el directory on guardarem el fitxer
                    System.out.printf("En que directori vols guardar el fitxer d'usuaris? ");
                    String ruta = pregunta.nextLine();
                    File directori= new File(ruta);
                    if(directori.exists()){
                            File f = new File(directori, "fitxer.bin");
                            if(f.exists()){
                              System.out.printf("El fitxer %s ja existeix", f); 
                              objectOutput = new ObjectOutputStream(new FileOutputStream(f.getPath(),true));
                              objectOutput.writeObject(list);

                            }else{
                                if(f.isFile()){
                                    f.createNewFile();
                                    objectOutput = new ObjectOutputStream(new FileOutputStream(f.getPath(),true));
                                    objectOutput.writeObject(list);
                                    System.out.printf("S'ha generat el fitxer 'fitxer.bin' al directori: %s",directori);
                                }
                            }
                        //}
                        
                    }else{
                        //if(directori.isDirectory()){
                        System.out.printf("El directori: %s no existeix. El vols crear?(s/n)", directori); 
                           respuesta = pregunta.next();
                           if(respuesta.equals("s")){
                               directori.mkdir();
                               File f = new File(directori, "fitxer.bin");
                                if(f.exists()){
                                  System.out.printf("El fitxer %s ja existeix", f);  
                                   objectOutput = new ObjectOutputStream(new FileOutputStream(f.getPath(),true));
                                   objectOutput.writeObject(list);
                                }else{
                                    f.createNewFile(); 
                                     objectOutput = new ObjectOutputStream(new FileOutputStream(f.getPath(),true));
                                     objectOutput.writeObject(list);
                                     System.out.printf("S'ha generat el fitxer 'fitxer.bin' al directori: %s",directori);
                                }
                           }else{
                               System.out.printf("adeu");
                           }
                    }
                    
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                    if(objectOutput != null) {
                            try {
                                    objectOutput.close();
                            } catch (IOException ignored) {
                            }
                    }
            } 
               
        }
        //LEctura del fitxer
        private static void j(){
            Scanner pregunta = new Scanner(System.in);
            System.out.printf("Digues la ruta del fitxer d'usuaris que vols mostrar: ");
            String ruta = pregunta.nextLine();
            ObjectInputStream objectInput = null;
            try {
                
                objectInput = new ObjectInputStream(new FileInputStream(ruta));

    //            //exemple 1: llegint 1 persona
    //            Persona p = (Persona) objectInput.readObject();
    //            System.out.println(p);

                //exemple 2: llegint un array de persones            
                ArrayList<Alumne> list = (ArrayList<Alumne>) objectInput.readObject();
                for(int i=0;i<list.size();++i) {
                    System.out.println(i + " --> " + list.get(i));
                }
                objectInput.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                    if(objectInput != null) {
                            try {
                                    objectInput.close();
                            } catch (IOException ignored) {
                            }
                    }
            }
     
        }
    */           
        
}