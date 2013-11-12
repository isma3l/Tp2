package ar.fiuba.tecnicas.framework;
 /*
 Responsabilidad: Crear y correr test ya definidos o un grupo de test definidios filtrado con expresiones regulares
 */
public class TestRunner extends TestListener{
    public static final int SUCCESS_EXIT = 0;
    public static final int FAILURE_EXIT = 1;
    public static final int EXCEPTION_EXIT = 2;
    private ResultPrinter resultPrinter;
    private String regularExpression;

    public TestRunner() {
        this.resultPrinter= new ResultPrinter(System.out);
        regularExpression = "";
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
