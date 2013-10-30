
public class NotEqualConditionComparisonBehavior implements ConditionComparisonBehavior{
    @Override
    public boolean compare(boolean condition) throws AssertionError {
        return (!condition);
    }
}
