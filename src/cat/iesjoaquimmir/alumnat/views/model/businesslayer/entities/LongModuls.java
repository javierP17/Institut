
package cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities;

public class LongModuls extends Exception {

    public String toString(){
       return  String.format("La quantitat de mòduls ha introduïr no pot excedir de 13");
    }

}
