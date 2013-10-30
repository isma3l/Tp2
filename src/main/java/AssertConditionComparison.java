
public class AssertConditionComparison implements Test{
    private boolean condition;
    private String message;
    private ConditionComparisonBehavior conditioncomparisonbehavior;

    public AssertConditionComparison(boolean condition, ConditionComparisonBehavior conditioncomparisonbehavior) {
        this.condition = condition;
        this.conditioncomparisonbehavior = conditioncomparisonbehavior;
    }

    public AssertConditionComparison(boolean condition, String message,
                                     ConditionComparisonBehavior conditioncomparisonbehavior) {
        this.condition = condition;
        this.message = message;
        this.conditioncomparisonbehavior = conditioncomparisonbehavior;
    }

    @Override
    public void excecute(TestReport testreport)throws AssertionError{
        if(conditioncomparisonbehavior.compare(condition)) throw new AssertionError(message);
        testreport.start("Assert: condition ok");
    }
}
