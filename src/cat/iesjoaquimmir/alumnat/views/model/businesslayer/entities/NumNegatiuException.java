
package cat.iesjoaquimmir.alumnat.views.model.businesslayer.entities;

public class NumNegatiuException extends Exception {

    private Integer num;
    public NumNegatiuException(int x) {
        num = new Integer(x);
    }

    public String toString() {
        return  String.format("No pots introduïr un número negatiu per aquesta secció: %d", num);
    }
}
