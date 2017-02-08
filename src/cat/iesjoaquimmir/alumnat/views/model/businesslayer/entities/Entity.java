
package cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities;
import cat.iesjoaquimmir.alumnat.views.model.businesslayer.utilities.NumberUtils;

public class Entity {
    private long id = NumberUtils.UNSAVED_VALUE; //Inicialitxem el id a -1
    public long getId() {
        return id;
    }
    public void setId(long id) {
        if(this.getId()!=NumberUtils.UNSAVED_VALUE){
            throw new UnsupportedOperationException("No se puede");
        }
        if(id <= 0){
            throw new IllegalArgumentException("Valor de id no valido");
        }
        this.id = id;
    }
}
