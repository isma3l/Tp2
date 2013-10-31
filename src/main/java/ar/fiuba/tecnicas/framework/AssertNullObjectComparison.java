/*
    Se encarga de comprobar si la referencia a un objeto es null o distinta de null.
    Se utiliza el patron Strategy, y el resultado de la validacion dependerá del
    tipo de ReferenceComparisonBehavior, que recibe como parametro al ser construida.
*/

package ar.fiuba.tecnicas.framework;

public class AssertNullObjectComparison extends Test {
    private Object object;
    private String message;
    private ReferenceComparisonBehavior nullComparisonBehavior;

    public AssertNullObjectComparison(Object object, ReferenceComparisonBehavior nullComparisonBehavior,String message) {
        this.object = object;
        this.message = message;
        this.nullComparisonBehavior = nullComparisonBehavior;
    }
    public AssertNullObjectComparison(Object object, ReferenceComparisonBehavior nullComparisonBehavior) {

        this.object = object;
        this.nullComparisonBehavior = nullComparisonBehavior;
    }
    @Override
    public void excecute(TestReport testreport) throws AssertionError{
        if(!nullComparisonBehavior.compare(object)) throw new AssertionError(message);
        testreport.start(nullComparisonBehavior.getClass()+": Null check ok");
    }
}
