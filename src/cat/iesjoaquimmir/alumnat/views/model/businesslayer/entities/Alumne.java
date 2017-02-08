package cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Domicili;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.Modul;
import java.util.ArrayList;
import java.util.Scanner;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.LongException;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.StringTooLongException;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities.LongModuls;
import java.io.Serializable;

public class Alumne extends Entity implements Serializable {
    //<editor-fold defaultstate="collapsed" desc="Estat:atributs">
        private int edat;
        private String nom;
        private String dni;
        private String cognom1;
        private String cognom2;
        //private String telefon;
        private ArrayList<String> telefon;
        private ArrayList<Modul> modul;
        private Domicili domicili;
        public static final int EDAT=99;
        public static final String DNI="00000000A";
        public static final String NOM="Anonymous";
        private int telefonQ;
        private int moduls;
   //</editor-fold>
   //<editor-fold defaultstate="collapsed" desc="Comportament:mètodes">
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
     
        public int getEdat() {
            return edat;
        }

        public void setEdat(int edat) {
            this.edat = edat;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
              if (!nom.matches("^[A-Z-a-z]+$")){
                    throw new IllegalArgumentException(
                        String.format("El nom %s no és correcte", nom )); 
                }
            this.nom = nom;
        }

        public String getDni() {
            return dni;
        }


        public void setDni(String dni) {
             try{
                    if(!dni.matches("^[0-9]{8}+[A-Z]$")){     
                        throw new StringTooLongException(dni);
                    }
                    this.dni = dni;  
             }catch(StringTooLongException d){
                d.printStackTrace();
             }
            
        }
        
        public String getCognom1() {
            return cognom1;
        }


        public void setCognom1(String cognom1) {
            this.cognom1 = cognom1;
        }
        public String getCognom2() {
            return cognom2;
        }


        public void setCognom2(String cognom2) {
            this.cognom2 = cognom2;
        }
        public ArrayList<String> getTelefon() {
            return telefon;
        }
        
        //private String tel;
        public void setTelefon(ArrayList<String> telefon) {
            /*try{
                    for(int i=0; i<telefon.size();i++){
                        tel += telefon.get(1);
                    if(telefon.get(i).matches("^[0-9]{8}+$")){ 
                        throw new StringTooLongException(tel);
                    }
                    }    
             }catch(StringTooLongException e){
                e.printStackTrace();
             }*/
            this.telefon = telefon;
        }
         public Domicili getDomicili() {
            return domicili;
        }


        public void setDomicili(Domicili domicili) {
            this.domicili = domicili;
        }
        //Getters i setters de l'array de moduls de tipus de la classe mòdul
        public ArrayList<Modul> getModul() {
           return modul;
        }

        public void setModul(ArrayList<Modul> modul) {
           this.modul = modul;
        }
        
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constructores">
         public Alumne(int edat, String nom, String dni, String cognom1, String cognom2, ArrayList<String> telefon, Domicili domicili,ArrayList<Modul> modul){
                this.setEdat(edat);
                this.setNom(nom);
                this.setDni(dni);
                this.setCognom1(cognom1);
                this.setCognom2(cognom2);
                this.setTelefon(telefon);
                this.setDomicili(domicili);
                this.setModul(modul);
                
            }
         public Alumne(int edat, String nom, String dni, String cognom1, String cognom2, ArrayList<String> telefon){
                this(edat,nom,dni,cognom1,cognom2,telefon,null,null);          
            }
        public Alumne(int edat, String nom, String dni){
                /*this.setEdat(edat);
                this.setNom(nom);
                this.setDni(dni);*/
                this(edat,nom,dni,null,null,null);
            }
            //Sobrecaàrrega del constructor
            public Alumne(String dni){
                this(EDAT,NOM,dni);
            }
            public Alumne(int edat,String nom){
                this(edat,nom,DNI);
            }
            public Alumne(String dni,int edat){
                this(edat,NOM,dni);
            }
            public Alumne(String nom, String dni){
                this(EDAT,nom,dni);
            }
            //Constructor para hacer viable JDBCUTILS
            public Alumne(String nom,String dni,String cognom1,String cognom2){
                this(EDAT,nom,dni,cognom1,cognom2,null,null,null);
            }
            
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="mètodes d'objecte">
            public String getSalutacio(){
                return String.format("Hola sóc en/la %s amb identificació %s i tinc %d anys",
                getNom(), getDni(), getEdat());
            }
            public String getNomComplert(){
                return String.format("Nom complert de l'alumne: %s %s %s ",
                getCognom2(), getCognom1(), getNom());
            }
            public String getMajorMenor(){
                if(getEdat()<18){
                return String.format("L'alumne %s amb edat %s és menor d'edat",getNom(),
                getEdat());
                }else{
                return String.format("L'alumne %s amb edat %s és major d'edat",getNom(),
                getEdat());  
                }
            }
           //mètode que captura errors de telèfons
           public void TelException (String tel) throws LongException, StringTooLongException{
                        try{
                            if(getTelefon().size()>3){
                                throw new LongException ();
                            }
                            if(tel.length()!=9){
                                throw new StringTooLongException (tel);
                            }
                            getTelefon().add(tel);
                        }catch(LongException r){
                            r.printStackTrace();
                        }
           }
           
           //method que provoca els errors que li venen del aplication sobre els mòduls
            public void modulsException () throws LongModuls{
               throw new LongModuls ();
           }
    //</editor-fold>
   //</editor-fold>
        //sobreescribim el mètode toString només per l'exercici de serialització
       //<editor-fold defaultstate="collapsed" desc="Sobreescriptura">
           @Override
            public String toString() {
            return String.format("Nom: %s - Edat: %d - DNI: %s\n"
            , getNom(), getEdat(),getDni());
            }
         //</editor-fold>

 


    
}
