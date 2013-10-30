import org.hamcrest.Matcher;

public class AssertThat<T> implements  Test{
    private T actual;
    private Matcher<T> matcher;
    private String message;

    public AssertThat(T actual, Matcher<T> matcher) {
        this.actual = actual;
        this.matcher = matcher;
    }

    public AssertThat(T actual, Matcher<T> matcher, String message) {
        this.actual = actual;
        this.matcher = matcher;
        this.message = message;
    }

    @Override
    public void excecute(TestReport testreport)throws AssertionError{
        if (!matcher.matches(actual)) throw new AssertionError(message);
        testreport.start("AssertThat: ok");
    }

}
