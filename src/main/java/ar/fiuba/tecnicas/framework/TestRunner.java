package ar.fiuba.tecnicas.framework;
 /*
 Responsabilidad: Crear y correr test ya definidos o un grupo de test definidios filtrado con expresiones regulares
 */
public class TestRunner implements TestListener{
    public static final int SUCCESS_EXIT = 0;
    public static final int FAILURE_EXIT = 1;
    public static final int EXCEPTION_EXIT = 2;
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_FAILURE = 2;
    private ResultPrinter resultPrinter;
    private String regularExpression;

    public void testStarted(String s) {}
    public void testEnded(String s) {}
    public void testFailed(int statusError, Test test) {}
    public TestRunner() {
        this.resultPrinter= new ResultPrinter(System.out);
        regularExpression = "";
    }

    @Override
    public void print(String messsage) {
    }

    @Override
    public void printSuiteTrace(Test test) {

    }

    @Override
    public void addSuccess(TestCase test,boolean firstimeintest) {

    }

    @Override
    public void insertHSeparator() {

    }

    @Override
    public void addError(Test test,boolean firstimeintest) {
        testFailed(STATUS_ERROR, test);
    }
    @Override
    public void addFailure(Test test,boolean firstimeintest) {
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
        testRunner.setRegularExpression(args);

        try {
            TestReport testreport=testRunner.start();
            if (!testreport.wasSuccessful()) {
                System.exit(FAILURE_EXIT);
            }
            System.exit(SUCCESS_EXIT);
        } catch (Throwable e) {
            System.err.println(e.getMessage());
            System.exit(EXCEPTION_EXIT);
        }
    }
    private Test getTest() throws Exception {
        return AllTests.suite();
    }
    private TestReport start() throws Throwable {
        Test test= getTest();
        return doRun(test);
    }
    private TestReport doRun(Test suite) throws Throwable {
        TestReport result = new TestReport();
        result.initializeRecognizerExpression(regularExpression);
        result.addListener(resultPrinter);
        long startTime = System.currentTimeMillis();
        suite.run(result);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        resultPrinter.printFooter(result, runTime);
        return result;
    }

    private void setRegularExpression(String args[]) {
        if(args.length > 0 )
            this.regularExpression = args[0];
    }
}
