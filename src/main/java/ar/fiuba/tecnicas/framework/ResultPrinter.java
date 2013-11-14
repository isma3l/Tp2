package ar.fiuba.tecnicas.framework;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;

public class ResultPrinter extends TestListener{
    PrintStream printStream;

    public ResultPrinter(PrintStream writer) {
        printStream = writer;
    }
    public void printFooter(TestReport result,long runTime) {
      insertHSeparator();
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
    public void addSuccess(TestCase test, String time) {
        printStream.println("[Ok]\t\t" + test + "\t\t" + time);
    }
    @Override
    public void insertHSeparator() {
        printStream.println();
        printStream.println("==================");
    }

    @Override
    public void addFailure(Test test, String time) {
        printStream.println("[Failure]\t" + test + "\t\t" + time);
    }
    @Override
    public void addError(Test test, String time) {
        printStream.println("[Error]\t\t" + test + "\t\t" + time);
    }

    @Override
    public void print(String messsage) {
        printStream.print(messsage);
    }
}
