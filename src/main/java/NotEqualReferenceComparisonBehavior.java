
public class NotEqualReferenceComparisonBehavior implements ObjectComparisonBehavior {
    @Override
    public <T> boolean compare(T obj, T obj2) {
        return (obj!=obj2);
    }
}
