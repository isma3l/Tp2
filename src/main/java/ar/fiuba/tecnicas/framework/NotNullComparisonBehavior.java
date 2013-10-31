/*
    Implementa la interface  ReferenceComparisonBehavior
    define el metodo compare, y devuelve true si la referencia del objeto es distinta de null
 */


package ar.fiuba.tecnicas.framework;

public class NotNullComparisonBehavior implements ReferenceComparisonBehavior {
    @Override
    public boolean compare(Object object) throws AssertionError {
        return (object!=null);
    }
}
