
public class AssertNullObjectComparison implements Test{
    private Object object;
    private String message;
    private NullComparisonBehavior nullComparisonBehavior;

    public AssertNullObjectComparison(Object object, String message, NullComparisonBehavior nullComparisonBehavior) {
        this.object = object;
        this.message = message;
        this.nullComparisonBehavior = nullComparisonBehavior;
    }
    public AssertNullObjectComparison(Object object, NullComparisonBehavior nullComparisonBehavior) {

        this.object = object;
        this.nullComparisonBehavior = nullComparisonBehavior;
    }

    @Override
    public void excecute(TestReport testreport) throws AssertionError{
        if(nullComparisonBehavior.compare(object)) throw new AssertionError(message);
        testreport.start("Assert: condition ok");
    }
}
