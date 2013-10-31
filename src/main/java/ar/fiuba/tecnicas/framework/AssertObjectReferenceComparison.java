/*
    Se encarga realizar la comparacion de referencias de dos objetos.
    Utiliza el patron strategy, y de acuerdo al tipo de ObjectReferenceComparisonBehavior
    el resultado de la validacion sera distinto.
 */

package ar.fiuba.tecnicas.framework;

public class AssertObjectReferenceComparison implements Test {
    private Object expected;
    private Object actual;
    private String message;
    private ObjectReferenceComparisonBehavior comparisonbehavior;
    private void assignExpectedAndActual(Object expected, Object actual, ObjectReferenceComparisonBehavior comparisonbehavior){
        this.expected=expected;
        this.actual=actual;
        this.comparisonbehavior=comparisonbehavior;
    }
    public AssertObjectReferenceComparison(Object expected, Object actual, ObjectReferenceComparisonBehavior comparisonbehavior){
        assignExpectedAndActual(expected,actual,comparisonbehavior);
        this.message=new String();
    }
    public AssertObjectReferenceComparison(Object expected, Object actual,
                                           ObjectReferenceComparisonBehavior comparisonbehavior,
                                           String message){
        assignExpectedAndActual(expected,actual,comparisonbehavior);
        this.message=new String(message);
    }
    @Override
    public void excecute(TestReport testreport)throws AssertionError{
        if(!comparisonbehavior.compare(expected,actual)) throw new AssertionError(message);
        testreport.start(comparisonbehavior.getClass()+": expected: "+ expected.toString()+"\tactual: "+actual.toString());
    }
}
