package ar.fiuba.tecnicas.framework;

public interface TestListener {
    public void addFailure(Test test);
    public void endTest(Test test);
    public void startTest(Test test);
    public void addError(Test test);
    public void addSuccess(TestCase test);
    public void printSuiteTrace(Test test);
}
