
public class AssertObjectReferenceComparison extends Test {
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
