/*
    Se encarga de comprobar que una condicion booleana sea válida.
    Usa el patron Strategy, el resultado de la validacion dependera
    según el tipo de ConditionComparisonBehavior que recibe como parametro al ser construida.
 */

package ar.fiuba.tecnicas.framework;

public class AssertConditionComparison implements Test {
    private boolean condition;
    private String message;
    private ConditionComparisonBehavior conditioncomparisonbehavior;

    public AssertConditionComparison(boolean condition, ConditionComparisonBehavior conditioncomparisonbehavior) {
        this.condition = condition;
        this.conditioncomparisonbehavior = conditioncomparisonbehavior;
    }

    public AssertConditionComparison(boolean condition,
                                     ConditionComparisonBehavior conditioncomparisonbehavior,
                                     String message) {
        this.condition = condition;
        this.message = message;
        this.conditioncomparisonbehavior = conditioncomparisonbehavior;
    }
     @Override
    public void excecute(TestReport testreport)throws AssertionError{
        if(!conditioncomparisonbehavior.compare(condition)) throw new AssertionError(message);
        testreport.start(conditioncomparisonbehavior.getClass()+": condition ok");
    }
}
