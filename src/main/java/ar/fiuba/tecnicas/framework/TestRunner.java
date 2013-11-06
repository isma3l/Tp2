package ar.fiuba.tecnicas.framework;

import static org.hamcrest.CoreMatchers.is;

public class TestRunner implements TestListener{
    @Override
    public void addError(Test test, Throwable exception) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public static final int SUCCESS_EXIT = 0;
    public static final int FAILURE_EXIT = 1;
    public static final int EXCEPTION_EXIT = 2;
    private ResultPrinter resultPrinter;

    public TestRunner() {
        this.resultPrinter= new ResultPrinter(System.out);
    }

    @Override
    public void addFailure(Test test, AssertionError assertionError) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void endTest(Test test) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void startTest(Test test) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    public static void main(String args[]) {
        TestRunner testRunner = new TestRunner();
        try {
            TestReport testreport=testRunner.start();
            if (!testreport.wasSuccessful()) {
                System.exit(FAILURE_EXIT);
            }
            System.exit(SUCCESS_EXIT);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(EXCEPTION_EXIT);
        }
    }

    private Test getTest(){
        TestWithFramework testWithFramework= new TestWithFramework();
        return testWithFramework.createTest();
    }

    private TestReport start(){
        Test test= getTest();
        return doRun(test);
    }

    private TestReport doRun(Test suite) {
        TestReport result = new TestReport();
        result.addListener(resultPrinter);
        long startTime = System.currentTimeMillis();
        suite.run(result);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        resultPrinter.print(result, runTime);
        return result;
    }
}
