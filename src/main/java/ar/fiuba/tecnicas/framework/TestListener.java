package ar.fiuba.tecnicas.framework;

public interface TestListener {
    public void addFailure(Test test, AssertionError assertionError);
    public void endTest(Test test);
    public void startTest(Test test);
    void addError(Test test, Throwable exception);
}
