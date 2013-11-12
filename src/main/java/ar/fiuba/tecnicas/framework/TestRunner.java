package ar.fiuba.tecnicas.framework;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.List;
import java.util.regex.PatternSyntaxException;

/*
 Responsabilidad: Crear y correr test ya definidos o un grupo de test definidios filtrado con expresiones regulares
 */
public class TestRunner extends TestListener{
    public static final int SUCCESS_EXIT = 0;
    public static final int FAILURE_EXIT = 1;
    public static final int EXCEPTION_EXIT = 2;
    private ResultPrinter resultPrinter;
    private String regexpTestcase;
    private String regexpTestsuite;
    private List<String> argtags;

    public TestRunner() {
        this.resultPrinter= new ResultPrinter(System.out);
        regexpTestcase="";
        regexpTestsuite="";
    }

    public void setRegexpTestcase(String regexpTestcase) {
        this.regexpTestcase = regexpTestcase;
    }

    public void setRegexpTestsuite(String regexpTestsuite) {
        this.regexpTestsuite = regexpTestsuite;
    }

    public void setArgtags(List<String> argtags) {
        this.argtags = argtags;
    }

    public static void main(String args[]) {
        try {
            TestRunner testRunner = new TestRunner();
            ArgumentValidator argvalidate= new ArgumentValidator(testRunner,args);
            argvalidate.start();
            TestReport testreport=testRunner.start();
            if (!testreport.wasSuccessful()) {
                System.exit(FAILURE_EXIT);
            }
            System.exit(SUCCESS_EXIT);
        }catch (InvalidArgumentException badarg){
            Usage usage= new Usage();
            System.err.println(usage);
            System.exit(EXCEPTION_EXIT);
        }catch (PatternSyntaxException patternexcp){
            System.err.println("Invalid regular expression 's syntax");
            System.exit(EXCEPTION_EXIT);
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
        result.initializeRecognizerExpression(regexpTestcase,regexpTestsuite);
        result.addListener(resultPrinter);
        long startTime = System.currentTimeMillis();
        suite.run(result);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        resultPrinter.printFooter(result, runTime);
        return result;
    }
}
