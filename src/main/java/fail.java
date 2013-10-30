
public class fail implements Test{
    private String message;

    public fail() {}

    public fail(String message) {
        this.message = message;
    }

    @Override
    public void excecute(TestReport testreport)throws AssertionError{
        throw new AssertionError(message);
    }
}
