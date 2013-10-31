/*
    Compara un objeto a una org.hamcrest.Matcher para ver si el objeto
    dado coincide con lo que el Matcher requiere que ésta coincida.
 */

package ar.fiuba.tecnicas.framework;
import org.hamcrest.Matcher;

public class AssertThat<T> extends Test {
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
        testreport.start(getClass()+": ok");
    }

}
