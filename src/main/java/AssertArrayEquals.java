import java.util.Arrays;

public class AssertArrayEquals implements Test {
    private Object[] expecteds;
    private Object[] actuals;
    private String message;
    private void cloneExpectedsAndActuals(Object[] expecteds, Object[] actuals){
        this.expecteds=expecteds.clone();
        this.actuals=actuals.clone();
    }
    public AssertArrayEquals(Object[] expecteds, Object[] actuals){
        cloneExpectedsAndActuals(expecteds,actuals);
        message=new String();
    }
    public AssertArrayEquals(Object[] expecteds, Object[] actuals,String message){
        cloneExpectedsAndActuals(expecteds,actuals);
        this.message=new String(message);
    }
    @Override
    public void excecute(TestReport testreport)throws AssertionError{
           if (!Arrays.equals(expecteds,actuals)) throw new AssertionError(message);
        testreport.start("Assert: arrays ok");
    }
}
