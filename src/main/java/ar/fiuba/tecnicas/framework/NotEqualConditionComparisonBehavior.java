/*
    Implementa a la interface ConditionComparisonBehavior,
    define el metodo compare y devuelve true si la condicion booleana es falsa.
 */

package ar.fiuba.tecnicas.framework;

public class NotEqualConditionComparisonBehavior implements ConditionComparisonBehavior {
    @Override
    public boolean compare(boolean condition) throws AssertionError {
        return (!condition);
    }
}
