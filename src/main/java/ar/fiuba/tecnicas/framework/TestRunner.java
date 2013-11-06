package ar.fiuba.tecnicas.framework;

public class TestRunner implements TestListener{
    public static final int SUCCESS_EXIT = 0;
    public static final int FAILURE_EXIT = 1;
    public static final int EXCEPTION_EXIT = 2;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_FAILURE = 2;
    private ResultPrinter resultPrinter;

    public void testStarted(String s) {}
    public void testEnded(String s) {}
    public void testFailed(int statusError, Test test) {}
    public TestRunner() {
        this.resultPrinter= new ResultPrinter(System.out);
    }

    @Override
    public void printSuiteTrace(Test test) {

    }

    @Override
    public void addSuccess(TestCase test) {

    }

    @Override
    public void addError(Test test) {
        testFailed(STATUS_ERROR, test);
    }
    @Override
    public void addFailure(Test test) {
        testFailed(STATUS_FAILURE, test);
    }
    @Override
    public void endTest(Test test) {
        testEnded(test.toString());
    }
    @Override
    public void startTest(Test test) {
        testStarted(test.toString());
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
        resultPrinter.printFooter(result, runTime);
        return result;
    }
}
