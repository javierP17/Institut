
package cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities;


public class Modul extends Entity {
        //<editor-fold defaultstate="collapsed" desc="Estat:atributs">
        private String nom;
        private String descripcio;
        private String durada;
   //</editor-fold>
   //<editor-fold defaultstate="collapsed" desc="Comportament:mètodes">
    //<editor-fold defaultstate="collapsed" desc="getters/setters">
 
        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            if (nom== null){
                    throw new IllegalArgumentException(
                        String.format("El nom del mòdul no pot ser nul", nom )); 
                }
            this.nom = nom;
        }

        public String getDescripcio() {
            return descripcio;
        }

        public void setDescripcio(String descripcio) {
            this.descripcio = descripcio;
        }

        public String getDurada() {
            return durada;
        }

        public void setDurada(String durada) {
            if (durada== null){
                    throw new IllegalArgumentException(
                        String.format("la durada del mòdul no pot ser nul", durada )); 
                }
            this.durada = durada;
        }
     
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constructores">
       public Modul(String nom, String descripcio, String durada){
                this.setNom(nom);
                this.setDescripcio(descripcio);
                this.setDurada(durada);
                
       }
       public Modul(String nom, String durada){
                this(nom,durada,null);          
            }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="mètodes d'objecte">
       @Override
            public String toString() {
            return String.format("Modul(%d)\nIdentificador: %d - Nom: %s - Descripció: %s - hores: %s\n"
            , getId(),getId(),getNom(), getDescripcio(),getDurada());
            }
    //</editor-fold>
        
}
