
public class NotEqualReferenceComparisonBehavior implements ObjectReferenceComparisonBehavior {
    @Override
    public  boolean compare(Object obj, Object obj2) {
        return (obj!=obj2);
    }
}
