/*
    Implementa la interface ObjectComparisonBehavior,
    define el metodo compare, usando el metodo equals compara dos objetos
    y devuelve true si los objetos son iguales.
 */

package ar.fiuba.tecnicas.framework;

public class EqualComparisonBehavior implements ObjectComparisonBehavior {
    @Override
    public <T> boolean compare(T obj, T obj2) {
        return (obj.equals(obj2));
    }
}
