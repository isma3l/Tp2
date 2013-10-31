/*
    Implementa la interface ObjectReferenceComparisonBehavior
    define el metodo compare y devuelve true si los objetos tienen distinta referencias
 */

package ar.fiuba.tecnicas.framework;

public class NotEqualReferenceComparisonBehavior implements ObjectReferenceComparisonBehavior {
    @Override
    public  boolean compare(Object obj, Object obj2) {
        return (obj!=obj2);
    }
}
