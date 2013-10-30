import java.util.Arrays;

public class AssertArrayEquals<T> extends Test {
    private T[] expecteds;
    private T[] actuals;
    private String message;
    private void cloneExpectedsAndActuals(T[] expecteds, T[] actuals){
        this.expecteds=expecteds.clone();
        this.actuals=actuals.clone();
    }
    public AssertArrayEquals(T[] expecteds, T[] actuals){
        cloneExpectedsAndActuals(expecteds,actuals);
        message=new String();
    }
    public AssertArrayEquals(T[] expecteds, T[] actuals,String message){
        cloneExpectedsAndActuals(expecteds,actuals);
        this.message=new String(message);
    }
    @Override
    public void excecute(TestReport testreport)throws AssertionError{
           if (!Arrays.equals(expecteds,actuals)) throw new AssertionError(message);
        testreport.start(getClass()+": arrays ok");
    }
}
