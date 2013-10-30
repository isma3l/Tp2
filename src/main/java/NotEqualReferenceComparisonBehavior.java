
public class NotEqualReferenceComparisonBehavior implements ObjectComparisonBehavior {
    @Override
    public boolean compare(Object obj, Object obj2) {
        return (obj!=obj2);
    }
}
