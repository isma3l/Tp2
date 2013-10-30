
public class fail extends Test{
    private String message;

    public fail(String message) {
        this.message = message;
    }
    public void excecute(TestReport testreport)throws AssertionError{
        throw new AssertionError(message);
    }
}
