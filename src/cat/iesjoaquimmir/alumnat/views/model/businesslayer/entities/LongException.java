
package cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities;

public class LongException extends Exception {

    public String toString(){
       return  String.format("La quantitat de telèfons ha introduïr no pot excedir de 3 i cada telèfon ha de estar compost per 9 caràcters");
    }
}
