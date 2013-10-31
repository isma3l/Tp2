/*
    Implementa la interface ObjectComparisonBehavior,
    define el metodo compare, usando el metodo equals compara dos objetos
    y devuelve true si dos objetos son diferentes.
 */

package ar.fiuba.tecnicas.framework;

public class NotEqualComparisonBehavior implements ObjectComparisonBehavior {
    @Override
    public <T> boolean compare(T obj, T obj2) {
        return   (!(obj.equals(obj2)));
    }
}
