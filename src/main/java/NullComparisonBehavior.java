
public class NullComparisonBehavior implements ReferenceComparisonBehavior {
    @Override
    public boolean compare(Object object) throws AssertionError {
        return (object==null);
    }
}
