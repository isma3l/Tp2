
public class EqualConditionComparisonBehavior implements ConditionComparisonBehavior {
    @Override
    public boolean compare(boolean condition) throws AssertionError {
        return condition;
    }
}
