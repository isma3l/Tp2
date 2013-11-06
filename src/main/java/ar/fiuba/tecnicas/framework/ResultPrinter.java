package ar.fiuba.tecnicas.framework;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;

public class ResultPrinter implements TestListener{
    PrintStream printStream;
    int fColumn = 0;

    public ResultPrinter(PrintStream writer) {
        printStream = writer;
    }

    public void print(TestReport result, long runTime) {
        printHeader(runTime);
        printErrors(result);
        printFailures(result);
        printFooter(result);
    }

    private void printErrors(TestReport result) {
        printDefects(result.errors(), result.errorCount(), "error");
    }

    private void printHeader(long runTime) {
        getWriter().println();
        getWriter().println("Time: " + elapsedTimeAsString(runTime));
    }
    private void printFailures(TestReport result) {
        printDefects(result.failures(), result.failureCount(), "failure");
    }
    private void printAmountDefectsMessage(int count,String type){
        String verbtobe=(count==1)?("was "):("were ");
        String pluralsuffix=(count==1)?(""):("s");
        getWriter().println("There"+verbtobe + count + " " + type +pluralsuffix+":");
    }
    private void printDefects(Enumeration<TestFailure> failures, int count, String type) {
        for (int i = 1; failures.hasMoreElements(); i++) {
            printAmountDefectsMessage(count,type);
            printDefect(failures.nextElement(),i);
            count--;
        }
    }

    public void printDefect(TestFailure testFailure, int count) {
        printDefectHeader(testFailure, count);
        printDefectTrace(testFailure);
    }

    private void printDefectHeader(TestFailure testFailure, int count) {
        getWriter().print(count + ") " + testFailure.failedTest());
    }

    private void printDefectTrace(TestFailure testFailure) {
        getWriter().print(testFailure.trace());
    }

    private void printFooter(TestReport result) {
        getWriter().println();
        if (result.wasSuccessful()) {
            printSuccess(result);
        } else {
            printUnsuccess(result);
        }
        getWriter().println();
    }

    private void printUnsuccess(TestReport result) {
        getWriter().println("FAILURES!!!");
        getWriter().println("Tests run: " + result.runCount() +", Failures: " + result.failureCount());
    }

    private void printSuccess(TestReport result) {
        getWriter().print("OK");
        getWriter().println(" (" + result.runCount() + " test" + (result.runCount() == 1 ? "" : "s") + ")");
    }

    private String elapsedTimeAsString(long runTime) {
        return NumberFormat.getInstance().format((double) runTime / 1000);
    }
    public PrintStream getWriter() {
        return printStream;
    }
    public void addFailure(Test test, AssertionError t) {
        getWriter().print("F");
    }
    public void endTest(Test test) {}
    public void startTest(Test test) {
        getWriter().print(".");
        if (fColumn++ >= 40) {
            getWriter().println();
            fColumn = 0;
        }
    }

    @Override
    public void addError(Test test, Throwable exception) {
        getWriter().print("E");
    }
}
