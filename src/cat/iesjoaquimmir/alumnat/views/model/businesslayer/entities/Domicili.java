package cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities;

public class Domicili {
    //<editor-fold defaultstate="collapsed" desc="Estat:atributs">
        private String carrer;
        private int numero;
        private String pis;
        private String cp;
        private String poblacio;
        private String provincia;
   //</editor-fold>
   //<editor-fold defaultstate="collapsed" desc="Comportament:mètodes">
    //<editor-fold defaultstate="collapsed" desc="getters/setters">

    public String getCarrer() {
        return carrer;
    }


    public void setCarrer(String carrer) {
        if (carrer== null){
                    throw new IllegalArgumentException(
                        String.format("El carrer no pot ser nul", carrer )); 
                }
        this.carrer = carrer;
    }


    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
         try{
                    if(numero<0){     
                        throw new NumNegatiuException(numero);
                    }
                    this.numero = numero;  
             }catch(NumNegatiuException d){
                d.printStackTrace();
             }
        //this.numero = numero;
    }


    public String getPis() {
        return pis;
    }


    public void setPis(String pis) {
        this.pis = pis;
    }


    public String getCp() {
        return cp;
    }


    public void setCp(String cp) {
         if (cp== null){
                    throw new IllegalArgumentException(
                        String.format("El codi postal no pot ser nul", cp )); 
         }
        this.cp = cp;
    }


    public String getPoblacio() {
        return poblacio;
    }


    public void setPoblacio(String poblacio) {
         if (poblacio== null){
                    throw new IllegalArgumentException(
                        String.format("La població no pot ser nula", poblacio )); 
         }
        this.poblacio = poblacio;
    }


    public String getProvincia() {
        return provincia;
    }


    public void setProvincia(String provincia) {
         if (provincia== null){
                    throw new IllegalArgumentException(
                        String.format("La provincia no pot ser nula", provincia )); 
         }
        this.provincia = provincia;
    }
    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="constructores">
      public Domicili(String carrer, int numero, String pis, String cp, String poblacio, String provincia){
                this.setCarrer(carrer);
                this.setNumero(numero);
                this.setPis(pis);
                this.setCp(cp);
                this.setPoblacio(poblacio);
                this.setProvincia(provincia);
      }
      public Domicili(String carrer, int numero, String cp, String poblacio, String provincia){
                this(carrer,numero,null,cp,poblacio,provincia);

      }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="mètodes d'objecte">
      public String getDomiciliAmigable(){
                return String.format("%s, %d, %s, %s (%s)",
                getCarrer(), getNumero(), getCp(), getPoblacio(), getProvincia());
            }
    //</editor-fold>
   //</editor-fold>

    
}
