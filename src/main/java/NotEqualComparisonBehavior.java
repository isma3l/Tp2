
public class NotEqualComparisonBehavior implements ObjectComparisonBehavior {
    @Override
    public boolean compare(Object obj, Object obj2) {
        return (!(obj.equals(obj2)));
    }
}
