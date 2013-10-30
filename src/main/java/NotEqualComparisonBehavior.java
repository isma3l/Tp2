
public class NotEqualComparisonBehavior implements ObjectComparisonBehavior {
    @Override
    public <T> boolean compare(T obj, T obj2) {
        return   (!(obj.equals(obj2)));
    }
}
