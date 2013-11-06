package ar.fiuba.tecnicas.framework;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;

public class ResultPrinter implements TestListener{
    PrintStream printStream;

    public ResultPrinter(PrintStream writer) {
        printStream = writer;
    }
    public void printFooter(TestReport result,long runTime) {
        printStream.println();
        printStream.println("-----------------");
        printSummary(result,runTime);
    }

    private void printSummary(TestReport result,long runTime) {
        printStream.println("SUMMARY");
        printStream.println("Time: " + elapsedTimeAsString(runTime));
        printStream.println("Run: " + result.runCount());
        printStream.println("Failures: " + result.failureCount());
        printStream.println("Errors: " + result.errorCount());
    }
    private String elapsedTimeAsString(long runTime) {
        return NumberFormat.getInstance().format((double) runTime / 1000);
    }
    @Override
    public void endTest(Test test) {}
    @Override
    public void startTest(Test test) {}

    @Override
    public void printSuiteTrace(Test test) {
       printStream.print(test);
    }

    @Override
    public void addSuccess(TestCase test) {
        printStream.println("[Ok]\t\t" + test);
    }
    @Override
    public void addFailure(Test test) {
        printStream.println("[Failure]\t" + test);
    }
    @Override
    public void addError(Test test) {
        printStream.println("[Error]\t\t" + test);
    }
}
