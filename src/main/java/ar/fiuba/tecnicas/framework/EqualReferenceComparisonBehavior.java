/*
    Implementa la interface ObjectReferenceComparisonBehavior
    define el metodo compare y devuelve true si dos objetos tienen las mismas referencias.
 */

package ar.fiuba.tecnicas.framework;

public class EqualReferenceComparisonBehavior implements ObjectReferenceComparisonBehavior {
    @Override
    public boolean compare(Object obj, Object obj2) {
        return (obj==obj2);
    }
}
