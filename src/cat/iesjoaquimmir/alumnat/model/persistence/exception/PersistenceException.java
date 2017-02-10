
package cat.iesjoaquimmir.alumnat.model.persistence.exception;

public class PersistenceException extends Exception{
    private Integer codiError;
    public PersistenceException (int codi){
        codiError = codi;
    }
    @Override
    public String toString(){
        String missatge="";
        StringBuilder sb = new StringBuilder();
        sb.append("Excepció provocada en accedir a la base de dades Institut. ");
        sb.append("Codi Error");
        sb.append(codiError.toString());
        missatge=sb.toString();
        return missatge;
    } 
}
