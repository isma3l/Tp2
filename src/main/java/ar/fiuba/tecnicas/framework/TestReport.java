package ar.fiuba.tecnicas.framework;

import java.util.ArrayList;
import java.util.List;

public class TestReport {
    private List<TestListener> testListeners;
    private int runTests;
    private int oktest;
    private int errortest;
    private int failedtest;

    public void setFirsttimeintest(boolean firsttimeintest) {
        this.firsttimeintest = firsttimeintest;
    }

    private boolean firsttimeintest;

    public TestReport() {
        testListeners = new ArrayList<TestListener>();
        runTests = 0;
        oktest=0;
        errortest=0;
        failedtest=0;
        firsttimeintest=true;
    }
    public void startTest(Test test) {
        for (TestListener testlistener : testListeners) {
            testlistener.startTest(test);
        }
    }
    public void addSuccess(TestCase test) {
        runTests++;
        for (TestListener testListener : testListeners) {
            testListener.addSuccess(test,firsttimeintest);
        }
    }
    public void addFailure(Test test) {
        failedtest++;
        runTests++;
        for (TestListener testListener : testListeners) {
            testListener.addFailure(test,firsttimeintest);
        }
    }
    public void addError(Test test) {
        errortest++;
        runTests++;
        for (TestListener testListener : testListeners) {
            testListener.addError(test,firsttimeintest);
        }
    }
    public void printSuiteTrace(Test test){
        for (TestListener testListener : testListeners) {
            testListener.printSuiteTrace(test);
        }
    }
    public void print(String messsage){
        for (TestListener testListener : testListeners) {
            testListener.print(messsage);
        }
    }
    public void addListener(TestListener listener) {
        testListeners.add(listener);
    }
    public void removeListener(TestListener listener) {
        testListeners.remove(listener);
    }
    public void endTest(Test test) {
        for (TestListener testListener : testListeners) {
            testListener.endTest(test);
        }
    }
    protected void run(final TestCase test) {
        startTest(test);
        try {
            test.runTestSequence();
            addSuccess(test);
        } catch (AssertionError assertionError) {
            addFailure(test);
        } catch (Throwable exception) {
            addError(test);
        }

        endTest(test);
    }

    public boolean wasSuccessful() {
        return ( failureCount()== 0);
    }
    public int failureCount() {
        return failedtest;
    }
    public int runCount() {
        return runTests;
    }
    public int errorCount() {
        return errortest;
    }
}
