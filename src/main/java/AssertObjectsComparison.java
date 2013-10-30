
public class AssertObjectsComparison implements Test{
    private Object expected;
    private Object actual;
    private String message;
    private ObjectComparisonBehavior comparisonbehavior;
    private void assignExpectedAndActual(Object expected, Object actual, ObjectComparisonBehavior comparisonbehavior){
        this.expected=expected;
        this.actual=actual;
        this.comparisonbehavior=comparisonbehavior;
    }
    public AssertObjectsComparison(Object expected, Object actual, ObjectComparisonBehavior comparisonbehavior){
        assignExpectedAndActual(expected,actual,comparisonbehavior);
        this.message=new String();
    }
    public AssertObjectsComparison(Object expected, Object actual,
                                   ObjectComparisonBehavior comparisonbehavior,
                                   String message){
        assignExpectedAndActual(expected,actual,comparisonbehavior);
        this.message=new String(message);
    }
    @Override
    public void excecute(TestReport testreport)throws AssertionError{
        if(comparisonbehavior.compare(expected,actual)) throw new AssertionError(message);
        testreport.start("Assert: expected: "+ expected.toString());
    }
}
