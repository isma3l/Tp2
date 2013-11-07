package ar.fiuba.tecnicas.framework;

public interface TestListener {
    public void addFailure(Test test,boolean firsttimeintest);
    public void endTest(Test test);
    public void startTest(Test test);
    public void addError(Test test,boolean firstimeintest);
    public void addSuccess(TestCase test,boolean firsttimeintest);
    public void printSuiteTrace(Test test);
    public void print(String messsage);
    public void insertHSeparator();
}
